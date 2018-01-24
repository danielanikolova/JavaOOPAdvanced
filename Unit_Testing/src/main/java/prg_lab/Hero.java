package prg_lab;

import java.util.*;

public class Hero {

    private String name;
    private int experience;
    private Weapon weapon;
    private List<Weapon> inventory;

    public Hero(String name, Weapon weapon) {
        this.name = name;
        this.experience = 0;
        this.weapon = weapon;
        this.inventory = new ArrayList<Weapon>();
    }

    public String getName() {
        return this.name;
    }

    public int getExperience() {
        return this.experience;
    }

    public Weapon getWeapon() {
        return this.weapon;
    }

    public void attack(Target target, RandomProvider randomProvider) {
        this.weapon.attack( target);

        if (target.isDead()) {
            this.experience += target.giveExperience();
            this.inventory.add(target.giveWeapon(randomProvider));
        }
    }

    public Iterable<Weapon> getInventory(){

        return this.inventory;
    }

    public static void main(String[] args) {
        Weapon weapon = new Axe(10,10);
        Hero hero = new Hero("Gosho",weapon);
        List<Weapon> weapons = new ArrayList<Weapon>();
        Collections.addAll(weapons, new Axe(10,10), new Axe(20,20));
        Target target = new Dummy(10,10, weapons);

        hero.attack(target, new RandomProvider.Implementation());
        System.out.println();
    }
}
