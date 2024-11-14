package com.neoteric.checkedException.enums;

import java.awt.font.TextHitInfo;

public enum TransferEnum {

    INSUFFICIENT_BALANCE("TS_1000","Insufficient balance in your account %s"),
    TRANSACTION_LIMIT_FAILED("104","TRANSACTION LIMIT FAILED");

    private String code;

    private String label;
    TransferEnum(String code,String label){
        this.code = code;
        this.label = label;


    }


    public String getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }
}
