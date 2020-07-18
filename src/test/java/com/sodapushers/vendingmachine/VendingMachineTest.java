package com.sodapushers.vendingmachine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class VendingMachineTest {

    private VendingMachine underTest;

    @BeforeEach
    void setUp() {
        underTest = new VendingMachine();
    }

    @Test
    public void givenNoCoinsInsertedIntoMachine_displayStatus_returnsInsertCoins() {
        String displayText = underTest.displayStatus();
        assertThat(displayText).isEqualTo("INSERT COIN");
    }

    @Test
    public void givenASingleQuarterInsertedIntoMachine_displayStatus_returnsValueOfCoinsInserted() {
        underTest.insertCoin("Quarter");
        String displayText = underTest.displayStatus();
        assertThat(displayText).isEqualTo("0.25");
    }
}
