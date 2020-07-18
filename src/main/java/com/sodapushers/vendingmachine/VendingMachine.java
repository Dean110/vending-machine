package com.sodapushers.vendingmachine;

import java.math.BigDecimal;

public class VendingMachine {

    private BigDecimal coinSlotBalance = BigDecimal.ZERO;

    public String displayStatus() {
        if (coinSlotBalance.doubleValue() == 0) {
            return "INSERT COIN";
        }
        return coinSlotBalance.toString();
    }

    public void insertCoin(String coin) {
        if (coin.equalsIgnoreCase("Quarter")) {
            coinSlotBalance = coinSlotBalance.add(BigDecimal.valueOf(.25));
        }else {
            coinSlotBalance = coinSlotBalance.add(BigDecimal.valueOf(.05));
        }
    }
}
