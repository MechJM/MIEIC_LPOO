package com.aor.refactoring.example4;

import java.util.Objects;

public class LoginInfo {
    private final String username;
    private final String password;

    public LoginInfo(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null) return false;

        LoginInfo loginInfo = (LoginInfo) o;

        return this.username.equals(loginInfo.username) && this.password.equals(loginInfo.password);
    }
}
