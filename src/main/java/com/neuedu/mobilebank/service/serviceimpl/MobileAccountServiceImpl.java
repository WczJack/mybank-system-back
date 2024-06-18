package com.neuedu.mobilebank.service.serviceimpl;

import com.neuedu.mobilebank.mapper.MobileAccountMapper;
import com.neuedu.mobilebank.po.MobileAccount;
import com.neuedu.mobilebank.po.ResponseBean;
import com.neuedu.mobilebank.service.MobileAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MobileAccountServiceImpl implements MobileAccountService {
    @Autowired
    private MobileAccountMapper mam;

    @Override
    public ResponseBean<Integer> addRelatedAccount(MobileAccount ma) {
        Integer result = mam.insert(ma);
        ResponseBean<Integer> rb=new ResponseBean<>(result);
        return rb;
    }
}
