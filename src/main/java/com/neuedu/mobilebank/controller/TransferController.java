package com.neuedu.mobilebank.controller;


import com.neuedu.mobilebank.po.ResponseBean;
import com.neuedu.mobilebank.po.Transfer;
import com.neuedu.mobilebank.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfer")
public class TransferController {
    @Autowired
    private TransferService ts;

    @PostMapping("/trans")
    public ResponseBean<Integer> transfer(@RequestBody Transfer data) {
        return ts.transfer(data);
    }
}
