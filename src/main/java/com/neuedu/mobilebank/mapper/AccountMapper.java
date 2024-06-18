package com.neuedu.mobilebank.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.neuedu.mobilebank.po.Account;
import com.neuedu.mobilebank.po.ResponseBean;

import java.util.List;
import java.util.Map;

public interface AccountMapper extends BaseMapper<Account> {
    //按手机号查询关联账户
    List<Account> findRelatedAccount(String telephone);

    //按手机号查询未关联账户
    List<Account> findUnRelatedAccount(String telephone);


}
