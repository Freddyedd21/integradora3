package model;

import java.util.ArrayList;
import java.lang.Math;


public class PlayList{
    private String nameList;
    private ArrayList<Products> productsList;
    private int idList;


    public PlayList (String nameList){
        this.nameList=nameList;
        productsList = new ArrayList<Products>(100);
        this.idList=(int) (Math.random()*16);
    }

    public String getNameList() {
        return nameList;
    }

    public void setNameList(String nameList) {
        this.nameList = nameList;
    }

    //-----------------------------------------------------------   

    public ArrayList<Products> getProductsList() {
        return productsList;
    }

    public void setProductsList(ArrayList<Products> productsList) {
        this.productsList = productsList;
    }

    //-----------------------------------------------------------

    public int getIdList() {
        return idList;
    }
    
    public void setIdList(int idList) {
        this.idList = idList;
    }

    //-----------------------------------------------------------

   



}



