package model;


import java.time.LocalTime;

public abstract class Consumers extends Users{
    
    private LocalTime reproducingTimeConsumer;
    private String mostListenedGender;
    private String mostListenedArtist;



    public Consumers(String nickNameUs, String idUs, int hours, int minutes, int second, String mostListenedGender, String mostListenedArtist){
        super(nickNameUs, idUs);
        this.reproducingTimeConsumer = LocalTime.of(hours, minutes, second);
        this.mostListenedGender=mostListenedGender;
        this.mostListenedArtist=mostListenedArtist;
    }

    //-----------------------------------------------------------

    public LocalTime getReproducingTimeConsumer() {
        return reproducingTimeConsumer;
    }

    public void setReproducingTimeConsumer(LocalTime reproducingTimeConsumer) {
        this.reproducingTimeConsumer = reproducingTimeConsumer;
    }

    //-----------------------------------------------------------

    public String getMostListenedGender() {
        return mostListenedGender;
    }

    public void setMostListenedGender(String mostListenedGender) {
        this.mostListenedGender = mostListenedGender;
    }

    //-----------------------------------------------------------

    public String getMostListenedArtist() {
        return mostListenedArtist;
    }

    public void setMostListenedArtist(String mostListenedArtist) {
        this.mostListenedArtist = mostListenedArtist;
    }






    

}