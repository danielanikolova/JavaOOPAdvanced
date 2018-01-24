package app.models.behavors;

import app.interfaces.Behavior;
import app.interfaces.Blob;

public abstract class AbstractBehavior implements Behavior {

    private boolean isTriggered;

    protected AbstractBehavior() {
    }

    @Override
    public boolean isTriggered() {
        return this.isTriggered;
    }

    protected void setIsTriggered(boolean isTriggered) {
        this.isTriggered = isTriggered;
    }


}
