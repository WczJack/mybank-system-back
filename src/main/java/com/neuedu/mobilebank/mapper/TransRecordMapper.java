package com.neuedu.mobilebank.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.neuedu.mobilebank.po.TransRecord;
import com.neuedu.mobilebank.po.TransRecordSub;

import java.util.List;

public interface TransRecordMapper extends BaseMapper<TransRecord> {
    List<TransRecordSub> findTransRecord(Integer accountId);
}
