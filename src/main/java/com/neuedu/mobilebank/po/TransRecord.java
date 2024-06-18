package com.neuedu.mobilebank.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@TableName("transrecord")
public class TransRecord {
    //ID
    @TableId(type = IdType.AUTO)
    private Integer id;
    //借方ID
    private Integer accountId;
    //贷方ID
    private Integer otherId;
    //交易金额
    private Double money;
    //交易日期
    private String transDate;
    //交易类型
    private Integer transtypeId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getOtherId() {
        return otherId;
    }

    public void setOtherId(Integer otherId) {
        this.otherId = otherId;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getTransDate() {
        return transDate;
    }

    public void setTransDate(String transDate) {
        this.transDate = transDate;
    }

    public Integer getTranstypeId() {
        return transtypeId;
    }

    public void setTranstypeId(Integer transtypeId) {
        this.transtypeId = transtypeId;
    }
}



