package Monopoly.Board;

import Monopoly.SpecialCard.SpecialCard;

import java.util.List;

public class Board implements BoardInterface{
    private List<Field> fieldList;
    private List<SpecialCard> specialCardList;

    private static volatile Board instance = null;

    private Board(List<Field> fieldList,List<SpecialCard> specialCardList){
        if(instance != null){
            throw new RuntimeException("Not allowed. Please use getInstance() method");
        }
        this.fieldList = fieldList;
        this.specialCardList = specialCardList;
    }

    public static Board getInstance(List<Field> fieldList, List<SpecialCard> specialCardList){
        if(instance == null) {
            synchronized(Board.class){
                if(instance == null){
                    instance = new Board(fieldList,specialCardList);
                }
            }
        }
        return instance;
    }

    public Field getField(int index){
        return fieldList.get(index);
    }

    public JailField getJailField() {
        for(Field field : fieldList) {
            if(field instanceof JailField) {
                return (JailField) field;
            }
        }
        return null;
    }



    public ParkingField getParkingField(){
        for(Field field : fieldList){
            if(field instanceof ParkingField){
                return (ParkingField) field;
            }
        }
        return null;
    }

    public List<SpecialCard> getSpecialCardList() {
        return specialCardList;
    }

    public void setSpecialCardList(List<SpecialCard> specialCardList) {
        this.specialCardList = specialCardList;
    }

    public List<Field> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<Field> fieldList) {
        this.fieldList = fieldList;
    }

}
