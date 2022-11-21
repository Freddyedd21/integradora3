package model;

import java.util.ArrayList;
import java.lang.Math;  


public class PlayList{
    private String nameList;
    private TypePlaylist typePlaylist;
    private int typePlaylistSelection;
    private ArrayList<Products> productsList;
    private int[][] matrixCode;
    private String idList;

    public static final int ROWS = 6; 
    public static final int COLUMNS = 6; 

    /**
     * PlayList: is the constructor of the class
     * @param nameList: String=> is the name of the playlist.
     * @param typePlaylistSelection int=> the type list selection.
     */
    public PlayList (String nameList, int typePlaylistSelection){
        this.nameList=nameList;
        switch(typePlaylistSelection){
            case 1:
            this.typePlaylist = TypePlaylist.SONG;
            break;
            case 2:
            this.typePlaylist = TypePlaylist.PODCAST;
            break;
            case 3:
            this.typePlaylist = TypePlaylist.BOTH;
            break;
        }
        productsList = new ArrayList<Products>(100);
        matrixCode= new int[ROWS][COLUMNS];
        this.matrixCode=generateMatrixCode();
        this.idList=generateId(typePlaylistSelection, matrixCode);
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
    public String getIdList() {
        return idList;
    }
    
    /**
     * setIdList: set the id of the list of products.
     * @param idList: int=> is the new id of the list of products.
     */
    public void setIdList(String idList) {
        this.idList = idList;
    }

    public TypePlaylist getTypePlaylist() {
        return typePlaylist;
    }

    public void setTypePlaylist(TypePlaylist typePlaylist) {
        this.typePlaylist = typePlaylist;
    }

    //-----------------------------------------------------------

    public int[][] getMatrixCode() {
        return matrixCode;
    }

    public void setMatrixCode(int[][] matrixCode) {
        this.matrixCode = matrixCode;
    }

    
    //-----------------------------------------------------------

    /**
     * generateMatrixCode: generate the matrix of the playlist
     * @return newMatrixCode: int[][]=> matrix autogenerate.
     */
    public int[][] generateMatrixCode(){
        int[][] newMatrixCode = new int[ROWS][COLUMNS];
        for(int i = 0; i < ROWS; i++){ 
            for(int j = 0; j < COLUMNS; j++){
                newMatrixCode[i][j] = (int)(Math.random() * 10) ;  
            }
        }
        return newMatrixCode;
    }

    public String generateId(int typePlaylistSelection, int[][] matrixCode){
        String newId="";
        int r=0;
        switch(typePlaylistSelection){
            case 1:
            for(int i=5; i>=0; i--){
                newId+=matrixCode[i][0];
            }
            for(int i=1; i<ROWS; i++){
                newId+=matrixCode[i][i];
            }
            for(int i=4; i>=0; i--){
                newId+=matrixCode[i][5];  
            }

            break;
            case 2:
            for(int j=0; j<3; j++){
                newId+=matrixCode[0][j];
            }
            for(int i=1; i<5; i++){
                newId+=matrixCode[i][2];
            }
            for(int j=2; j<4; j++){
                newId+=matrixCode[5][j];
            }
            for(int i=4; i>0; i--){
                newId+=matrixCode[i][3];
            }
            for(int j=3; j<COLUMNS; j++){
                newId+=matrixCode[0][j];
            }
            break;
            case 3:
            for(int i=5; i>=0; i--){
                for(int j=5; j>=0; j--){
                    r=i+j;
                    if(r%2!=0 && r>1){
                        newId+=matrixCode[i][j];
                    }
                }
            }
            break;
        }

        return newId;
    }

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



