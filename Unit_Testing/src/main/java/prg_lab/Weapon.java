package prg_lab;

public interface Weapon {

    int getAttackPoints();
    int getDurabilityPoints();
    void attack(Target target);
}