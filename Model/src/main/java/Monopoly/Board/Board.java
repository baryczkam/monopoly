package Monopoly.Board;

import java.util.List;

public class Board implements BoardInterface{
    private List<Field> fieldList;


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



    public List<Field> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<Field> fieldList) {
        this.fieldList = fieldList;
    }

    public void initializeBoard(){

    }
}
