package com.aor.refactoring.example4;

import java.util.Objects;

public class Worker {
    private final LoginInfo loginInfo;
    private final PersonalInfo personalInfo;
    

    public Worker(PersonalInfo personalInfo,LoginInfo loginInfo) {
        this.loginInfo = loginInfo;
        this.personalInfo = personalInfo;
    }

    public String getName() {
        return personalInfo.getName();
    }

    public String getPhone() {
        return personalInfo.getPhone();
    }

    public LoginInfo getLoginInfo() {
        return loginInfo;
    }

    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return Objects.equals(this.loginInfo,worker.loginInfo) && Objects.equals(this.personalInfo,worker.personalInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loginInfo,personalInfo);
    }
}
