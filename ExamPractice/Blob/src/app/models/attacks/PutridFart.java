package app.models.attacks;

import app.interfaces.Attack;
import app.interfaces.Blob;

public class PutridFart implements Attack {

    @Override
    public void execute(Blob attacker, Blob target) {
        target.setHealth(target.getHealth() - attacker.getDamage());
    }
}
