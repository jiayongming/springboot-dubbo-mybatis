package com.ymjia.demo.application.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * Created by jiayongming on 2018/3/28.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class QrNoticeCommonIn implements Serializable{

    private static final long serialVersionUID = -3772662028198350170L;

    private Long id;

    @NotBlank(message = "version不可为空")
    @Length(min = 1,max = 6,message = "version(1-6)")
    private String version;

    @NotBlank(message = "tradeType不可为空")
    @Length(min = 4,max = 4,message = "tradeType(4)")
    private String tradeType;

    @NotBlank(message = "instCode不可为空")
    @Length(min = 6,max = 7,message = "instCode(7)")
    private String instCode;

    @NotBlank(message = "requestSn不可为空")
    @Length(min = 28,max = 32,message = "requestSn(30)")
    private String requestSn;

    @NotBlank(message = "timeStamp不可为空")
    @Length(min = 13,max = 15,message = "timeStamp(14)")
    private String timeStamp;

    @NotBlank(message = "encryptData不可为空")
    @Length(min = 1,max = 999,message = "encryptData(1-999)")
    private String encryptData;

    @NotBlank(message = "signature不可为空")
    private String signature;


    @NotBlank(message = "origOrderId不可为空")
    private String origOrderId;

    @NotBlank(message = "origRequestSn不可为空")
    private String origRequestSn;

    @NotBlank(message = "amt不可为空")
    private String amt;

    private String reqResvFld;

    private Long createAt;

    private Long updateAt;

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE );
    }

}
