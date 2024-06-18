package com.neuedu.mobilebank.service;

import com.neuedu.mobilebank.po.ResponseBean;
import com.neuedu.mobilebank.po.Transfer;

public interface TransferService {

    public ResponseBean<Integer> transfer(Transfer data);
}
