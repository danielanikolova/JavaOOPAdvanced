package p01_system_resources;


public class GreetingClock {

    private TimeProvider timeProvider;
    private Writer writer;

    public GreetingClock(TimeProvider time, Writer writer) {

        this.timeProvider = time;
        this.writer = writer;
    }

    public void greeting() {
        if (this.timeProvider.getHoer() < 12) {
            writer.write("Good morning...");

        } else if (this.timeProvider.getHoer() < 18) {
            writer.write("Good afternoon...");

        } else {
            writer.write("Good evening...");
        }
    }
}
