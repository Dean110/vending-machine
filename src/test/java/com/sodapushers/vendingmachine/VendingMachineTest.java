package com.sodapushers.vendingmachine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class VendingMachineTest {

    public static final String QUARTER = "Quarter";
    public static final String INSERT_COIN = "INSERT COIN";
    private VendingMachine underTest;

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
        underTest.insertCoin(QUARTER);
        String displayText = underTest.displayStatus();
        assertThat(displayText).isEqualTo("0.25");
    }
    @Test
    public void givenATwoQuartersInsertedIntoMachine_displayStatus_returnsValueOfCoinsInserted(){
        underTest.insertCoin(QUARTER);
        underTest.insertCoin(QUARTER);
        String displayText = underTest.displayStatus();
        assertThat(displayText).isEqualTo("0.50");
    }

}
