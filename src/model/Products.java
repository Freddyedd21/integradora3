package model;



import java.time.LocalTime;

public abstract class Products{
    private String nameProduct;
    private String idOwner;
    private String url;
    private LocalTime duration;
    private int reproductionNumber;
    

    /**
     * Product: is the constructor of the class.
     * @param nameProduct: String=> product's name.
     * @param idOwner: String=> owner's name.
     * @param url: String=> product's url image. 
     * @param hours: int=> hours of duration.
     * @param minutes: int=> minutes of duration.
     * @param second: int=> seconds of duration.
     * @param reproductionNumber: int=> number of playback replays from the product.
     */
    public Products(String nameProduct,  String idOwner, String url, int hours, int minutes, int second, int reproductionNumber){
        this.nameProduct=nameProduct;
        this.idOwner = idOwner;
        this.url=url;
        this.duration= LocalTime.of(hours, minutes, second);
        this.reproductionNumber=reproductionNumber;
    }

    /**
     * getNameProduct: get the name of the audio product.
     * @return nameProduct: String=> is the name of the audio product.
     */
    public String getNameProduct() {
        return nameProduct;
    }

    /**
     * setNameProduct: set the name of the audio product.
     * @param nameProduct: String=> is the new name of the audio product.
     */
    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    //-----------------------------------------------------------

    /**
     * getNameOwner: get the id of the owner of the audio product.
     * @return idOwner: String=> is the id of the owner of the audio product.
     */
    public String getNameOwner() {
        return idOwner;
    }

    /**
     * setNameOwner: set the id of the owner of the audio product.
     * @param idOwner: String=> is the new id of the owner of the audio product.
     */
    public void setNameOwner(String idOwner) {
        this.idOwner = idOwner;
    }

    //-----------------------------------------------------------
    /**
     * getUrl: get the url of the image of the audio product.
     * @return url: String=> is the url of the image of the audio product.
     */
    public String getUrl() {
        return url;
    }
    /**
     * setUrl: set the url of the image of the audio product.
     * @param url: String=> is the new url of the image of the audio product.
     */
    public void setUrl(String url) {
        this.url = url;
    }

    //-----------------------------------------------------------

    /**
     * getDuration: get the duration of the audio product.
     * @return duration: LocalTime=> is the duration of the audio product.
     */
    public LocalTime getDuration() {
        return duration;
    }
    /**
     * setDuration: set the duration of the audio product.
     * @param duration: LocalTime=> is the new duration of the audio product.
     */
    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }

    //-----------------------------------------------------------

    /**
     * getReproductionNumber: get the reproduction number of the audio product.
     * @return reproductionNumber: int=> is the reproduction number of the audio product.
     */
    public int getReproductionNumber() {
        return reproductionNumber;
    }

    /**
     * setReproductionNumber: set the reproduction number of the audio product.
     * @param reproductionNumber: int=> is the new reproduction number of the audio product.
     */
    public void setReproductionNumber(int reproductionNumber) {
        this.reproductionNumber = reproductionNumber;
    }

}