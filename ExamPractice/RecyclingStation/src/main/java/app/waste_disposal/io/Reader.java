package app.waste_disposal.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Reader implements InputReader {

    private BufferedReader reader;

    public Reader() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String readLine() {
        String line = null;
        try {
            line = this.reader.readLine();
        } catch (IOException ignored) {
        }
        return line;
    }
}
