package app.waste_disposal.models.wastes;

import app.waste_disposal.annotations.Storable;


@Storable
public class StorableWaste extends BaseWaste {


    public StorableWaste(String name, double weight, double volumePerKg) {
        super(name, weight, volumePerKg);
    }
}
