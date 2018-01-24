package resources.P02_FileStream;

public class Main {
    public static void main(String[] args) {


        StreamProgressInfo info = new StreamProgressInfo(new File());
        info.calculateCurrentPercent();


        StreamProgressInfo infoFromWeb = new StreamProgressInfo(new Music());
    }
}
