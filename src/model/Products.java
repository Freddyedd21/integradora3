package model;



import java.time.LocalTime;

public abstract class Products{
    private String nameProduct;
    private String url;
    private LocalTime duration;
    private int reproductionNumber;
    

    public Products(String nameProduct, String url, int hours, int minutes, int second, int reproductionNumber){
        this.nameProduct=nameProduct;
        this.url=url;
        this.duration= LocalTime.of(hours, minutes, second);
        this.reproductionNumber=reproductionNumber;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    //-----------------------------------------------------------

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //-----------------------------------------------------------

    public LocalTime getDuration() {
        return duration;
    }


    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }

    //-----------------------------------------------------------

    public int getReproductionNumber() {
        return reproductionNumber;
    }

    public void setReproductionNumber(int reproductionNumber) {
        this.reproductionNumber = reproductionNumber;
    }

}