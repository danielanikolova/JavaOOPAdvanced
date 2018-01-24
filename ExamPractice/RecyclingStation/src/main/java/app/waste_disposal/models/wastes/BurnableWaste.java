package app.waste_disposal.models.wastes;

import app.waste_disposal.annotations.Burnable;


@Burnable
public class BurnableWaste extends BaseWaste {


    public BurnableWaste(String name, double weight, double volumePerKg) {
        super(name, weight, volumePerKg);
    }
}
