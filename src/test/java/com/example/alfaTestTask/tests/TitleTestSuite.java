package com.example.alfaTestTask.tests;

import com.example.alfaTestTask.tests.tests.TitleTest;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Test suite for title tests")
@SelectClasses({
        TitleTest.class
})
public class TitleTestSuite {
}
