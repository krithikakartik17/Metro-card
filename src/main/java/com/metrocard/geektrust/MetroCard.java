package com.metrocard.geektrust;
class MetroCard {
    private final float serviceCharge = 0.02f;
    int cardNo, balance;
    public MetroCard(int cardNo, int balance) {
        this.cardNo = cardNo;
        this.balance = balance;
    }
    int deductBalance(int cost) {
        balance = balance - cost;
        return balance;
    }
    int autoRecharge(int amount) {
        balance = balance + amount;
        float recharge_fee = serviceCharge * amount;
        return (int)recharge_fee;
    }
}