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
}