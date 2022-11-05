package model;

import java.time.LocalTime;

public abstract class Producers extends Users{
    private String nameProducer;
    private String URLproducer;
    private int reproductionQuantityProducer;
    private LocalTime reproducingTimeProducer;

    public Producers(String nickNameUs, String idUs, String nameProducer, String URLproducer, int reproductionQuantityProducer, int hours, int minutes, int second){
        super(nickNameUs, idUs);
        this.nameProducer=nameProducer;
        this.URLproducer=URLproducer;
        this.reproductionQuantityProducer=reproductionQuantityProducer;
        this.reproducingTimeProducer = LocalTime.of(hours, minutes, second);
    }

    public String getNameProducer() {
        return nameProducer;
    }

    public void setNameProducer(String nameProducer) {
        this.nameProducer = nameProducer;
    }

    //------------------------------------------------------------

    public String getURLproducer() {
        return URLproducer;
    }
    
    public void setURLproducer(String uRLproducer) {
        URLproducer = uRLproducer;
    }

    //-----------------------------------------------------------

    public int getReproductionQuantityProducer() {
        return reproductionQuantityProducer;
    }

    public void setReproductionQuantityProducer(int reproductionQuantityProducer) {
        this.reproductionQuantityProducer = reproductionQuantityProducer;
    }

    //-----------------------------------------------------------

    public LocalTime getReproducingTimeProducer() {
        return reproducingTimeProducer;
    }

    public void setReproducingTimeProducer(LocalTime reproducingTimeProducer) {
        this.reproducingTimeProducer = reproducingTimeProducer;
    }
    
}