package com.ymjia.demo.application.service.interfaces;

import com.ymjia.demo.application.model.RefundResult;

import java.util.List;

/**
 * @author 1
 */
public interface RefundResultService {

    Long insert(RefundResult refundResult) throws Exception;

    Long insertList(List<RefundResult> refundResults) throws Exception;

    Boolean delete(Long id) throws Exception;

    Boolean update(RefundResult refundResult) throws Exception;

    RefundResult getObjectByOrigOrderId(String origOrderId) ;

    RefundResult getObjectByOrigRequestSn(String origRequestSn) ;

    RefundResult getObjectByOrigRequestSnId(String origRequestSn, String origOrderId) ;

}