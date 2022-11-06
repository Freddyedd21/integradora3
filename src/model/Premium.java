package model;

import java.time.LocalTime;
import java.util.ArrayList;

public class Premium extends Consumers{

    private ArrayList<PlayList> playLists;
    
    public Premium(String nickNameUs, String idUs, int hours, int minutes, int second, String mostListenedGender, String mostListenedArtist){
        super(nickNameUs, idUs, hours, minutes, second, mostListenedGender, mostListenedArtist);
        playLists = new ArrayList<PlayList>();
    }

    public ArrayList<PlayList> getPlayLists() {
        return playLists;
    }
    public void setPlayLists(ArrayList<PlayList> playLists) {
        this.playLists = playLists;
    }

    public String addPlaylistPremium(PlayList newPlayList){
        String msj="max capacity of playlist added";
        playLists.add(newPlayList);
        msj="new play list added";
        return msj;
    }

    public String addSongtoPlaylistPremium(Products newProductList, int posNameList){
        String msj="the song cant be added";
        msj=playLists.get(posNameList).addSong(newProductList);
        return msj;
    }

    public String addPodcastToPlaylistPremium(Products newProductList, int posNameList){
        String msj="the pod cast cant be added";
        msj=playLists.get(posNameList).addSong(newProductList);
        return msj;
    }

    public String removeSongtoPlaylistPremium(int posNameList, String nameProduct){
        String msj="the song cant be remove";
        msj=playLists.get(posNameList).removeSong(nameProduct);
        return msj;
    }

    public String removePodCasttoPlaylistPremium(int posNameList, String nameProduct){
        String msj="the pod cast cant be remove";
        msj=playLists.get(posNameList).removePodcast(nameProduct);
        return msj;
    }

}