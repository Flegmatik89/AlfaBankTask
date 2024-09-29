package com.example.alfaTestTask.tests;

import com.example.alfaTestTask.tests.tests.LoginButtonTest;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Test suite for Login button tests")
@SelectClasses({
        LoginButtonTest.class
})
public class LoginButtonTestSuite {
}
