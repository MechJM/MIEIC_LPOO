package com.aor.refactoring.example4;

import org.junit.Test;

import static org.junit.Assert.*;

public class WorkerTest {

    @Test
    public void testWorker() {
        PersonalInfo personalInfo = new PersonalInfo("John Doe","+1 222-22222");
        LoginInfo loginInfo = new LoginInfo("john","secret");
        Worker worker = new Worker(personalInfo,loginInfo);
        assertEquals("John Doe", worker.getName());
        assertEquals("+1 222-22222", worker.getPhone());
        assertFalse(worker.getLoginInfo().login(new LoginInfo("john", "wrong")));
        assertTrue(worker.getLoginInfo().login(loginInfo));
    }

    @Test
    public void testSupervisor() {
        LoginInfo loginInfo = new LoginInfo("john","secret");
        Supervisor supervisor = new Supervisor(new PersonalInfo("John Doe","+1 222-22222"),loginInfo);


        Worker minion1 = new Worker(new PersonalInfo("Minion 1", "+1 123-12345"), new LoginInfo("minion1", "1234"));
        Worker minion2 = new Worker(new PersonalInfo("Minion 2", "+1 123-12345"),new LoginInfo("minion2", "1234"));
        supervisor.addSupervisee(minion1);


        assertEquals("John Doe", supervisor.getName());
        assertEquals("+1 222-22222", supervisor.getPhone());
        assertFalse(supervisor.getLoginInfo().login(new LoginInfo("john", "wrong")));
        assertTrue(supervisor.getLoginInfo().login(loginInfo));
        assertTrue(supervisor.isSupervisee(minion1));
        assertFalse(supervisor.isSupervisee(minion2));
    }

    @Test
    public void testClient() {
        Client client = new Client(new PersonalInfo("John Doe", "+1 222-22222"));
        assertEquals("John Doe", client.getName());
        assertEquals("+1 222-22222", client.getPhone());
    }
}