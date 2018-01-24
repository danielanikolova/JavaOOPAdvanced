package p01_system_resources;


import java.time.LocalTime;

public class LocalTimeProvider implements TimeProvider {


    @Override
    public int getHoer() {
        return LocalTime.now().getHour();
    }
}
