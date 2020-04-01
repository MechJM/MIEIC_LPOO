package com.aor.refactoring.example4;

import java.util.HashSet;
import java.util.Set;

public class Supervisor extends Worker {
    Set<Worker> supervisee;
    
    public Supervisor(PersonalInfo personalInfo,LoginInfo loginInfo) {
        super(personalInfo,loginInfo);
        supervisee = new HashSet<>();
    }
    
    public void addSupervisee(Worker worker) {
        supervisee.add(worker);
    }

    public boolean isSupervisee(Worker worker) {
        return supervisee.contains(worker);
    }
}
