package infernoInfinity.classes;

import infernoInfinity.annotations.CustomAnnotation;
import infernoInfinity.enums.GemType;
import infernoInfinity.enums.WeaponType;
import infernoInfinity.interfaces.CommandExecutor;
import infernoInfinity.interfaces.Weapon;

import java.text.DecimalFormat;
import java.util.HashMap;

public class CommandInterpreter implements CommandExecutor{

    private HashMap<String, Weapon> weapons;
    private Class<WeaponImpl> weaponClass;
    private OutputWriter writer;

    public CommandInterpreter() {
        this.weapons = new HashMap<>();
        this.weaponClass = WeaponImpl.class;
        this.writer = new OutputWriter();
    }

    @Override
    public void executeCommand(String[] command) {

        switch (command[0]) {
            case "Create":
                weapons.put(command[2], new WeaponImpl(WeaponType.valueOf(command[1].toUpperCase()), command[2]));
                break;
            case "Add":
                weapons.get(command[1]).addGem(Integer.valueOf(command[2]), GemType.valueOf(command[3].toUpperCase()));
                break;
            case "Remove":
                weapons.get(command[1]).removeGem(Integer.valueOf(command[2]));
                break;
            case "Print":
                writer.print(weapons.get(command[1]).toString());
                break;

            case "Compare":
                Weapon weapon1 = weapons.get(command[1]);
                Weapon weapon2 = weapons.get(command[2]);
                DecimalFormat df = new DecimalFormat("0.0");
                if (weapon1.compareTo(weapon2) < 0) {
                    writer.print(weapon2 + " (Item Level: " + df.format(weapon2.getItemLevel()) + ")");
                } else {
                    writer.print(weapon1 + " (Item Level: " + df.format(weapon1.getItemLevel()) + ")");
                }
                break;
            case "Author":
                writer.print("Author: "+ weaponClass.getAnnotation(CustomAnnotation.class).author());
                break;
            case "Revision":
                writer.print("Revision: "+ weaponClass.getAnnotation(CustomAnnotation.class).revision());
                break;
            case "Description":
                writer.print("Class description: "+ weaponClass.getAnnotation(CustomAnnotation.class).description());
                break;
            case "Reviewers":
                writer.print("Reviewers: " + weaponClass.getAnnotation(CustomAnnotation.class).reviewers());
                break;

        }
    }
}
