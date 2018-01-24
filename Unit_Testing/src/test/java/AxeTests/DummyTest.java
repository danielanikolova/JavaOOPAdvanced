package AxeTests;

import org.junit.Assert;
import org.junit.Test;
import prg_lab.Dummy;
import prg_lab.Weapon;

import java.util.ArrayList;

public class DummyTest {

    public static final int HEALTH = 10;

    @Test
    public void attackedTargetLoosesHealth() {

        Dummy dummy = new Dummy(HEALTH, 10, new ArrayList<Weapon>());

        dummy.takeAttack(5);

        Assert.assertTrue(dummy.getHealth() == 5);


    }

    @Test(expected = IllegalStateException.class)
    public void attackedTargetThrowExeption(){
        Dummy dummy = new Dummy(10, 10, new ArrayList<Weapon>());
       // dummy.takeAttack(15);

        dummy.takeAttack(15);


    }

    @Test
    public void testDeadDummyGiveExPWhileKilled(){

        Dummy dummy = new Dummy(10, 10, new ArrayList<Weapon>());
        dummy.takeAttack(15);

        Assert.assertTrue(dummy.giveExperience()==10);
    }



    @Test(expected = IllegalStateException.class)
    public void testAliveDummyNotGiveExp(){
        Dummy dummy = new Dummy(0, 10, new ArrayList<Weapon>());
        dummy.giveExperience();


    }
}
