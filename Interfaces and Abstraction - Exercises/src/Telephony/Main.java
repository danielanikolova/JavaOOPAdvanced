package Telephony;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] phones = br.readLine().split("\\s+");
        String[] sites = br.readLine().split("\\s+");

        Pattern phonePattern = Pattern.compile("[0-9]*");
        Pattern sitePattern = Pattern.compile("[^0-9]*");

        Smartphone smartphone = new Smartphone();

        for (int i = 0; i < phones.length; i++) {
            Matcher matcher = phonePattern.matcher(phones[i]);
            if (matcher.matches()){
                System.out.println(smartphone.call()+ " " + phones[i]);
            }else {
                System.out.println("Invalid number!");
            }
        }

        for (int i = 0; i < sites.length; i++) {
            Matcher matcher = sitePattern.matcher(sites[i]);
            if (matcher.matches()){
                System.out.println(smartphone.browse()+ " " + sites[i] + "!");
            }else System.out.println("Invalid URL!");
        }

    }
}
