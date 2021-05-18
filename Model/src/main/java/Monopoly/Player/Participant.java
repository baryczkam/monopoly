package Monopoly.Player;

import Monopoly.Board.PropertyField;

import java.util.List;

public class Participant {
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

    public Participant() {
    }
}
