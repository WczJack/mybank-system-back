package com.neuedu.mobilebank.service.serviceimpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.neuedu.mobilebank.mapper.AccountMapper;
import com.neuedu.mobilebank.po.Account;
import com.neuedu.mobilebank.po.ResponseBean;
import com.neuedu.mobilebank.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountMapper am;

    @Override
    public ResponseBean<List<Account>> findRelatedAccountByTel(String telephone) {
        QueryWrapper<Account> qw = new QueryWrapper();
        qw.inSql("id", "select accountId from mobileaccount");
        qw.inSql("personId", "select id from personinfo where telephone=" + telephone);
        qw.eq("statusId", 1);
        List<Account> list = am.selectList(qw);
        ResponseBean<List<Account>> rb=null;
        if(list.size()>0){
            rb = new ResponseBean<>(list);
        }else{
            rb = new ResponseBean<>(810,"没有可以关联的账户");
        }
        return rb;
    }

    @Override
    public ResponseBean<List<Account>> findUnRelatedAccountByTel(String telephone) {
        QueryWrapper<Account> qw = new QueryWrapper();
        qw.notInSql("id", "select accountId from mobileaccount");
        qw.inSql("personId", "select id from personinfo where telephone=" + telephone);
        qw.eq("statusId", 1);
        List<Account> list = am.selectList(qw);
        ResponseBean<List<Account>> rb=null;
        if(list.size()>0){
            rb = new ResponseBean<>(list);
        }else{
            rb = new ResponseBean<>(810,"没有可以关联的账户");
        }
        return rb;
    }

    @Override
    public ResponseBean<Integer> findStatusId(Map<String, String> con) {
        QueryWrapper<Account> qw = new QueryWrapper<>();
        qw.eq("accountName", con.get("accountName"));
        qw.inSql("personId", "select id from personInfo where realname='" + con.get("realname") + "'");
        Account account = am.selectOne(qw);
        ResponseBean<Integer> rb=null;
        if(account!=null){
            Integer statusId = account.getStatusId();
            if(statusId>0){
                rb = new ResponseBean<>(statusId);
            }else{
                rb = new ResponseBean<>(810,"该账户已经冻结");
            }
        }else{
            rb=new ResponseBean<>(802,"账户和姓名不匹配");
        }
        return rb;
    }

    @Override
    public ResponseBean<Account> searchByAccountId(Integer accountId) {
        QueryWrapper<Account> qw = new QueryWrapper<>();
        qw.eq("id", accountId);
        qw.select("accountName", "balance");
        Account result = am.selectOne(qw);
        ResponseBean<Account> rb=new ResponseBean<>(result);
        return rb;
    }



}
