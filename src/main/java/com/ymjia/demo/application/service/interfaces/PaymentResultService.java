package com.ymjia.demo.application.service.interfaces;

import com.ymjia.demo.application.model.PaymentResult;

import java.util.List;

/**
 * @author 1
 */
public interface PaymentResultService {

    Long insert(PaymentResult paymentResult) throws Exception;

    Long insertList(List<PaymentResult> paymentResults) throws Exception;

    Boolean delete(Long id) throws Exception;

    Boolean update(PaymentResult paymentResult) throws Exception;

    PaymentResult getObjectByOrigOrderId(String origOrderId) ;

    PaymentResult getObjectByOrigRequestSn(String origRequestSn) ;

    PaymentResult getObjectByOrigRequestSnId(String origRequestSn, String origOrderId) ;

}