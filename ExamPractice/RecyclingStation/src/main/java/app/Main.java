package app;

import app.waste_disposal.DefaultGarbageProcessor;
import app.waste_disposal.DefaultStrategyHolder;
import app.waste_disposal.contracts.GarbageProcessor;
import app.waste_disposal.contracts.StrategyHolder;
import app.waste_disposal.engines.CommandInterpreter;
import app.waste_disposal.engines.CommandInterpreterImpl;
import app.waste_disposal.engines.Engine;
import app.waste_disposal.io.InputReader;
import app.waste_disposal.io.OutputWriter;
import app.waste_disposal.io.Reader;
import app.waste_disposal.io.Writer;

public class Main {
    public static void main(String[] args) {

        InputReader reader = new Reader();
        OutputWriter writer = new Writer();
        StrategyHolder holder = new DefaultStrategyHolder();
        GarbageProcessor processor = new DefaultGarbageProcessor(holder);
        CommandInterpreter interpreter = new CommandInterpreterImpl(processor);
        Runnable engine = new Engine(reader, writer, interpreter);

        engine.run();
    }
}
