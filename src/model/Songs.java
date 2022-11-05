package model;



public class Songs extends Products{
    private String album;
    private MusicGender gender;
    private double saleValue;
    private int musicGenderSelection;
    private int numberSales;

    public Songs(String nameProduct, String url, int minutes, int second, int reproductionNumber, String album, int musicGenderSelection, double saleValue, int numberSales){
        super(nameProduct, url, 0, minutes, second, reproductionNumber);
        this.album=album;
        switch(musicGenderSelection){
            case 1:
            this.gender = MusicGender.HOUSE;
            break;
            case 2:
            this.gender = MusicGender.POP;
            break;
            case 3:
            this.gender = MusicGender.ROCK;
            break;
            case 4:
            this.gender = MusicGender.TRAP;
            break;
        }
        this.saleValue=saleValue;
        this.numberSales=numberSales;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    //-----------------------------------------------------------

    public MusicGender getGender() {
        return gender;
    }

    public void setGender(MusicGender gender) {
        this.gender = gender;
    }

    //-----------------------------------------------------------

    public double getSaleValue() {
        return saleValue;
    }

    public void setSaleValue(double saleValue) {
        this.saleValue = saleValue;
    }

    //-----------------------------------------------------------

    public int getNumberSales() {
        return numberSales;
    }

    public void setNumberSales(int numberSales) {
        this.numberSales = numberSales;
    }
}