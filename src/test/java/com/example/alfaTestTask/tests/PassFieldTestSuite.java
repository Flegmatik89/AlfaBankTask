package com.example.alfaTestTask.tests;

import com.example.alfaTestTask.tests.tests.PassFieldTest;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Test suite for Password Field tests")
@SelectClasses({
        PassFieldTest.class
})
public class PassFieldTestSuite {
}
