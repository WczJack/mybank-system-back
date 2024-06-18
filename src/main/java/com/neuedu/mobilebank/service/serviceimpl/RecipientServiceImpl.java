package com.neuedu.mobilebank.service.serviceimpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.neuedu.mobilebank.mapper.AccountMapper;
import com.neuedu.mobilebank.mapper.RecipientMapper;
import com.neuedu.mobilebank.po.Account;
import com.neuedu.mobilebank.po.Recipient;
import com.neuedu.mobilebank.po.RecipientSub;
import com.neuedu.mobilebank.po.ResponseBean;
import com.neuedu.mobilebank.service.AccountService;
import com.neuedu.mobilebank.service.RecipientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class RecipientServiceImpl implements RecipientService {
    @Autowired
    private RecipientMapper rm;
    @Autowired
    private AccountService as;
    @Autowired
    private AccountMapper am;

    @Override
    public ResponseBean<List<RecipientSub>> findAll(Integer telId) {
        List<RecipientSub> list = rm.findAll(telId);
        ResponseBean<List<RecipientSub>> rb = null;
        if(list.size()>0){
            rb = new ResponseBean<>(list);
        }else{
            rb = new ResponseBean<>(801, "暂无收款人数据");
        }
        return rb;
    }

    @Override
    @Transactional
    public ResponseBean<Integer> addRecipient(Map<String, String> con) {
        //先要进行账号校验
        ResponseBean<Integer> result = as.findStatusId(con);
        //账号检验状态判断
        //如果检验通过就执行添加收款人数据过程
        if(result.getCode()==200){
            QueryWrapper<Account> qw = new QueryWrapper<>();
            qw.eq("accountName",con.get("accountName"));
            qw.select("id");
            Account account = am.selectOne(qw);
            Integer accountId = account.getId();
            //从前端货的手机号ID
            String telIdstr=con.get("telId");
            int telId=Integer.parseInt(telIdstr);
            //添加收款人记录
            Recipient r=new Recipient();
            r.setOtherId(accountId);
            r.setTelId(telId);
            Integer insertResult = rm.insert(r);
            ResponseBean<Integer> rb = new ResponseBean<>(insertResult);
            return rb;
            //检验未通过，则应提示前端业务错误信息
        }else{
            return result;
        }

    }

    @Override
    @Transactional
    public ResponseBean<Integer> updateRecipient(Map<String, String> con) {
    //先要进行账号校验
        ResponseBean<Integer> result = as.findStatusId(con);
        //账号检验状态判断
        //如果检验通过就执行添加收款人数据过程
        if(result.getCode()==200){
            QueryWrapper<Account> qw = new QueryWrapper<>();
            qw.eq("accountName",con.get("accountName"));
            qw.select("id");
            Account account = am.selectOne(qw);
            Integer accountId = account.getId();

            //获得要修改记录的主键
            String idstr=con.get("id");
            int id=Integer.parseInt(idstr);
            //添加收款人记录
            UpdateWrapper<Recipient> uw = new UpdateWrapper<>();
            uw.set("otherId",accountId);
            uw.eq("id", id);
            Integer updateResult = rm.update(null, uw);
            ResponseBean<Integer> rb = new ResponseBean<>(updateResult);
            return rb;
            //检验未通过，则应提示前端业务错误信息
        }else{
            return result;
        }
    }

    @Override
    public ResponseBean<Integer> removeRecipient(Integer recipientId) {
        Integer result = rm.deleteById(recipientId);
        ResponseBean<Integer> rb = new ResponseBean<>(result);
        return rb;
    }
}
