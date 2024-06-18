package com.neuedu.mobilebank.service;

import com.neuedu.mobilebank.po.ResponseBean;
import com.neuedu.mobilebank.po.TransRecordSub;

import java.util.List;

public interface TransRecordService {
    public ResponseBean<List<TransRecordSub>> findTransRecord(Integer accountId);
}
