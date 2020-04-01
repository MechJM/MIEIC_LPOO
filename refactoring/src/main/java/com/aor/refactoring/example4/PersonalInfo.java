package com.aor.refactoring.example4;

import java.util.Objects;

public class PersonalInfo {
    private final String name;
    private final String phone;

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public PersonalInfo(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (o == null) return false;

        PersonalInfo personalInfo = (PersonalInfo) o;

        return personalInfo.name.equals(this.name) && personalInfo.phone.equals(this.phone);
    }
}
