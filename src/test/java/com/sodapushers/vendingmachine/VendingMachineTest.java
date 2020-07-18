package com.sodapushers.vendingmachine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class VendingMachineTest {

    public static final String QUARTER = "Quarter";
    public static final String INSERT_COIN = "INSERT COIN";
    private VendingMachine underTest;

    private void assertDisplayAfterInsertingCoins(String expectedDisplay, String... coinsToAdd) {
        addCoinsToVendingMachine(coinsToAdd);
        String displayText = underTest.displayStatus();
        assertThat(displayText).isEqualTo(expectedDisplay);
    }

    private void addCoinsToVendingMachine(String... coins){
        Arrays.stream(coins).forEach(underTest::insertCoin);
    }

    @BeforeEach
    void setUp() {
        underTest = new VendingMachine();
    }

    @Test
    public void givenNoCoinsInsertedIntoMachine_displayStatus_returnsInsertCoins() {
        String displayText = underTest.displayStatus();
        assertThat(displayText).isEqualTo(INSERT_COIN);
    }

    @Test
    public void givenASingleQuarterInsertedIntoMachine_displayStatus_returnsValueOfCoinsInserted() {
        assertDisplayAfterInsertingCoins("0.25", QUARTER);
    }
    @Test
    public void givenATwoQuartersInsertedIntoMachine_displayStatus_returnsValueOfCoinsInserted(){
        assertDisplayAfterInsertingCoins("0.50", QUARTER, QUARTER);
    }


}
