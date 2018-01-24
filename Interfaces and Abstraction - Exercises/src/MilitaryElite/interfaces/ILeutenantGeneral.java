package MilitaryElite.interfaces;

import MilitaryElite.entities.Private;

import java.util.List;

public interface ILeutenantGeneral extends IPrivate{

    void addPrivate(Private p);

    List<Private> getPrivateSet();

}
