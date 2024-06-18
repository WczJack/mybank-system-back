package com.neuedu.mobilebank.po;

public class RecipientSub extends Recipient{
    private AccountSub accountSub;

    public AccountSub getAccountSub() {
        return accountSub;
    }

    public void setAccountSub(AccountSub accountSub) {
        this.accountSub = accountSub;
    }
}
