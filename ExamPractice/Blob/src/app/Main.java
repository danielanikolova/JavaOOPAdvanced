package app;

import app.engine.Engine;
import app.interfaces.*;
import app.interfaces.Runnable;
import app.io.ConsoleInputReader;
import app.repositories.BlobRepository;
import app.repositories.Repository;
import app.utilities.MutableBoolean;

public class Main {
    public static void main(String[] args) {

        InputReader reader = new ConsoleInputReader();
        OutputWriter writer = new ConsoleOutputWriter();
        Repository<Blob> blobRepository = new BlobRepository<>();
        MutableBoolean flag = new MutableBoolean();
        Runnable engine = new Engine(reader, writer, blobRepository, flag);

        engine.run();
    }
}
