package app.waste_disposal.engines;

import java.util.List;

public interface CommandInterpreter {
    String processGarbage(List<String> params);

    String processStatus();
}
