package com.ymjia.demo.application.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ymjia.demo.application.mapper.PaymentResultMapper;
import com.ymjia.demo.application.model.PaymentResult;
import com.ymjia.demo.application.service.interfaces.PaymentResultService;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.dao.DuplicateKeyException;

import javax.annotation.Resource;
import java.util.List;

@Log4j2
@Service
public class PaymentResultServiceImpl implements PaymentResultService {

	@Resource
	private PaymentResultMapper paymentResultMapper;

	@Override
	public Long insert(PaymentResult paymentResult) {
		log.info("PaymentResultServiceImpl.insert ={}" , paymentResult);

		if (paymentResult == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		paymentResult.setCreateAt(currentTimeMillis);
		paymentResult.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			paymentResultMapper.insertSelective(paymentResult);
			result = paymentResult.getId();
		} catch (DuplicateKeyException e) {
			paymentResult.setId(paymentResultMapper.getObjectByRequestSn(paymentResult.getRequestSn()));
			paymentResultMapper.updateByPrimaryKeySelective(paymentResult);
			return paymentResult.getId() ;
		} catch (Exception e){
			log.error(" insert wrong : {}" , paymentResult ,e);
			throw e ;
		}
		/*
		 * 更新交易订单
		 */
		log.info(" insert data success : {}" , result);
		return result;
	}

	@Override
	public Long insertList(List<PaymentResult> paymentResults) {

		log.info(" insert lists : {}" , paymentResults == null ? "null" : paymentResults.size());
		if (CollectionUtils.isEmpty(paymentResults)){
			return 0L ;
		}
		long count = 0 ;

		for (PaymentResult paymentResult : paymentResults) {
			Long result = this.insert(paymentResult);
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
			result = paymentResultMapper.deleteByPrimaryKey(id) == 1;
		} catch (Exception e) {
			log.error(" delete wrong : {}" ,e);
		}
		log.info(" delete data success : {}" , id);
		return result;

	}

	@Override
	public Boolean update(PaymentResult paymentResult) {

		log.info(" update data : {}" , paymentResult == null ? "null" : paymentResult.getId());

		if (paymentResult == null) {
			return true;
		}

		boolean result = false;
		paymentResult.setUpdateAt(System.currentTimeMillis());

		try {
			result = paymentResultMapper.updateByPrimaryKeySelective(paymentResult) == 1;
		} catch (Exception e) {
			log.error(" update wrong : " ,e);
		}
		log.info(" update data success : {}" , paymentResult);
		return result;
	}

	@Override
	public PaymentResult getObjectByOrigOrderId(String origOrderId) {
		log.info("getObjectByOrigOrderId:{}" ,origOrderId);
		return paymentResultMapper.getObjectByOrigOrderId(origOrderId) ;
	}

	@Override
	public PaymentResult getObjectByOrigRequestSn(String origRequestSn) {
		log.info("getObjectByOrigOrderId:{}" ,origRequestSn);
		return paymentResultMapper.getObjectByOrigRequestSn(origRequestSn) ;
	}

	@Override
	public PaymentResult getObjectByOrigRequestSnId(String origRequestSn, String origOrderId) {
		log.info("getObjectByOrigOrderId:{},{}" ,origRequestSn,origOrderId);
		return paymentResultMapper.getObjectByOrigRequestSnId(origRequestSn ,origOrderId) ;
	}

}
