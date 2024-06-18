package com.neuedu.mobilebank.controller;


import com.neuedu.mobilebank.po.RecipientSub;
import com.neuedu.mobilebank.po.ResponseBean;
import com.neuedu.mobilebank.service.RecipientService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/recipient")
public class RecipientController {
    @Autowired
    private RecipientService rs;

    @GetMapping("/findAll")
    public ResponseBean<List<RecipientSub>> findAll(Integer telId){
        return rs.findAll(telId);
    }

//添加收款方信息
    @PostMapping("/addRecipient")
    public ResponseBean<Integer> addRecipient(@RequestBody Map<String, String> con){
        return rs.addRecipient(con);
    }
    //修改收款方信息
    @PostMapping("/updateRecipient")
    public ResponseBean<Integer> updateRecipient(@RequestBody Map<String, String> con){
        return rs.updateRecipient(con);
    }
    //删除收款方信息
    @PostMapping("/removeRecipient")
    public ResponseBean<Integer> removeRecipient(Integer recipientId){
        return rs.removeRecipient(recipientId);
    }
}
