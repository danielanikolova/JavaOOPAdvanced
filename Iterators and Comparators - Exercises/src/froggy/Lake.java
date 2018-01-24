package froggy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer>{

    private int[] jumps;

    public Lake(int[] jumps) {
        this.jumps = jumps;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

    private class Frog implements Iterator<Integer> {

        private int index;
        private List<Integer>indexes;

        public Frog() {
            this.index =0;
            this.setIndexes();
        }

        private void setIndexes() {

            this.indexes = new ArrayList<>();

            for (int i = 0; i < jumps.length; i+=2) {
                this.indexes.add(jumps[i]);
            }
            for (int i = 1; i < jumps.length; i+=2) {
                this.indexes.add(jumps[i]);
            }
        }

        @Override
        public boolean hasNext() {
            return this.index<this.indexes.size();
        }

        @Override
        public Integer next() {
            return this.indexes.get(this.index++);
        }
    }
}
