package com.example.alfaTestTask.tests;

import com.example.alfaTestTask.tests.tests.LoginFieldTest;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Test suite for Login Field tests")
@SelectClasses({
        LoginFieldTest.class
})
public class LoginFieldTestSuite {
}
