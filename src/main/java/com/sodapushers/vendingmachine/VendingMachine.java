package com.sodapushers.vendingmachine;

public class VendingMachine {
    private boolean hasCoin;

    public String displayStatus() {
        if(hasCoin){
            return "0.25";
        }
        return "INSERT COIN";
    }

    public void insertCoin(String coin) {
        hasCoin = true;
    }
}
