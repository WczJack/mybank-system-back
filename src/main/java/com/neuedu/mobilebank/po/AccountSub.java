package com.neuedu.mobilebank.po;

public class AccountSub extends Account{
    //建立客户关系和账户信息的多对一关系，客户信息是一，账户信息为多
    private PersonInfo personInfo;

    public PersonInfo getPersonInfo() {
        return personInfo;
    }
    public void setPersonInfo(PersonInfo personInfo) {
        this.personInfo = personInfo;
    }
}
