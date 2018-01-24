package app.utilities;


public class MutableBoolean {
    private boolean flag;

    public MutableBoolean() {
        this.flag = false;
    }

    public boolean isFlag() {
        return this.flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
