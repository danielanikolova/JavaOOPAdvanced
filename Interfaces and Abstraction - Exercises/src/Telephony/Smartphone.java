package Telephony;

public class Smartphone implements Browseble, Callable{


    Smartphone() {
    }

    @Override
    public String browse() {
        return "Browsing:";
    }

    @Override
    public String call() {
        return "Calling...";
    }
}
