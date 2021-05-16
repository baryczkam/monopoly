package Monopoly.Player;

import Monopoly.Board.PropertyField;

import java.util.List;

public class Participant {
    private int money;
    private List<PropertyField> listOfProperties;

    public Participant(int money, List<PropertyField> listOfProperties) {
        this.money = money;
        this.listOfProperties = listOfProperties;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public List<PropertyField> getListOfProperties() {
        return listOfProperties;
    }

    public void setListOfProperties(List<PropertyField> listOfProperties) {
        this.listOfProperties = listOfProperties;
    }

}
