package com.ymjia.demo.application.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ymjia.demo.application.mapper.RefundResultMapper;
import com.ymjia.demo.application.model.RefundResult;
import com.ymjia.demo.application.service.interfaces.RefundResultService;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.dao.DuplicateKeyException;

import javax.annotation.Resource;
import java.util.List;

@Log4j2
@Service
public class RefundResultServiceImpl implements RefundResultService {

	@Resource
	private RefundResultMapper refundResultMapper;

	@Override
	public Long insert(RefundResult refundResult) {
		log.info("RefundResultServiceImpl.insert ={}" , refundResult);

		if (refundResult == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		refundResult.setCreateAt(currentTimeMillis);
		refundResult.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			refundResultMapper.insertSelective(refundResult);
			result = refundResult.getId();
		} catch (DuplicateKeyException e) {
			refundResult.setId(refundResultMapper.getObjectByRequestSn(refundResult.getRequestSn()));
			refundResultMapper.updateByPrimaryKeySelective(refundResult);
			return refundResult.getId() ;

		} catch (Exception e){
			log.error(" insert wrong : {}" , refundResult ,e);
			throw e ;
		}

		log.info(" insert data success : {}" , result);
		return result;
	}

	@Override
	public Long insertList(List<RefundResult> refundResults) {

		log.info(" insert lists : {}" , refundResults == null ? "null" : refundResults.size());
		if (CollectionUtils.isEmpty(refundResults)){
			return 0L ;
		}
		long count = 0 ;

		for (RefundResult refundResult : refundResults) {
			Long result = this.insert(refundResult);
			if (result != null && result > 0) {
				count++;
			}
		}

		return count;

	}

	@Override
	public Boolean delete(Long id) {

		log.info(" delete data : {}" , id);

		if (id == null) {
			return true;
		}

		boolean result = false;
		try {
			result = refundResultMapper.deleteByPrimaryKey(id) == 1;
		} catch (Exception e) {
			log.error(" delete wrong : {}" ,e);
		}
		log.info(" delete data success : {}" , id);
		return result;

	}

	@Override
	public Boolean update(RefundResult refundResult) {

		log.info(" update data : {}" , refundResult == null ? "null" : refundResult.getId());

		if (refundResult == null) {
			return true;
		}

		boolean result = false;
		refundResult.setUpdateAt(System.currentTimeMillis());

		try {
			result = refundResultMapper.updateByPrimaryKeySelective(refundResult) == 1;
		} catch (Exception e) {
			log.error(" update wrong : " ,e);
		}
		log.info(" update data success : {}" , refundResult);
		return result;
	}

	@Override
	public RefundResult getObjectByOrigOrderId(String origOrderId) {
		log.info("getObjectByOrigOrderId:{}" ,origOrderId);
		return refundResultMapper.getObjectByOrigOrderId(origOrderId) ;
	}

	@Override
	public RefundResult getObjectByOrigRequestSn(String origRequestSn) {
		log.info("getObjectByOrigOrderId:{}" ,origRequestSn);
		return refundResultMapper.getObjectByOrigRequestSn(origRequestSn) ;
	}

	@Override
	public RefundResult getObjectByOrigRequestSnId(String origRequestSn, String origOrderId) {
		log.info("getObjectByOrigOrderId:{},{}" ,origRequestSn,origOrderId);
		return refundResultMapper.getObjectByOrigRequestSnId(origRequestSn ,origOrderId) ;
	}

}
