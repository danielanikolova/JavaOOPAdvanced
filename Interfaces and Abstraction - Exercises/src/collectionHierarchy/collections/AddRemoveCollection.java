package collectionHierarchy.collections;

import collectionHierarchy.interfaces.IRemovable;

import java.util.ArrayList;
import java.util.List;

public class AddRemoveCollection implements IRemovable{

    private List<String> elements;

    public AddRemoveCollection() {
        this.elements = new ArrayList<>();
    }

    @Override
    public int add(String element) {
        elements.add(0, element);
        return elements.indexOf(element);
    }

    @Override
    public String remove() {
        return elements.remove(elements.size() - 1);
    }
}
