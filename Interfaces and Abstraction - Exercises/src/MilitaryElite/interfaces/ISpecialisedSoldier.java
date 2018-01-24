package MilitaryElite.interfaces;

import MilitaryElite.entities.Corp;



public interface ISpecialisedSoldier extends IPrivate{

    void setCorp(Corp corp);
    Corp getCorps();
}
