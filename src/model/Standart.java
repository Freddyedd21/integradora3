package model;

import java.time.LocalTime;
import java.util.ArrayList;

public class Standart extends Consumers{
    public static final int TOTAL_PLAYLIST=20;

    private ArrayList<PlayList> playLists;
    public Standart(String nickNameUs, String idUs, int hours, int minutes, int second, String mostListenedGender, String mostListenedArtist){
        super(nickNameUs, idUs, hours, minutes, second, mostListenedGender, mostListenedArtist);
        playLists = new ArrayList<PlayList>(TOTAL_PLAYLIST);
    }
    
    public ArrayList<PlayList> getPlayLists() {
        return playLists;
    }

    public void setPlayLists(ArrayList<PlayList> playLists) {
        this.playLists = playLists;
    }


    public String addPlaylistStandart(PlayList newPlayList){
        String msj="max capacity of playlist added";
        boolean isEmpty=false;
        for(int i=0; i<TOTAL_PLAYLIST && !isEmpty; i++){
            if(playLists.get(i)==null){
                playLists.add(newPlayList);
                msj="new play list added";
                isEmpty=true;
            }
        }
        
        return msj;
    }
}