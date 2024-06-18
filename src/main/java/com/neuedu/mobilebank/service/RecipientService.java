package com.neuedu.mobilebank.service;

import com.neuedu.mobilebank.po.RecipientSub;
import com.neuedu.mobilebank.po.ResponseBean;

import java.util.List;
import java.util.Map;

public interface RecipientService {
    public ResponseBean<List<RecipientSub>> findAll(Integer telId);


    public ResponseBean<Integer> addRecipient(Map<String, String> con);
    public ResponseBean<Integer> updateRecipient(Map<String, String> con);
    public ResponseBean<Integer> removeRecipient(Integer recipientId);
}
