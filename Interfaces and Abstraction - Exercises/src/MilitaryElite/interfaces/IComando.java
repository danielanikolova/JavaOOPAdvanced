package MilitaryElite.interfaces;

import MilitaryElite.entities.Mission;

import java.util.List;

public interface IComando extends IPrivate{

    List<Mission>getMissions();

    void addMission(Mission mission);
}
