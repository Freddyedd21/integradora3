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

   public String addSong(Products newProductList){
    String msj="the song has been added";
    productsList.add(newProductList);
    return msj;
   }

   public String addPodCast(Products newProductList){
    String msj="the podCast has been added";
    productsList.add(newProductList);
    return msj;
   }

   public String removeSong(String nameProduct){
    String msj="the song has been remove";
    int posAudioProductList=searchAudioProductByName(nameProduct);
    productsList.remove(posAudioProductList);
    return msj;
   }

   public String removePodcast(String nameProduct){
    String msj="the podcast has been remove";
    int posAudioProductList=searchAudioProductByName(nameProduct);
    productsList.remove(posAudioProductList);
    return msj;
   }



   public int searchAudioProductByName(String nameProduct){
    int posNameProd=-1;
    boolean isFound=false;
    for(int i = 0; i < productsList.size() && !isFound; i++){
        if(productsList.get(i)!=null){
            if(productsList.get(i).getNameProduct().equals(nameProduct)){
                posNameProd = i;
                isFound=true;
            }
        }
    }
    return posNameProd;
}


}



