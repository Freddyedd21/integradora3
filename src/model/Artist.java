package model;

import java.time.LocalTime;


public class Artist extends Producers{
    /**
     * Artist: is the constructor of the class.
     * @param nickNameUs: String=> user's nickname.
     * @param idUs: String=> user's id.
     * @param nameProducer: String=> producer's name.
     * @param URLproducer: String=> producer's url image.
     * @param reproductionQuantityProducer: int=> number of playback replays from the producer.
     * @param hours: int=> number of hours of playback.
     * @param minutes: int=> number of minutes of playback.
     * @param second: int=> number of second of playback.
     */
    public Artist(String nickNameUs, String idUs, String nameProducer, String URLproducer, int reproductionQuantityProducer, int hours, int minutes, int second){
        super(nickNameUs, idUs, nameProducer, URLproducer, reproductionQuantityProducer, hours, minutes, second);
    }
}