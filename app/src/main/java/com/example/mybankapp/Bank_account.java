package com.example.mybankapp;

public class Bank_account {
    private String id;
    private String accountName;
    private String iban;
    private String money;
    private String currency;

    public void Bank_accounts(String id,String name,String iban,String money,String currency){
        this.id=id;
        this.accountName=name;
        this.iban=iban;
        this.money=money;
        this.currency=currency;
    }
    public String getId() {
        return id;
    }
    public void setId(String i) {
        this.id=i;
    }


    public String getAccountName() {
        return accountName;
    }
    public void setAccountName(String n) {
        this.accountName=n;
    }


    public String getIban() {
        return iban;
    }
    public void setIban(String i) {
        this.iban=i;
    }


    public String getMoney() {
        return money;
    }
    public void setMoney(String i) {
        this.money=i;
    }


    public String getCurrency() {
        return currency;
    }
    public void setCurrency(String i) {
        this.currency=i;
    }

}
