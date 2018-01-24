package app.waste_disposal.engines;

import app.waste_disposal.annotations.Burnable;
import app.waste_disposal.annotations.Recyclable;
import app.waste_disposal.annotations.Storable;
import app.waste_disposal.contracts.GarbageDisposalStrategy;
import app.waste_disposal.contracts.GarbageProcessor;
import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.contracts.Waste;
import app.waste_disposal.models.strategies.BurnableStrategy;
import app.waste_disposal.models.strategies.RecyclableStrategy;
import app.waste_disposal.models.strategies.StorableStrategy;
import app.waste_disposal.models.wastes.BurnableWaste;
import app.waste_disposal.models.wastes.RecyclableWaste;
import app.waste_disposal.models.wastes.StorableWaste;


import java.util.LinkedList;
import java.util.List;


public class CommandInterpreterImpl implements CommandInterpreter {

    private GarbageProcessor processor;
    private List<ProcessingData> processedWaste;


    public CommandInterpreterImpl(GarbageProcessor processor) {
        this.processor = processor;
        this.processedWaste = new LinkedList<>();
    }


    @Override
   public String processGarbage(List<String> params){

        String name = params.get(0);
        double weight =Double.parseDouble(params.get(1));
        double volumePerKg =Double.parseDouble(params.get(2));
        String type = params.get(3);
        Waste waste = null;

        switch (type){
            case"Recyclable":
                waste = new RecyclableWaste(name, weight, volumePerKg );
                break;
            case"Burnable":
                waste = new BurnableWaste(name, weight, volumePerKg );
                break;
            case"Storable":
                waste = new StorableWaste(name, weight, volumePerKg );

                break;
        }
        this.loadStrategy(waste);
        ProcessingData data = this.processor.processWaste(waste);
        this.processedWaste.add(data);
        return String.format("%.2f kg of %s successfully processed!", weight, name );

   }



    @Override
   public String processStatus(){

       double energy = 0;
       double  capital = 0;

       for (ProcessingData d:this.processedWaste) {
           energy+= d.getEnergyBalance();
           capital+=d.getCapitalBalance();
       }
        return String.format("Energy: %.2f Capital: %.2f", energy, capital);
   }

    private void loadStrategy(Waste waste) {
        GarbageDisposalStrategy strategy = null;
        Class annotation = null;
        switch (waste.getClass().getSimpleName()){
            case "BurnableWaste":
                strategy = new BurnableStrategy();
                annotation = Burnable.class;
                break;
            case "RecyclableWaste":
                strategy = new RecyclableStrategy();
                annotation = Recyclable.class;
                break;
            case "StorableWaste":
                strategy = new StorableStrategy();
                annotation = Storable.class;
                break;

        }

        if (strategy!=null){
            this.processor.getStrategyHolder().addStrategy(annotation, strategy);
        }

    }
}
