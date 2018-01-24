package app.waste_disposal.models.wastes;


import app.waste_disposal.annotations.Recyclable;


@Recyclable
public class RecyclableWaste extends BaseWaste {


    public RecyclableWaste(String name, double weight, double volumePerKg) {
        super(name, weight, volumePerKg);
    }
}
