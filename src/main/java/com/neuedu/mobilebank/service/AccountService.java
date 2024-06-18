package com.neuedu.mobilebank.service;

import com.neuedu.mobilebank.po.Account;
import com.neuedu.mobilebank.po.ResponseBean;

import java.util.List;
import java.util.Map;

public interface AccountService {
    //按手机号查询关联账户
    public ResponseBean<List<Account>> findRelatedAccountByTel(String telephone);

    //按手机号查询未关联账户
    public ResponseBean<List<Account>> findUnRelatedAccountByTel(String telephone);

    //按账号和客户真实姓名查询账户是否有效
    ResponseBean<Integer> findStatusId(Map<String, String> con);

    //按账号ID查询账号信息
    public ResponseBean<Account> searchByAccountId(Integer accountId);


 }
