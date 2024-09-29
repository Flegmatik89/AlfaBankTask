package com.example.alfaTestTask.components;

public interface ComponentsConstants {
    String ALFA_TITLE = "//*[@resource-id=\"com.alfabank.qapp:id/tvTitle\"]";
    String LOGIN_FIELD = "com.alfabank.qapp:id/etUsername";
    String PASS_FIELD = "//*[@resource-id=\"com.alfabank.qapp:id/etPassword\"]";
    String LOGIN_BUTTON = "//*[@text = 'Вход']";
    String SHOW_PASS = "//*[@content-desc=\"Show password\"]";
    String ERROR_MESSAGE_INVALID_CREDENTIALS = "//*[@resource-id=\"com.alfabank.qapp:id/tvError\"]";
    String LOGIN_SUCCESS_MESSAGE = "//*[@text = 'Вход в Alfa-Test выполнен']";
    String MAIN_FRAME = "//*[@resource-id=\"com.alfabank.qapp:id/nav_host_fragment_content_main\"]";
}