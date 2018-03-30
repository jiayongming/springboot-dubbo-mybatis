package com.ymjia.demo.application.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ymjia.demo.application.mapper.ValidatePasswordMapper;
import com.ymjia.demo.application.model.PaymentResult;
import com.ymjia.demo.application.model.QrNoticeCommonIn;
import com.ymjia.demo.application.model.ValidatePassword;
import com.ymjia.demo.application.service.interfaces.ValidatePasswordService;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.dao.DuplicateKeyException;

import javax.annotation.Resource;
import java.util.List;

@Log4j2
@Service
public class ValidatePasswordServiceImpl implements ValidatePasswordService {

	@Resource
	private ValidatePasswordMapper validatePasswordMapper;

	@Resource
	private PaymentResultServiceImpl paymentResultService;

	@Override
	public Long insert(ValidatePassword validatePassword) {
		log.info("ValidatePasswordServiceImpl.insert ={}" , validatePassword);

		if (validatePassword == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		validatePassword.setCreateAt(currentTimeMillis);
		validatePassword.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			validatePasswordMapper.insertSelective(validatePassword);
			result = validatePassword.getId();
		} catch (DuplicateKeyException e) {
			validatePassword.setId(validatePasswordMapper.getObjectByRequestSn(validatePassword.getRequestSn()));
			validatePasswordMapper.updateByPrimaryKeySelective(validatePassword);
			return validatePassword.getId() ;

		} catch (Exception e){
			log.error(" insert wrong : {}" , validatePassword ,e);
			throw e ;
		}

		log.info(" insert data success : {}" , result);
		return result;
	}

	@Override
	public Long insertList(List<ValidatePassword> validatePasswords) {

		log.info(" insert lists : {}" , validatePasswords == null ? "null" : validatePasswords.size());
		if (CollectionUtils.isEmpty(validatePasswords)){
			return 0L ;
		}
		long count = 0 ;

		for (ValidatePassword validatePassword : validatePasswords) {
			Long result = this.insert(validatePassword);
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
			result = validatePasswordMapper.deleteByPrimaryKey(id) == 1;
		} catch (Exception e) {
			log.error(" delete wrong : {}" ,e);
		}
		log.info(" delete data success : {}" , id);
		return result;

	}

	@Override
	public Boolean update(ValidatePassword validatePassword) {

		log.info(" update data : {}" , validatePassword == null ? "null" : validatePassword.getId());

		if (validatePassword == null) {
			return true;
		}

		boolean result = false;
		validatePassword.setUpdateAt(System.currentTimeMillis());

		try {
			result = validatePasswordMapper.updateByPrimaryKeySelective(validatePassword) == 1;
		} catch (Exception e) {
			log.error(" update wrong : " ,e);
		}
		log.info(" update data success : {}" , validatePassword);
		return result;
	}

	@Override
	public ValidatePassword getObjectByOrigOrderId(String origOrderId) {
		log.info("getObjectByOrigOrderId:{}" ,origOrderId);
		return validatePasswordMapper.getObjectByOrigOrderId(origOrderId) ;
	}

	@Override
	public ValidatePassword getObjectByOrigRequestSn(String origRequestSn) {
		log.info("getObjectByOrigOrderId:{}" ,origRequestSn);
		return validatePasswordMapper.getObjectByOrigRequestSn(origRequestSn) ;
	}

	@Override
	public ValidatePassword getObjectByOrigRequestSnId(String origRequestSn, String origOrderId) {
		log.info("getObjectByOrigOrderId:{},{}" ,origRequestSn,origOrderId);
		return validatePasswordMapper.getObjectByOrigRequestSnId(origRequestSn ,origOrderId) ;
	}

    @Override
    public QrNoticeCommonIn getQrNoticeByOrigRequestSnId(String origRequestSn, String origOrderId) {
        final ValidatePassword validatePassword = this.getObjectByOrigRequestSnId(origRequestSn ,origOrderId) ;
		if (validatePassword != null){
			return validatePassword ;
		} else {
			log.info("getPaymentResultSnId:{},{}" ,origRequestSn,origOrderId);
			final PaymentResult paymentResult = paymentResultService.getObjectByOrigRequestSnId(origRequestSn, origOrderId);
            if (paymentResult != null){
                return paymentResult ;
            }
            return null ;
        }
    }

}
