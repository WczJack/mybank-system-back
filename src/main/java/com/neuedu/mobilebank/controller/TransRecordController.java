package com.neuedu.mobilebank.controller;


import com.neuedu.mobilebank.po.ResponseBean;
import com.neuedu.mobilebank.po.TransRecordSub;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transrecord")
public class TransRecordController {
    public ResponseBean<List<TransRecordSub>> findTransRecord(Integer accountId) {
        return null;
    }
}
