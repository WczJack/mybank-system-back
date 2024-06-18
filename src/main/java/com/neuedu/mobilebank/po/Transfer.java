package com.neuedu.mobilebank.po;

public class Transfer {
    //转账的支出方
    private Account zhuanchu;
    //转账的收入方法
    private Account zhuanru;

    public Account getZhuanchu() {
        return zhuanchu;
    }

    public void setZhuanchu(Account zhuanchu) {
        this.zhuanchu = zhuanchu;
    }

    public Account getZhuanru() {
        return zhuanru;
    }

    public void setZhuanru(Account zhuanru) {
        this.zhuanru = zhuanru;
    }
}
