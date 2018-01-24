package app.interfaces;


public interface Blob {
    int getInitialDamage();

    int getHealth();

    void setHealth(int health);

    int getDamage();

    void setDamage(int currentDamage);

    Behavior getBehavior();

    String getName();

    void attack(Blob target);

    void update();

    void attach(Observer observer);

}
