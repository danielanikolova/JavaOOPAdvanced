package petClinics.Entities;

public class Room {

    private Pet pet;
    private boolean isEmpty;

    public Room() {
        this.isEmpty = true;
    }

    public void addPet(Pet p) {
        this.pet = p;
        this.isEmpty = false;
    }

    public boolean isEmpty() {
        return this.isEmpty;
    }

    public void release() {
        this.pet = null;
        this.isEmpty = true;
    }
    @Override
    public String toString() {
        if (this.isEmpty()){
            return "Room empty\n";
        }else {
            return this.pet.toString();
        }

    }

}
