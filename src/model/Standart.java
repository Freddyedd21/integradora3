package model;

import java.time.LocalTime;
import java.util.ArrayList;

public class Standart extends Consumers{
    
    public static final int TOTAL_PLAYLIST=20;
    private int numberOfList=0;
    private ArrayList<PlayList> playLists;
    /**
     * Standart: is the constructor of the class
     * @param nickNameUs: String=> user's nickname.
     * @param idUs: String=> user's id.
     * @param hours: int=> number of hours of playback.
     * @param minutes: int=> number of minutes of playback.
     * @param second: int=> number of second of playback.
     * @param mostListenedGender: String=>most played music genre.
     * @param mostListenedArtist: String=>most played music artist.
     * @param numberOfList: int=> number of playlists
     */
    public Standart(String nickNameUs, String idUs, int hours, int minutes, int second, String mostListenedGender, String mostListenedArtist, int numberOfList){
        super(nickNameUs, idUs, hours, minutes, second, mostListenedGender, mostListenedArtist);
        this.numberOfList=numberOfList;
        playLists = new ArrayList<PlayList>(20);
    }
    
    /**
     * getPlayLists: get the arraylist play list.
     * @return playLists: ArrayList<PlayList>=> is the arraylist of play list
     */
    public ArrayList<PlayList> getPlayLists() {
        return playLists;
    }

    /**
     * setPlayLists: set the arraylist play list.
     * @param playLists ArrayList<PlayList>=> is the arraylist of play list
     */
    public void setPlayLists(ArrayList<PlayList> playLists) {
        this.playLists = playLists;
    }
    /**
     * getNumberOfList: get the number of play list in the array list.
     * @return numberOfList: int=> is the the number of play list in the array list.
     */
    public int getNumberOfList() {
        return numberOfList;
    }
    /**
     * setNumberOfList: set  the number of play list in the array list.
     * @param playLists int=> is the the new number of play list in the array list.
     */
    public void setNumberOfList(int numberOfList) {
        this.numberOfList = numberOfList;
    }


    /**
     * addPlaylistStandart: add a playlist for standard users.
     * @param newPlayList: Playlist=> is the playlist type object to add.
     * @return msj: String=> confirmation message
     */
    public String addPlaylistStandart(PlayList newPlayList){
        String msj="max capacity of playlist added";
        int counter=getNumberOfList()+1;
        if(counter<=TOTAL_PLAYLIST){
            playLists.add(newPlayList);
            setNumberOfList(counter);
            msj="new play list added";
        } 
        return msj;
    }
    /**
     * addSongtoPlaylistStandart: add a song to a specific playlist
     * @param newProductList: Products=> object of the audioProduct.
     * @param posNameList: int=> is the position of the play list in the arraylist.
     * @return msj: String=> confirmation message.
     */
    public String addSongtoPlaylistStandart(Products newProductList, int posNameList){
        String msj="the song cant be added";
        msj=playLists.get(posNameList).addSong(newProductList);
        return msj;
    }

    /**
     * addPodcastToPlaylistStandart: add a podcast to a specific playlist
     * @param newProductList: Products=> objet of the audioProduct.
     * @param posNameList: int=> is the position of the play list in the arraylist.
     * @return msj: String=> confirmation message.
     */
    public String addPodcastToPlaylistStandart(Products newProductList, int posNameList){
        String msj="the pod cast cant be added";
        msj=playLists.get(posNameList).addSong(newProductList);
        return msj;
    }

    /**
     * removeSongtoPlaylistStandart: remove a song to a specific playlist
     * @param posNameList: int=> is the position of the play list in the arraylist.
     * @param nameProduct: String=> is the name of the song to remove.
     * @return msj: String=> confirmation message.
     */
    public String removeSongtoPlaylistStandart(int posNameList, String nameProduct){
        String msj="the song cant be remove";
        msj=playLists.get(posNameList).removeSong(nameProduct);
        return msj;
    }


    /**
     * removePodCasttoPlaylistStandart: remove a podcast to a specific playlist
     * @param posNameList: int=> is the position of the play list in the arraylist.
     * @param nameProduct: String=> is the name of the podcast to remove.
     * @return msj: String=> confirmation message.
     */
    public String removePodCasttoPlaylistStandart(int posNameList, String nameProduct){
        String msj="the podcast cant be remove";
        msj=playLists.get(posNameList).removePodcast(nameProduct);
        return msj;
    }

    
}