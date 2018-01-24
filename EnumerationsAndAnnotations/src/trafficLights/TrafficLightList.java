package trafficLights;

import java.util.Iterator;

public class TrafficLightList implements Iterator<TrafficLight>{

    private TrafficLight trafficLight;

    public TrafficLightList(TrafficLight trafficLight) {
        this.trafficLight = trafficLight;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public TrafficLight next() {
        switch (this.trafficLight.name()) {
            case "RED":
                this.trafficLight = TrafficLight.valueOf("GREEN");
                break;
            case "GREEN":
                this.trafficLight = TrafficLight.valueOf("YELLOW");
                break;
            default:
                this.trafficLight = TrafficLight.valueOf("RED");
                break;
        }
        return this.trafficLight;
    }
}
