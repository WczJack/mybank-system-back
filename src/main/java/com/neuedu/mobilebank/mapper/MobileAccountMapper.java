package com.neuedu.mobilebank.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.neuedu.mobilebank.po.MobileAccount;
import com.neuedu.mobilebank.po.ResponseBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


public interface MobileAccountMapper extends BaseMapper<MobileAccount> {
}
