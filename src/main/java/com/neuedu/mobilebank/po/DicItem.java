package com.neuedu.mobilebank.po;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DicItem {
    //字典条目ID
    private Integer dicItemId;
    //字典分类编码
    private Integer dicTypeCode;
    //字典条目编码
    private Integer dicItemCode;
    //字典条目名称
    private String dicItemName;

    public Integer getDicItemId() {
        return dicItemId;
    }

    public void setDicItemId(Integer dicItemId) {
        this.dicItemId = dicItemId;
    }

    public Integer getDicTypeCode() {
        return dicTypeCode;
    }

    public void setDicTypeCode(Integer dicTypeCode) {
        this.dicTypeCode = dicTypeCode;
    }

    public Integer getDicItemCode() {
        return dicItemCode;
    }

    public void setDicItemCode(Integer dicItemCode) {
        this.dicItemCode = dicItemCode;
    }

    public String getDicItemName() {
        return dicItemName;
    }

    public void setDicItemName(String dicItemName) {
        this.dicItemName = dicItemName;
    }
}
