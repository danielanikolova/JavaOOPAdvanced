package hell.commands;

import java.util.List;

public interface CommandInterpreter {

    String createHero(List<String> params);
    String createItem(List<String> params);
    String createRecipe(List<String> params);
    String inspectCommand(List<String> param) throws NoSuchMethodException, IllegalAccessException;
    String quitCommand();



}
