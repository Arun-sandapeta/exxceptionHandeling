package com.neoteric.checkedException.enums;

public enum PaymentStatusEnum {

    SUCCESS("Transaction is success"),
    FAILED("Transaction is failed"),

    FAILED_DAILY_LIMIT(" Daily limit exceeded "),
    PENDING("Transaction is in-progress");

    private String label;

    PaymentStatusEnum(String label){
        this.label=label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
