package enums;

import utils.ConfigManager;

public enum UsersCredentials {
    LOGIN(ConfigManager.getPropertyTestData("login")),
    PASS(ConfigManager.getPropertyTestData("pass"));
    private final String creed;

    UsersCredentials(String cred) {
        this.creed = cred;
    }

    public String getCreeds() {
        return creed;
    }
}
