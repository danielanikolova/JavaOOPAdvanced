public class Main {
    public static void main(String[] args) {
        Handler combatLogger = new CombatLogger();
        Handler errorLogger = new ErrorLogger();
        Handler eventLogger = new EventLogger();

        combatLogger.setSuccessor(eventLogger);
        errorLogger.setSuccessor(errorLogger);

        AttackGroup group = new Group();
        group.addMember(new Warrior("Gosho", 10, combatLogger));
        group.addMember(new Warrior("Stamat", 15, combatLogger));

        ObservableTarget dragon = new Dragon("Miro", 10, 100, combatLogger);

        Executor commandExecutor = new CommandExecutor();

        Command groupTargetCommand = new GroupTargetCommand(group, dragon);
        Command groupAttack = new GroupAttackCommand(group);
        commandExecutor.executeCommand(groupTargetCommand);
        commandExecutor.executeCommand(groupAttack);

    }
    }
}
