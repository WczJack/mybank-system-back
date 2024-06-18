package com.neuedu.mobilebank.service;

import com.neuedu.mobilebank.po.MobileAccount;
import com.neuedu.mobilebank.po.ResponseBean;

public interface MobileAccountService {
    public ResponseBean<Integer> addRelatedAccount(MobileAccount ma);
}
