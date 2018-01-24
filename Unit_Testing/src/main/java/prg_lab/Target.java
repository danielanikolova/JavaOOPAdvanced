package prg_lab;

/**
 * Created by danie on 12/1/2017.
 */
public interface Target {
    int getHealth();

    void takeAttack(int attackPoints);

    int giveExperience();

    boolean isDead();

    Weapon giveWeapon(RandomProvider randomProvider);
}
