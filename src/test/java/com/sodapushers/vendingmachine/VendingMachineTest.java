package com.sodapushers.vendingmachine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class VendingMachineTest {

    public static final String QUARTER = "Quarter";
    public static final String INSERT_COIN = "INSERT COIN";
    private VendingMachine underTest;

    private void assertDisplayAfterInsertingCoins(String expectedDisplay, String... coinsToAdd) {
        initializeVendingMachine();
        addCoinsToVendingMachine(coinsToAdd);
        String displayText = underTest.displayStatus();
        assertThat(displayText).isEqualTo(expectedDisplay);
    }

    private void initializeVendingMachine() {
        underTest = new VendingMachine();
    }

    private void addCoinsToVendingMachine(String... coins) {
        Arrays.stream(coins).forEach(underTest::insertCoin);
    }

    @BeforeEach
    void setUp() {
        initializeVendingMachine();
    }

    @Test
    public void givenNoCoinsInsertedIntoMachine_displayStatus_returnsInsertCoins() {
        String displayText = underTest.displayStatus();
        assertThat(displayText).isEqualTo(INSERT_COIN);
    }

    @Test
    @DisplayName("displayStatus() returns the value of the accepted coins in the vending machine.")
    public void givenANewlyInstantiatedVendingMachine_CoinsInsertedChangeTheDisplay() {
        assertAll("Display does not match inserted coin value.",
                () -> assertDisplayAfterInsertingCoins("0.25", QUARTER),
                () -> assertDisplayAfterInsertingCoins("0.50", QUARTER, QUARTER),
                () -> assertDisplayAfterInsertingCoins("0.05", "Nickel")
        );
    }
}
