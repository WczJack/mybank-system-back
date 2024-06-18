package com.neuedu.mobilebank.service.serviceimpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.neuedu.mobilebank.mapper.AccountMapper;
import com.neuedu.mobilebank.mapper.TransRecordMapper;
import com.neuedu.mobilebank.po.Account;
import com.neuedu.mobilebank.po.ResponseBean;
import com.neuedu.mobilebank.po.TransRecord;
import com.neuedu.mobilebank.po.Transfer;
import com.neuedu.mobilebank.service.TransferService;
import com.neuedu.mobilebank.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class TransferServiceImpl implements TransferService {

    @Autowired
    private AccountMapper am;
    @Autowired
    private TransRecordMapper trm;

    @Override
    @Transactional
    public ResponseBean<Integer> transfer(Transfer data) {
        ResponseBean<Integer> rb=null;
        Account zhuanchu=data.getZhuanchu();
        QueryWrapper<Account> qw=new QueryWrapper<>();
        qw.eq("id",zhuanchu.getId());
        qw.eq("password",zhuanchu.getPassword());
        long result = am.selectCount(qw);
        if(result>0){
            //转入方增加金额
            Account zhuanru= data.getZhuanru();
            UpdateWrapper<Account> uw=new UpdateWrapper<>();
            uw.eq("id",zhuanru.getId());
            uw.setSql("balance=balance+"+zhuanru.getBalance());
            am.update(null,uw);
            //转出方减少金额
            UpdateWrapper<Account> uw2=new UpdateWrapper<>();
            uw2.eq("id",zhuanchu.getId());
            uw2.setSql("balance=balance-"+zhuanchu.getBalance());
            am.update(null,uw2);
            //增加交易记录
            TransRecord tr=new TransRecord();
            //封装转入方账号ID
            tr.setAccountId(zhuanru.getId());
            //封装转出方账号ID
            tr.setOtherId(zhuanchu.getId());
            //封装转账金额
            tr.setMoney(zhuanru.getBalance());
            //封装转账日期
            String now= DateUtil.dateFormat(new Date());
            tr.setTransDate(now);
            //封装交易类型        转账写死为2
            tr.setTranstypeId(2);
            //调用Mapper层增加数据的方法
            Integer addResult=trm.insert(tr);
            rb=new ResponseBean<>(addResult);
        }else{
            rb=new ResponseBean<>(801,"交易密码错误");
        }
        return rb;
    }
}
