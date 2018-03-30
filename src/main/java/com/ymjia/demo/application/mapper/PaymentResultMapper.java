package com.ymjia.demo.application.mapper;

import com.ymjia.demo.application.example.PaymentResultExample;
import com.ymjia.demo.application.model.PaymentResult;
import com.ymjia.demo.application.sqlprovider.PaymentResultSqlProvider;
import org.apache.ibatis.annotations.Arg;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface PaymentResultMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table payment_result
     *
     * @mbg.generated
     */
    @SelectProvider(type=PaymentResultSqlProvider.class, method="countByExample")
    long countByExample(PaymentResultExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table payment_result
     *
     * @mbg.generated
     */
    @DeleteProvider(type=PaymentResultSqlProvider.class, method="deleteByExample")
    int deleteByExample(PaymentResultExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table payment_result
     *
     * @mbg.generated
     */
    @Delete({
        "delete from payment_result",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table payment_result
     *
     * @mbg.generated
     */
    @Insert({
        "insert into payment_result (id, version, ",
        "trade_type, inst_code, ",
        "request_sn, time_stamp, ",
        "encrypt_data, signature, ",
        "orig_order_id, orig_request_sn, ",
        "status, order_desc, ",
        "voucher_no, amt, ",
        "real_amt, disc_amt, ",
        "coupon_id, coupon_desc, ",
        "coupon_type, payee_id, ",
        "payee_name, req_resv_fld, ",
        "create_at, update_at)",
        "values (#{id,jdbcType=BIGINT}, #{version,jdbcType=VARCHAR}, ",
        "#{tradeType,jdbcType=VARCHAR}, #{instCode,jdbcType=VARCHAR}, ",
        "#{requestSn,jdbcType=VARCHAR}, #{timeStamp,jdbcType=VARCHAR}, ",
        "#{encryptData,jdbcType=VARCHAR}, #{signature,jdbcType=VARCHAR}, ",
        "#{origOrderId,jdbcType=VARCHAR}, #{origRequestSn,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=VARCHAR}, #{orderDesc,jdbcType=VARCHAR}, ",
        "#{voucherNo,jdbcType=VARCHAR}, #{amt,jdbcType=VARCHAR}, ",
        "#{realAmt,jdbcType=VARCHAR}, #{discAmt,jdbcType=VARCHAR}, ",
        "#{couponId,jdbcType=VARCHAR}, #{couponDesc,jdbcType=VARCHAR}, ",
        "#{couponType,jdbcType=VARCHAR}, #{payeeId,jdbcType=VARCHAR}, ",
        "#{payeeName,jdbcType=VARCHAR}, #{reqResvFld,jdbcType=VARCHAR}, ",
        "#{createAt,jdbcType=BIGINT}, #{updateAt,jdbcType=BIGINT})"
    })
    int insert(PaymentResult record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table payment_result
     *
     * @mbg.generated
     */
    @InsertProvider(type=PaymentResultSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insertSelective(PaymentResult record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table payment_result
     *
     * @mbg.generated
     */
    @SelectProvider(type=PaymentResultSqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="id", javaType=Long.class, jdbcType=JdbcType.BIGINT, id=true),
        @Arg(column="version", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="trade_type", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="inst_code", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="request_sn", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="time_stamp", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="encrypt_data", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="signature", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="orig_order_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="orig_request_sn", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="status", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="order_desc", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="voucher_no", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="amt", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="real_amt", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="disc_amt", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="coupon_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="coupon_desc", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="coupon_type", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="payee_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="payee_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="req_resv_fld", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="create_at", javaType=Long.class, jdbcType=JdbcType.BIGINT),
        @Arg(column="update_at", javaType=Long.class, jdbcType=JdbcType.BIGINT)
    })
    List<PaymentResult> selectByExample(PaymentResultExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table payment_result
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "id, version, trade_type, inst_code, request_sn, time_stamp, encrypt_data, signature, ",
        "orig_order_id, orig_request_sn, status, order_desc, voucher_no, amt, real_amt, ",
        "disc_amt, coupon_id, coupon_desc, coupon_type, payee_id, payee_name, req_resv_fld, ",
        "create_at, update_at",
        "from payment_result",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ConstructorArgs({
        @Arg(column="id", javaType=Long.class, jdbcType=JdbcType.BIGINT, id=true),
        @Arg(column="version", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="trade_type", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="inst_code", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="request_sn", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="time_stamp", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="encrypt_data", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="signature", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="orig_order_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="orig_request_sn", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="status", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="order_desc", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="voucher_no", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="amt", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="real_amt", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="disc_amt", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="coupon_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="coupon_desc", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="coupon_type", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="payee_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="payee_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="req_resv_fld", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="create_at", javaType=Long.class, jdbcType=JdbcType.BIGINT),
        @Arg(column="update_at", javaType=Long.class, jdbcType=JdbcType.BIGINT)
    })
    PaymentResult selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table payment_result
     *
     * @mbg.generated
     */
    @UpdateProvider(type=PaymentResultSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") PaymentResult record, @Param("example") PaymentResultExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table payment_result
     *
     * @mbg.generated
     */
    @UpdateProvider(type=PaymentResultSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") PaymentResult record, @Param("example") PaymentResultExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table payment_result
     *
     * @mbg.generated
     */
    @UpdateProvider(type=PaymentResultSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PaymentResult record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table payment_result
     *
     * @mbg.generated
     */
    @Update({
        "update payment_result",
        "set version = #{version,jdbcType=VARCHAR},",
          "trade_type = #{tradeType,jdbcType=VARCHAR},",
          "inst_code = #{instCode,jdbcType=VARCHAR},",
          "request_sn = #{requestSn,jdbcType=VARCHAR},",
          "time_stamp = #{timeStamp,jdbcType=VARCHAR},",
          "encrypt_data = #{encryptData,jdbcType=VARCHAR},",
          "signature = #{signature,jdbcType=VARCHAR},",
          "orig_order_id = #{origOrderId,jdbcType=VARCHAR},",
          "orig_request_sn = #{origRequestSn,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=VARCHAR},",
          "order_desc = #{orderDesc,jdbcType=VARCHAR},",
          "voucher_no = #{voucherNo,jdbcType=VARCHAR},",
          "amt = #{amt,jdbcType=VARCHAR},",
          "real_amt = #{realAmt,jdbcType=VARCHAR},",
          "disc_amt = #{discAmt,jdbcType=VARCHAR},",
          "coupon_id = #{couponId,jdbcType=VARCHAR},",
          "coupon_desc = #{couponDesc,jdbcType=VARCHAR},",
          "coupon_type = #{couponType,jdbcType=VARCHAR},",
          "payee_id = #{payeeId,jdbcType=VARCHAR},",
          "payee_name = #{payeeName,jdbcType=VARCHAR},",
          "req_resv_fld = #{reqResvFld,jdbcType=VARCHAR},",
          "create_at = #{createAt,jdbcType=BIGINT},",
          "update_at = #{updateAt,jdbcType=BIGINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(PaymentResult record);

    @Select("select * from payment_result where orig_order_id = #{0} limit 1")
    PaymentResult getObjectByOrigOrderId(String origOrderId);

    @Select("select * from payment_result where orig_request_sn = #{0} limit 1")
    PaymentResult getObjectByOrigRequestSn(String origRequestSn);

    @Select("select * from payment_result where orig_request_sn = #{0} and orig_order_id = #{1} limit 1")
    PaymentResult getObjectByOrigRequestSnId(String origRequestSn, String origOrderId);

    @Select("select id from payment_result where request_sn = #{0} limit 1")
    Long getObjectByRequestSn(String requestSn);
}