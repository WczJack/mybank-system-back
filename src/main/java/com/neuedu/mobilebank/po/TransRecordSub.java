package com.neuedu.mobilebank.po;

public class TransRecordSub extends TransRecord{
    //交易的借方
    private AccountSub accountSubA;
    //交易的贷方
    private AccountSub accountSubB;

    public AccountSub getAccountSubA() {
        return accountSubA;
    }

    public void setAccountSubA(AccountSub accountSubA) {
        this.accountSubA = accountSubA;
    }

    public AccountSub getAccountSubB() {
        return accountSubB;
    }

    public void setAccountSubB(AccountSub accountSubB) {
        this.accountSubB = accountSubB;
    }
}
