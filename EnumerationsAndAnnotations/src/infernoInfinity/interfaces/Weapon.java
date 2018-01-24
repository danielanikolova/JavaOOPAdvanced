package infernoInfinity.interfaces;

import infernoInfinity.enums.GemType;

public interface Weapon extends Comparable<Weapon>{

     void addGem(int index, GemType gem);

     void removeGem(int index);

     int compareTo(Weapon w);

     double getItemLevel();


}
