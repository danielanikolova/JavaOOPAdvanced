package infernoInfinity.classes;

import infernoInfinity.annotations.CustomAnnotation;
import infernoInfinity.enums.GemType;
import infernoInfinity.enums.WeaponType;
import infernoInfinity.interfaces.Weapon;

@CustomAnnotation
public class WeaponImpl implements Weapon, Comparable<Weapon>{

    private GemType[] gems;
    private WeaponType weaponType;
    private String name;

    public WeaponImpl(WeaponType weaponType, String name) {
        this.setWeaponType(weaponType);
        this.setGems();
        this.setName(name);
    }

    private void setGems() {
        this.gems = new GemType[this.weaponType.getSockets()];
    }

    private void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    private void setName(String name) {
        this.name = name;
    }

    private int getTotalMinDamage() {
        int totalBonus = this.getTotalBonus(2, 1);
        return this.weaponType.getMinDamage() + totalBonus;
    }

    private int getTotalMaxDamage() {
        int totalBonus = this.getTotalBonus(3, 4);
        return this.weaponType.getMaxDamage() + totalBonus;
    }

    private int getTotalBonus(int multiplier1, int multiplier2) {
        int strengthBonus = 0;
        for (GemType gem : this.gems) {
            if (gem != null) {
                strengthBonus += gem.getStrength() * multiplier1;
            }
        }

        int agilityBonus = 0;
        for (GemType gem : this.gems) {
            if (gem != null) {
                agilityBonus += gem.getAgility() * multiplier2;
            }
        }

        return strengthBonus + agilityBonus;
    }

    private int getTotalStrength() {
        int totalStrength = 0;
        for (GemType gem : this.gems) {
            if (gem != null) {
                totalStrength += gem.getStrength();
            }
        }
        return totalStrength;
    }

    private int getTotalAgility() {
        int totalAgility = 0;
        for (GemType gem : this.gems) {
            if (gem != null) {
                totalAgility += gem.getAgility();
            }
        }
        return totalAgility;
    }

    private int getTotalVitality() {
        int totalVitality = 0;
        for (GemType gem : this.gems) {
            if (gem != null) {
                totalVitality += gem.getVitality();
            }
        }
        return totalVitality;
    }

    @Override
    public void addGem(int index, GemType gem) {

        try {
            this.gems[index] = gem;
        } catch (IndexOutOfBoundsException ignored){}
    }

    @Override
    public void removeGem(int index) {
        try {
            this.gems[index] = null;
        } catch (IndexOutOfBoundsException ignored){}
    }

    @Override
    public int compareTo(Weapon o) {
        return Double.compare(this.getItemLevel(), o.getItemLevel());
    }

    @Override
    public double getItemLevel() {
        return ((this.getTotalMinDamage() + this.getTotalMaxDamage()) / 2.0) + this.getTotalAgility()
                + this.getTotalStrength() + this.getTotalVitality();
    }

    @Override
    public String toString() {
        return this.name + ": " + this.getTotalMinDamage() + "-" + this.getTotalMaxDamage() + " Damage, +"
                + this.getTotalStrength() + " Strength, +" + this.getTotalAgility() + " Agility, +" +
                this.getTotalVitality() + " Vitality";
    }
}
