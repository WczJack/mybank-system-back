package com.neuedu.mobilebank.service.serviceimpl;

import com.neuedu.mobilebank.po.ResponseBean;
import com.neuedu.mobilebank.po.TransRecordSub;
import com.neuedu.mobilebank.service.TransRecordService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TransRecordServiceImpl implements TransRecordService {
    @Override
    public ResponseBean<List<TransRecordSub>> findTransRecord(Integer accountId) {
        return null;
    }
}
