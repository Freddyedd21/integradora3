package model;


import java.time.LocalTime;

public abstract class Consumers extends Users{
    
    private LocalTime reproducingTimeConsumer;
    private String mostListenedGender;
    private String mostListenedArtist;



    /**
     * Consumer: is the constructor of the class.
     * @param nickNameUs: String=> user's nickname.
     * @param idUs: String=> user's id.
     * @param hours: int=> number of hours of playback.
     * @param minutes: int=> number of minutes of playback.
     * @param second: int=> number of second of playback.
     * @param mostListenedGender: String=>most played music genre.
     * @param mostListenedArtist: String=>most played music artist.
     */
    public Consumers(String nickNameUs, String idUs, int hours, int minutes, int second, String mostListenedGender, String mostListenedArtist){
        super(nickNameUs, idUs);
        this.reproducingTimeConsumer = LocalTime.of(hours, minutes, second);
        this.mostListenedGender=mostListenedGender;
        this.mostListenedArtist=mostListenedArtist;
    }

    //-----------------------------------------------------------

    /**
     * getReproducingTimeConsumer: get the reproduction time of the consumer.
     * @return reproducingTimeConsumer: LocalTime=> is the reproduction time of the consumer.
     */
    public LocalTime getReproducingTimeConsumer() {
        return reproducingTimeConsumer;
    }
    /**
     * setReproducingTimeConsumer: set the reproduction time of the consumer.
     * @param reproducingTimeConsumer: LocalTime=> is the new reproduction time of the consumer.
     */
    public void setReproducingTimeConsumer(LocalTime reproducingTimeConsumer) {
        this.reproducingTimeConsumer = reproducingTimeConsumer;
    }

    //-----------------------------------------------------------
    /**
     * getMostListenedGender: get the most listened gender of the consumer.
     * @return getMostListenedGender: String=> is the most listened gender of the consumer.
     */
    public String getMostListenedGender() {
        return mostListenedGender;
    }
    /**
     * setMostListenedGender: set the most listened gender of the consumer.
     * @param mostListenedGender: String=> is the new most listened gender of the consumer.
     */
    public void setMostListenedGender(String mostListenedGender) {
        this.mostListenedGender = mostListenedGender;
    }

    //-----------------------------------------------------------
    /**
     * getMostListenedArtist: get the most listened artist of the consumer.
     * @return getMostListenedArtist: String=> is the most listened artist of the consumer.
     */
    public String getMostListenedArtist() {
        return mostListenedArtist;
    }
    /**
     * setMostListenedArtist: set the most listened artist of the consumer.
     * @param mostListenedArtist: String=> is the new most listened artist of the consumer.
     */
    public void setMostListenedArtist(String mostListenedArtist) {
        this.mostListenedArtist = mostListenedArtist;
    }






    

}