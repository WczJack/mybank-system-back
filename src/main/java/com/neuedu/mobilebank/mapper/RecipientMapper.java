package com.neuedu.mobilebank.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.neuedu.mobilebank.po.Recipient;
import com.neuedu.mobilebank.po.RecipientSub;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RecipientMapper extends BaseMapper<Recipient> {

    @Select("""
    <script>
        SELECT r.id,p.realname,a.id recipientId,a.accountName FROM recipient r,account a,personinfo p
        <where>
                    r.otherId=a.id
                  AND
                    a.personId=p.id
                  AND
                    r.telId=#{telId}
        </where>
    </script>
    """)
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "accountSub.id", column = "recipientId"),
            @Result(property = "accountSub.personInfo.realname", column = "realname"),
            @Result(property = "accountSub.accountName", column = "accountName")
    })
    public List<RecipientSub> findAll(Integer telId);
}
