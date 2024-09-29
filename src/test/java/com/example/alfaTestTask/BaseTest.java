package com.example.alfaTestTask;



import com.codeborne.selenide.logevents.SelenideLogger;

import com.example.alfaTestTask.driver.EmulatorDriver;
import com.example.alfaTestTask.utility.Utils;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import io.qameta.allure.selenide.AllureSelenide;
import com.example.alfaTestTask.listeners.AllureListener;
import com.example.alfaTestTask.stepdefinitions.MainWindowSteps;
import com.example.alfaTestTask.stepdefinitions.SuccessWindowSteps;


@ExtendWith(AllureListener.class)
public class BaseTest {
    protected Utils utils = new Utils();
    public static final String ENTERED_VALUE_VALID = "DFG.df' , / _ gfg-hf";
    public static final String FIFTY_ONE_CHARACTERS =
            "kjdhfgERUTHERGkjnvbcjfd iurtiuSDFS lopweweuhdsn HRF";
    public static final String INVALID_AND_VALID_CHARACTERS =
            "kjdhfgERUTHERGkjnvbcjfd iurtiuSDFS lopweweuhdsn HR!@#";

    @BeforeAll
    protected static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        EmulatorDriver.setUpApp();
    }

    @BeforeEach
    public void beforeEach() {
        EmulatorDriver.startApp();
    }

    @AfterEach
    public void afterEach() {
        EmulatorDriver.getMobileDriver().closeApp();
    }

    @AfterAll
    public static void afterAll() {
        EmulatorDriver.clearApp();
    }

    /**
     * Экземпляры страниц
     */
    protected MainWindowSteps mainWindowSteps = new MainWindowSteps();
    protected SuccessWindowSteps successWindowSteps = new SuccessWindowSteps();

}
