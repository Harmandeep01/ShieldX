package com.example.shieldx;

import android.widget.EditText;

public class transactions {

    String accountNum;
    String amountNum;

    public transactions(EditText accountNum, EditText amountNum) {
        this.accountNum = accountNum;
        this.amountNum = amountNum;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public String getAmountNum() {
        return amountNum;
    }
}
