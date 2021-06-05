package Monopoly.Player;

import Monopoly.Board.PropertyField;

import java.io.Serializable;
import java.util.List;

public class Participant implements Serializable {
    private List<PropertyField> listOfProperties;

    public Participant(List<PropertyField> listOfProperties) {
        this.listOfProperties = listOfProperties;
    }

    public List<PropertyField> getListOfProperties() {
        return listOfProperties;
    }

    public void setListOfProperties(List<PropertyField> listOfProperties) {
        this.listOfProperties = listOfProperties;
    }

}
