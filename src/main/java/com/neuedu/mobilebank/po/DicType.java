package com.neuedu.mobilebank.po;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DicType {
    //ID
    private Integer dicTypeId;
    //字典分类编码
    private Integer dicTypeCode;
    //字典分类名称
    private String dicTypeName;

    public Integer getDicTypeId() {
        return dicTypeId;
    }

    public void setDicTypeId(Integer dicTypeId) {
        this.dicTypeId = dicTypeId;
    }

    public Integer getDicTypeCode() {
        return dicTypeCode;
    }

    public void setDicTypeCode(Integer dicTypeCode) {
        this.dicTypeCode = dicTypeCode;
    }

    public String getDicTypeName() {
        return dicTypeName;
    }

    public void setDicTypeName(String dicTypeName) {
        this.dicTypeName = dicTypeName;
    }
}
