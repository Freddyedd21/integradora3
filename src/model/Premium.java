package model;

import java.time.LocalTime;
import java.util.ArrayList;

public class Premium extends Consumers{

    private ArrayList<PlayList> playLists;
    
    /**
     * Premium: is the constructor of the class
     * @param nickNameUs: String=> user's nickname.
     * @param idUs: String=> user's id.
     * @param hours: int=> number of hours of playback.
     * @param minutes: int=> number of minutes of playback.
     * @param second: int=> number of second of playback.
     * @param mostListenedGender: String=>most played music genre.
     * @param mostListenedArtist: String=>most played music artist.
     */
    public Premium(String nickNameUs, String idUs, int hours, int minutes, int second, String mostListenedGender, String mostListenedArtist){
        super(nickNameUs, idUs, hours, minutes, second, mostListenedGender, mostListenedArtist);
        playLists = new ArrayList<PlayList>();
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
     * addPlaylistPremium: add a playlist for premium users.
     * @param newPlayList: Playlist=> is the playlist type object to add.
     * @return msj: String=> confirmation message
     */
    public String addPlaylistPremium(PlayList newPlayList){
        String msj="max capacity of playlist added";
        playLists.add(newPlayList);
        msj="new play list added";
        return msj;
    }
    /**
     * addSongtoPlaylistPremium: add a song to a specific playlist
     * @param newProductList: Products=> object of the audioProduct.
     * @param posNameList: int=> is the position of the play list in the arraylist.
     * @return msj: String=> confirmation message.
     */
    public String addSongtoPlaylistPremium(Products newProductList, int posNameList){
        String msj="the song cant be added";
        msj=playLists.get(posNameList).addSong(newProductList);
        return msj;
    }
    /**
     * addPodcastToPlaylistPremium: add a podcast to a specific playlist
     * @param newProductList: Products=> objet of the audioProduct.
     * @param posNameList: int=> is the position of the play list in the arraylist.
     * @return msj: String=> confirmation message.
     */
    public String addPodcastToPlaylistPremium(Products newProductList, int posNameList){
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
    public String removeSongtoPlaylistPremium(int posNameList, String nameProduct){
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
    public String removePodCasttoPlaylistPremium(int posNameList, String nameProduct){
        String msj="the pod cast cant be remove";
        msj=playLists.get(posNameList).removePodcast(nameProduct);
        return msj;
    }

}