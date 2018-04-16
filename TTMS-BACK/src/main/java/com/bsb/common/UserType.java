package com.bsb.common;

public enum UserType {
    Admin("管理员", 1), Manager("经理", 2), Clerk("售票员", 3), User("用户", 4);

    private String accountType;
    private Integer type;

    UserType(String accountType, Integer type) {
        this.accountType = accountType;
        this.type = type;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
