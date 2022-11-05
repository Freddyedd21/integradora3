package model;

import java.time.LocalDate;;

public abstract class Users{
    private String nickNameUs;
    private String idUs;
    private LocalDate dateUs;

    public Users(String nickNameUs, String idUs){
        this.nickNameUs=nickNameUs;
        this.idUs=idUs;
        this.dateUs= LocalDate.now();
    }

    public String getNickNameUs() {
        return nickNameUs;
    }

    public void setNickNameUs(String nickNameUs) {
        this.nickNameUs = nickNameUs;
    }

    //-----------------------------------------------------------

    public String getIdUs() {
        return idUs;
    }

    public void setIdUs(String idUs) {
        this.idUs = idUs;
    }

    //-----------------------------------------------------------

    public LocalDate getDateUs() {
        return dateUs;
    }

    public void setDateUs(LocalDate dateUs) {
        this.dateUs = dateUs;
    }

    
}