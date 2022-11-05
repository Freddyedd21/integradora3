package model;

import java.time.LocalTime;

public class Premium extends Consumers{
    public Premium(String nickNameUs, String idUs, int hours, int minutes, int second, String mostListenedGender, String mostListenedArtist){
        super(nickNameUs, idUs, hours, minutes, second, mostListenedGender, mostListenedArtist);
    }
}