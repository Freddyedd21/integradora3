package model;

import java.time.LocalTime;
import java.util.ArrayList;

public class Standart extends Consumers{
    public static final int TOTAL_PLAYLIST=20;
    private int numberOfList=0;
    private ArrayList<PlayList> playLists;
    public Standart(String nickNameUs, String idUs, int hours, int minutes, int second, String mostListenedGender, String mostListenedArtist, int numberOfList){
        super(nickNameUs, idUs, hours, minutes, second, mostListenedGender, mostListenedArtist);
        this.numberOfList=numberOfList;
        playLists = new ArrayList<PlayList>(20);
    }
    
    public ArrayList<PlayList> getPlayLists() {
        return playLists;
    }

    public void setPlayLists(ArrayList<PlayList> playLists) {
        this.playLists = playLists;
    }

    public int getNumberOfList() {
        return numberOfList;
    }

    public void setNumberOfList(int numberOfList) {
        this.numberOfList = numberOfList;
    }


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
    public String addSongtoPlaylistStandart(Products newProductList, int posNameList){
        String msj="the song cant be added";
        msj=playLists.get(posNameList).addSong(newProductList);
        return msj;
    }

    public String addPodcastToPlaylistStandart(Products newProductList, int posNameList){
        String msj="the pod cast cant be added";
        msj=playLists.get(posNameList).addSong(newProductList);
        return msj;
    }

    public String removeSongtoPlaylistStandart(int posNameList, String nameProduct){
        String msj="the song cant be remove";
        msj=playLists.get(posNameList).removeSong(nameProduct);
        return msj;
    }

    public String removePodCasttoPlaylistStandart(int posNameList, String nameProduct){
        String msj="the podcast cant be remove";
        msj=playLists.get(posNameList).removePodcast(nameProduct);
        return msj;
    }

    
}