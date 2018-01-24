package collectionHierarchy;

import collectionHierarchy.collections.AddCollection;
import collectionHierarchy.collections.AddRemoveCollection;
import collectionHierarchy.collections.MyList;
import collectionHierarchy.interfaces.IAdable;
import collectionHierarchy.interfaces.IRemovable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        IAdable collection1 = new AddCollection();
        IRemovable collection2 = new AddRemoveCollection();
        IRemovable collection3 = new MyList();
        String[] input = br.readLine().split("\\s+");
        int number = Integer.parseInt(br.readLine());

        addElementsToCollection(collection1, input);
        addElementsToCollection(collection2, input);
        addElementsToCollection(collection3, input);

        removeElementsFromCollection(collection2, number);
        removeElementsFromCollection(collection3, number);
    }

    private static void removeElementsFromCollection(IRemovable collection, int number) {
        for (int i = 0; i < number; i++) {
            System.out.print(collection.remove() + " ");
        }
        System.out.println();
    }

    private static void addElementsToCollection(IAdable collection, String[] input) {
        for (String s : input) {
            System.out.print(collection.add(s) + " ");
        }
        System.out.println();
    }
}
