package AxeTests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import prg_lab.Axe;
import prg_lab.Dummy;
import prg_lab.Target;
import prg_lab.Weapon;

import java.util.ArrayList;

public class AxeTests {

    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 10;
    private static final int DUMMY_HEALTH = 10;
    private static final int DUMMY_EXPERIENCE = 10;
    private static final int EXPECTED_DURABILITY = -1;

    private Weapon axe;
    private Target dummy;

    @Before
    public void initializeTestObjects(){
        this.axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE,new ArrayList<Weapon>() );
    }

    @Test
    public void weaponLosesDurabilityAfterAttack(){

        this.axe.attack(this.dummy);

        Assert.assertEquals("Wrong durability", EXPECTED_DURABILITY, this.axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void brokenWeaponCantAttack() {

        while (this.axe.getDurabilityPoints()>0){
            this.axe.attack(this.dummy);
        }
        axe.attack(dummy);

    }
}
