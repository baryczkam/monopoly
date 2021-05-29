package Monopoly.Board;

import Monopoly.SpecialCard.SpecialCard;

import java.util.List;

public class Board implements BoardInterface{
    private List<Field> fieldList;
//    private List<SpecialCard> specialCards;

    private static volatile Board instance = null;

    private Board(List<Field> fieldList){
        if(instance != null){
            throw new RuntimeException("Not allowed. Please use getInstance() method");
        }
        this.fieldList = fieldList;
    }

    public static Board getInstance(List<Field> fieldList){
        if(instance == null) {
            synchronized(Board.class){
                if(instance == null){
                    instance = new Board(fieldList);
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


    public List<Field> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<Field> fieldList) {
        this.fieldList = fieldList;
    }

    public void initializeBoard(){

    }
}
