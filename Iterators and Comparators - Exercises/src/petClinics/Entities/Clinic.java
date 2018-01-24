package petClinics.Entities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Clinic implements Iterable<Room>{

    private String name;
    private List<Integer>accommodationIndexes;
    private List<Integer>releaseIndexes;
    private List<Room> rooms;

    public Clinic(String name, int numberOfRooms) {
        this.name = name;
        this.setRooms(numberOfRooms);
        this.setAccommodationIndexes();
        this.setReleaseIndexes();

    }

    public void setRooms(int numberOfRooms) {
        if (numberOfRooms%2==0){
            throw new IllegalArgumentException("Invalid Operation!");
        }
        this.rooms = new ArrayList<>();
        for (int i = 0; i < numberOfRooms; i++) {
            rooms.add(new Room());
        }
    }

    public boolean addPet(Pet p){

        Iterable<Integer>indexes = this.accommodationIndexes;

        for (Integer index:indexes) {
            if (this.rooms.get(index).isEmpty() ){
                this.rooms.get(index).addPet(p);
                return true;
            }
        }
        return false;
    }

    public boolean release(){
        Iterable<Integer> indexes = this.releaseIndexes;

        boolean hasReleased = false;
        for (Integer index :indexes) {
            if (!this.rooms.get(index).isEmpty()){
                this.rooms.get(index).release();
                hasReleased = true;
                break;
            }
        }
        return hasReleased;
    }

    public void setReleaseIndexes() {
        this.releaseIndexes = new ArrayList<>();
        
        int middleIndex = (rooms.size()-1)/2;

        if (middleIndex == 0){
            releaseIndexes.add(0);
            return;
        }

        for (int i = middleIndex; i < rooms.size(); i++) {
            releaseIndexes.add(i);
        }
        for (int i = 0; i < middleIndex; i++) {
            releaseIndexes.add(i);
        }
    }
    public void setAccommodationIndexes() {
        this.accommodationIndexes = new ArrayList<>();
        int middleIndex = (this.rooms.size()-1)/2;
        this.accommodationIndexes.add(middleIndex);

        if (middleIndex==0){
            return;
        }

        int leftIndex = middleIndex-1;
        int rightIndex = middleIndex+1;

        for (int i = 0; i < middleIndex; i++) {
            if (leftIndex>=0){
                this.accommodationIndexes.add(leftIndex--);
            }
            if (rightIndex<=rooms.size()){
                this.accommodationIndexes.add(rightIndex++);
            }
        }

    }

    public boolean hasEmptyRooms(){
        boolean hasEmptyRoom = false;

        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).isEmpty()){
                hasEmptyRoom = true;
            }
        }

        return hasEmptyRoom;
    }

    public void printRooms(){
        for (Room room:rooms) {
            if (room.isEmpty()){
                System.out.print("Room empty\n");
            }else System.out.print(room.toString());
        }
    }

    public void printSpecificRoom(Integer index){
        System.out.print(this.rooms.get(index-1).toString());
    }

    public String getName() {
        return name;
    }




    @Override
    public Iterator<Room> iterator() {
        return new RoomIterator();
    }

    private class RoomIterator implements Iterator<Room> {

        private int index=0;


        @Override
        public boolean hasNext() {
            return this.index<rooms.size();
        }

        @Override
        public Room next() {
            return rooms.get(this.index++);
        }
    }
}
