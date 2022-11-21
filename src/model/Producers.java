package model;

import java.time.LocalTime;

public abstract class Producers extends Users{
    private String nameProducer;
    private String URLproducer;
    private int reproductionQuantityProducer;
    private LocalTime reproducingTimeProducer;

    /**
     * Producer: is the constructor of the class.
     * @param nickNameUs: String=> user's nickname.
     * @param idUs: String=> user's id.
     * @param nameProducer: String=> producer's name.
     * @param URLproducer: String=> producer's url image.
     * @param reproductionQuantityProducer: int=> number of playback replays from the producer.
     * @param hours: int=> number of hours of playback.
     * @param minutes: int=> number of minutes of playback.
     * @param second: int=> number of second of playback.
     */
    public Producers(String nickNameUs, String idUs, String nameProducer, String URLproducer, int reproductionQuantityProducer, int hours, int minutes, int second){
        super(nickNameUs, idUs);
        this.nameProducer=nameProducer;
        this.URLproducer=URLproducer;
        this.reproductionQuantityProducer=reproductionQuantityProducer;
        this.reproducingTimeProducer = LocalTime.of(hours, minutes, second);
    }

    /**
     * getNameProducer: get the name of the producer.
     * @return nameProducer: String=> is the name of the producer.
     */
    public String getNameProducer() {
        return nameProducer;
    }

    /**
     * setNameProducer: set the name of the producer.
     * @param nameProducer: String=> is new name of the producer.
     */
    public void setNameProducer(String nameProducer) {
        this.nameProducer = nameProducer;
    }

    //------------------------------------------------------------
    /**
     * getURLproducer: get the image of the producer.
     * @return URLproducer: String=> is the image of the producer.
     */
    public String getURLproducer() {
        return URLproducer;
    }
    /**
     * setURLproducer: set the image of the producer.
     * @param URLproducer: String=> is new image of the producer.
     */
    public void setURLproducer(String URLproducer) {
        this.URLproducer = URLproducer;
    }

    //-----------------------------------------------------------
    /**
     * getReproductionQuantityProducer: get the reproduction quantity of the producer.
     * @return reproductionQuantityProducer: int=> is the reproduction quantity of the producer.
     */
    public int getReproductionQuantityProducer() {
        return reproductionQuantityProducer;
    }
    /**
     * setReproductionQuantityProducer: set the reproduction quantity of the producer.
     * @param reproductionQuantityProducer: int=> is the new reproduction quantity of the producer.
     */
    public void setReproductionQuantityProducer(int reproductionQuantityProducer) {
        this.reproductionQuantityProducer += reproductionQuantityProducer;
    }

    //-----------------------------------------------------------

    /**
     * getReproducingTimeProducer: get the reproduction time of the producer.
     * @return reproducingTimeProducer: LocalTime=> is the reproduction time of the producer.
     */
    public LocalTime getReproducingTimeProducer() {
        return reproducingTimeProducer;
    }

    /**
     * setReproducingTimeProducer: set the reproduction time of the producer.
     * @param reproducingTimeProducer: LocalTime=> is the new reproduction time of the producer.
     */
    public void setReproducingTimeProducer(LocalTime reproducingTimeProducer) {
        this.reproducingTimeProducer = reproducingTimeProducer;
    }
    
}