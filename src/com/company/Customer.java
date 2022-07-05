package com.company;


public class Customer {

    private String tcNo;
    private int birthdDay;
    private int birthMonth;
    private int birthYear;
    private String password;
    private double balance;
    private double cardDept;
    private double limitCreditCard;
    private double creditDept;

    public Customer(String tcNo, int birthdDay, int birthMonth, int birthYear, String password, double balance, double cardDept, double limitCreditCard, double creditDept) {
        this.tcNo = tcNo;
        this.birthdDay = birthdDay;
        this.birthMonth = birthMonth;
        this.birthYear = birthYear;
        this.password = password;
        this.balance = balance;
        this.cardDept = cardDept;
        this.limitCreditCard = limitCreditCard;
        this.creditDept = creditDept;
    }

    public String getTcNo() {
        return tcNo;
    }

    public void setTcNo(String tcNo) {
        this.tcNo = tcNo;
    }

    public int getBirthdDay() {
        return birthdDay;
    }

    public void setBirthdDay(int birthdDay) {
        this.birthdDay = birthdDay;
    }

    public int getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(int birthMonth) {
        this.birthMonth = birthMonth;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getCardDept() {
        return cardDept;
    }

    public void setCardDept(double creditCard) {
        this.cardDept = cardDept;
    }

    public double getLimitCreditCard() {
        return limitCreditCard;
    }

    public void setLimitCreditCard(double limitCreditCard) {
        this.limitCreditCard = limitCreditCard;
    }


    public double getCreditDept() {
        return creditDept;
    }

    public void setCreditDept(double creditDept) {
        this.creditDept = creditDept;
    }
}
