package model;

import java.util.ArrayList;
import java.lang.Math;


public class PlayList{
    private String nameList;
    private ArrayList<Products> productsList;
    private int idList;


    /**
     * PlayList: is the constructor of the class
     * @param nameList: String=> is the name of the playlist.
     */
    public PlayList (String nameList){
        this.nameList=nameList;
        productsList = new ArrayList<Products>(100);
        this.idList=(int) (Math.random()*16);
    }

    /**
     * getNameList: get the name of play list.
     * @return nameList: String=> is the name of play list.
     */
    public String getNameList() {
        return nameList;
    }

    /**
     * setNameList: set the name play list.
     * @param nameList: String=> is the new nameList of play list
     */
    public void setNameList(String nameList) {
        this.nameList = nameList;
    }

    //-----------------------------------------------------------   

    /**
     * getProductsList: get the arraylist of audioProduct.
     * @return productsList: ArrayList<Products>=> is the arraylist of audioProduct.
     */
    public ArrayList<Products> getProductsList() {
        return productsList;
    }

    /**
     * setProductsList: set the arraylist audioProduct.
     * @param productsList: ArrayList<Products>=> is the arraylist of audioProduct
     */
    public void setProductsList(ArrayList<Products> productsList) {
        this.productsList = productsList;
    }

    //-----------------------------------------------------------

    /**
     * getIdList: get the id of the list of products.
     * @return idList: int=> is the id of the list of products.
     */
    public int getIdList() {
        return idList;
    }
    
    /**
     * setIdList: set the id of the list of products.
     * @param idList: int=> is the new id of the list of products.
     */
    public void setIdList(int idList) {
        this.idList = idList;
    }

    //-----------------------------------------------------------

   /**
    * addSong: add a song to the playlist.
    * @param newProductList: Product=> is the objet of the audioProduct.
    * @return msj: String=> confirmation message.
    */
   public String addSong(Products newProductList){
     String msj="the song has been added";
     productsList.add(newProductList);
     return msj;
    }

   /**
    * addPodCast: add a PodCast to the playlist.
    * @param newProductList: Product=> is the objet of the audioProduct.
    * @return msj: String=> confirmation message.
    */
   public String addPodCast(Products newProductList){
     String msj="the podCast has been added";
     productsList.add(newProductList);
     return msj;
    }

   /**
    * removeSong: remove a song to the playlist.
    * @param nameProduct: String=> is the name of the audioProduct.
    * @return msj: String=> confirmation message.
    */
    public String removeSong(String nameProduct){
     String msj="the song has been remove";
     int posAudioProductList=searchAudioProductByName(nameProduct);
     productsList.remove(posAudioProductList);
     return msj;
    }

   /**
    * removePodcast: remove a podCast to the playlist.
    * @param nameProduct: String=> is the name of the audioProduct.
    * @return msj: String=> confirmation message.
    */
    public String removePodcast(String nameProduct){
     String msj="the podcast has been remove";
     int posAudioProductList=searchAudioProductByName(nameProduct);
     productsList.remove(posAudioProductList);
     return msj;
    }



   /**
     * searchAudioProductByName: search the audio product by name
     * @param nameProduct: String=> is the name of the audioProduct.
     * @return posNameProd: int=> the position of the audio product in the arraylist.
   */
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



