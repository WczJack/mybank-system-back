package com.neuedu.mobilebank.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.neuedu.mobilebank.po.Mobile;
import com.neuedu.mobilebank.po.ResponseBean;

public interface MobileService {
    public ResponseBean<String> login(Mobile mobile) throws JsonProcessingException ;

    //检查手机号是否注册过
    public Long checkMobileReged(String telephone);
    //注册手机号的方法
    public ResponseBean<Integer> regMobile(Mobile mobile);

}
