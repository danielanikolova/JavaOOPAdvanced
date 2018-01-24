package MilitaryElite.entities;

import MilitaryElite.interfaces.ISpecialisedSoldier;


public class SpecialisedSoldier extends Private implements ISpecialisedSoldier {

    private Corp corps;

    public SpecialisedSoldier(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
    }


    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public String getFirstName() {
        return super.getFirstName();
    }

    @Override
    public String getLastName() {
        return super.getLastName();
    }

    @Override
    public double getSalary() {
        return super.getSalary();
    }


    @Override
    public void setCorp(Corp corp) {
        this.corps = corp;
    }

    @Override
    public Corp getCorps() {
        return this.corps;
    }


}
