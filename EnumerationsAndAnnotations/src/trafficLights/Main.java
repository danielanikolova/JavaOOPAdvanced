package trafficLights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] trafficLights = br.readLine().split("\\s+");
        List<TrafficLightList>trafficLightList = new ArrayList<>();
        
        int N = Integer.parseInt(br.readLine());

        for (String light:trafficLights) {
            TrafficLight current = TrafficLight.valueOf(light);
            TrafficLightList currentLight = new TrafficLightList(current);
            trafficLightList.add(currentLight);
        }

        for (int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder();
            for (TrafficLightList t:trafficLightList) {
                sb.append(t.next()).append(" ");
            }
            System.out.println(sb.toString().trim());

        }
    }
}
