package com.neuedu.mobilebank.controller;


import com.neuedu.mobilebank.po.Account;
import com.neuedu.mobilebank.po.ResponseBean;
import com.neuedu.mobilebank.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Resource
    private AccountService as;

    //按手机号查询关联账户
    @GetMapping("/findRelatedAccountByTel")
    public ResponseBean<List<Account>> findRelatedAccountByTel(String telephone){

        return as.findRelatedAccountByTel(telephone);
    }

    @GetMapping("/findUnRelatedAccountByTel")
    //按手机号查询未关联账户
    public ResponseBean<List<Account>> findUnRelatedAccountByTel(String telephone){

        return as.findUnRelatedAccountByTel(telephone);
    }

    //按账号和客户真实姓名验证账号是否有效
    public ResponseBean<Integer> findStatusId(Map<String,String> con){

        return as.findStatusId(con);
    }

    //按账号ID查询账号功能
    @GetMapping("/searchByAccountId")
    public ResponseBean<Account> searchByAccountId(Integer accountId){
        return as.searchByAccountId(accountId);
    }


}
