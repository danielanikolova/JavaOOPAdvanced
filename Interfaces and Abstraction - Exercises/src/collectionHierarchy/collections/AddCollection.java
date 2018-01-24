package collectionHierarchy.collections;

import collectionHierarchy.interfaces.IAdable;

import java.util.ArrayList;
import java.util.List;

public class AddCollection implements IAdable{

    private List<String> elements;

    public AddCollection() {
        this.elements = new ArrayList<>();
    }

    @Override
    public int add(String element) {
        this.elements.add(element);
        return this.elements.size() - 1;
    }
}
