package model;

import java.time.LocalDate;;

public abstract class Users{
    private String nickNameUs;
    private String idUs;
    private LocalDate dateUs;
 

    /**
     * Users: is the constructor of the class
     * @param nickNameUs: String=> user's nickname.
     * @param idUs: String=> user's id.
     */
    public Users(String nickNameUs, String idUs){
        this.nickNameUs=nickNameUs;
        this.idUs=idUs;
        this.dateUs= LocalDate.now();
    }

    /**
     * getNickNameUs: get the nick name of the user.
     * @return nickNameUs: String=> is the nick name of the user
     */
    public String getNickNameUs() {
        return nickNameUs;
    }
    /**
     * setNickNameUs: set the nick name of the user.
     * @param nickNameUs: String=> is the new nick name of the user
     */
    public void setNickNameUs(String nickNameUs) {
        this.nickNameUs = nickNameUs;
    }

    //-----------------------------------------------------------
    /**
     * getIdUs: get the id of the user.
     * @return idUs: String=> is the id of the user.
     */
    public String getIdUs() {
        return idUs;
    }
    /**
     * setIdUs: set the id of the user.
     * @param idUs: String=> is the new id of the user
     */
    public void setIdUs(String idUs) {
        this.idUs = idUs;
    }

    //-----------------------------------------------------------

    /**
     * getDateUs: get the register date of the user.
     * @return dateUs: LocalDate=> is the get the register date of the user.
     */
    public LocalDate getDateUs() {
        return dateUs;
    }
    /**
     * setDateUs: set the register date of the user.
     * @param dateUs: LocalDate=> is the new register date of the user
     */
    public void setDateUs(LocalDate dateUs) {
        this.dateUs = dateUs;
    }

    
}