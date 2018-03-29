package com.ymjia.demo.application.service.interfaces;

import com.ymjia.demo.application.model.QrNoticeCommonIn;
import com.ymjia.demo.application.model.ValidatePassword;

import java.util.List;

/**
 * @author 1
 */
public interface ValidatePasswordService {

    Long insert(ValidatePassword validatePassword) throws Exception;

    Long insertList(List<ValidatePassword> validatePasswords) throws Exception;

    Boolean delete(Long id) throws Exception;

    Boolean update(ValidatePassword validatePassword) throws Exception;

    ValidatePassword getObjectByOrigOrderId(String origOrderId) ;

    ValidatePassword getObjectByOrigRequestSn(String origRequestSn) ;

    ValidatePassword getObjectByOrigRequestSnId(String origRequestSn, String origOrderId) ;

    QrNoticeCommonIn getQrNoticeByOrigRequestSnId(String origRequestSn, String origOrderId) ;

}