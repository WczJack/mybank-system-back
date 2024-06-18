package com.neuedu.mobilebank.controller;

import com.neuedu.mobilebank.po.MobileAccount;
import com.neuedu.mobilebank.po.ResponseBean;
import com.neuedu.mobilebank.service.MobileAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mobileaccount")

public class MobileAccountController {
    @Autowired
    private MobileAccountService mas;

    //添加手机号和账户的关联信息
    @PostMapping("/addRelatedAccount")
    public ResponseBean<Integer> addRelatedAccount(MobileAccount ma) {
        return mas.addRelatedAccount(ma);
    }
}
