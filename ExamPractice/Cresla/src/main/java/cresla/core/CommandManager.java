package cresla.core;

import cresla.entities.containers.ModuleContainer;
import cresla.interfaces.Identifiable;
import cresla.interfaces.Reactor;
import cresla.models.modules.CooldownSystem;
import cresla.models.modules.CryogenRod;
import cresla.models.modules.HeatProcessor;
import cresla.models.reaktors.CryoReactor;
import cresla.models.reaktors.HeatReactor;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CommandManager implements Manager {

    private int id;
    private Map<Integer, Reactor> reactors;
    private Map<Integer, Identifiable> modules;

    public CommandManager() {
        this.id = 1;
        this.reactors = new LinkedHashMap<>();
        this.modules = new LinkedHashMap<>();
    }

    @Override
    public String reactorCommand(List<String> arguments) {

        String result = null;
        String type = arguments.get(0);
        int additionalParameter =Integer.parseInt(arguments.get(1));
        int moduleCapacity =Integer.parseInt(arguments.get(2));

        switch (type){
            case "Cryo":
                CryoReactor cryoReactor = new CryoReactor(this.id, new ModuleContainer(moduleCapacity), additionalParameter);
                this.reactors.put(this.id, cryoReactor);
                result =  "Created Cryo Reactor - " + this.id++ +"\n";
                break;
            case "Heat":
                HeatReactor heatReactor = new HeatReactor(this.id, new ModuleContainer(moduleCapacity), additionalParameter);
                this.reactors.put(this.id, heatReactor);
                result =  "Created Heat Reactor - " + this.id++ +"\n";
                break;
        }

           return result;

    }

    @Override
    public String moduleCommand(List<String> arguments) {
        int reactorId = Integer.parseInt(arguments.get(0));
        String type = arguments.get(1);
        int additionalParameter =Integer.parseInt(arguments.get(2));


        switch (type){
            case "CryogenRod":
               CryogenRod cryogenRod = new CryogenRod(this.id, additionalParameter);
                this.reactors.get(reactorId).addEnergyModule(cryogenRod);
                this.modules.put(this.id, cryogenRod);
                break;
            case "HeatProcessor":
                HeatProcessor heatProcessor = new HeatProcessor(this.id, additionalParameter);
                this.reactors.get(reactorId).addAbsorbingModule(heatProcessor);
                this.modules.put(this.id, heatProcessor);
                break;
            case "CooldownSystem":
                CooldownSystem cooldownSystem = new CooldownSystem(this.id, additionalParameter);
                this.reactors.get(reactorId).addAbsorbingModule(cooldownSystem);
                this.modules.put(this.id, cooldownSystem);
                break;
        }



        return String.format("Added %s - %d to Reactor - %d\n", type, this.id++, reactorId );
    }

    @Override
    public String reportCommand(List<String> arguments) {

        int reportedId = Integer.parseInt(arguments.get(0));
        if (this.reactors.containsKey(reportedId)){
            Reactor reactor = this.reactors.get(reportedId);
            return reactor.toString();
        }else {
            Identifiable module = this.modules.get(reportedId);
            return module.toString();
        }

    }

    @Override
    public String exitCommand(List<String> arguments) {
        long cryoReactorsCout = this.reactors.entrySet().stream()
                .filter(r->r.getValue().getClass().getSimpleName().equalsIgnoreCase("CryoReactor")).count();
        long heatReactorsCount= this.reactors.entrySet().stream()
                .filter(r->r.getValue().getClass().getSimpleName().equalsIgnoreCase("HeatReactor")).count();
        long energyModulesCount = this.modules.entrySet().stream()
                .filter(m->m.getValue().getClass().getSimpleName().equalsIgnoreCase("CryogenRod")).count();
        long absorbingModulesCount = this.modules.entrySet().stream()
                .filter(m->!m.getValue().getClass().getSimpleName().equalsIgnoreCase("CryogenRod")).count();
        long totalEnergyOutput = this.reactors.entrySet().stream()
                .mapToLong(r->r.getValue().getTotalEnergyOutput()).sum();
        long totalHeatAbsorbing = this.reactors.entrySet().stream()
                .mapToLong(r->r.getValue().getTotalHeatAbsorbing()).sum();


        return "Cryo Reactors: "+cryoReactorsCout+"\n" +
                "Heat Reactors: "+heatReactorsCount+"\n" +
                "Energy Modules: "+energyModulesCount +"\n" +
                "Absorbing Modules: "+absorbingModulesCount+"\n" +
                "Total Energy Output: "+totalEnergyOutput+"\n" +
                "Total Heat Absorbing: "+totalHeatAbsorbing+"\n";
    }
}
