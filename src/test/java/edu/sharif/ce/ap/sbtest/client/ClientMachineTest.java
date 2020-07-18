package edu.sharif.ce.ap.sbtest.client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientMachineTest {
    @Autowired
    private ClientMachine clientMachine;

    @Test
    public void registerTest(){
        clientMachine.createRegisterRequest();
    }
}
