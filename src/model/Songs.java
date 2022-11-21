package model;



public class Songs extends Products implements PlaySong, BuySong{
    private String album;
    private MusicGender gender;
    private double saleValue;
    private int musicGenderSelection;
    private int numberSales;

    /**
     * Songs: is the constructor of the class.
     * @param nameProduct: String=> product's name.
     * @param idOwner: String=> owner's name.
     * @param url: String=> product's url image. 
     * @param hours: int=> hours of duration.
     * @param minutes: int=> minutes of duration.
     * @param second: int=> seconds of duration.
     * @param reproductionNumber: int=> number of playback replays from the product.
     * @param album: String=> album to which a song belongs.
     * @param musicGenderSelection: int=> song genre selection.
     * @param saleValue: int=> sale value of the song.
     * @param numberSales: int=> number of sales of a song.
     */
    public Songs(String nameProduct, String idOwner, String url, int hours, int minutes, int second, int reproductionNumber, String album, int musicGenderSelection, double saleValue, int numberSales){
        super(nameProduct, idOwner, url, hours, minutes, second, reproductionNumber);
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

    /**
     * getAlbum: get the album of the song.
     * @return album: String=> is the album of the song.
     */
    public String getAlbum() {
        return album;
    }

    /**
     * setAlbum: set the album of the song.
     * @param album: String=> is the new the album of the song.
     */
    public void setAlbum(String album) {
        this.album = album;
    }

    //-----------------------------------------------------------

    /**
     * getGender: get the gender of the song.
     * @return gender: MusicGender=> is the gender of the song.
     */
    public MusicGender getGender() {
        return gender;
    }

     /**
     * setGender: set the gender of the song.
     * @param gender: MusicGender=> is the new the gender of the song.
     */
    public void setGender(MusicGender gender) {
        this.gender = gender;
    }

    //-----------------------------------------------------------

    /**
     * getSaleValue: get the sale Value of the song.
     * @return saleValue: double=> is the saleValue of the song.
     */
    public double getSaleValue() {
        return saleValue;
    }
    /**
     * setSaleValue: set the saleValue of the song.
     * @param saleValue: double=> is the new the saleValue of the song.
     */
    public void setSaleValue(double saleValue) {
        this.saleValue = saleValue;
    }

    //-----------------------------------------------------------

    /**
     * getNumberSales: get the number of sales of the song.
     * @return numberSales: int=> is the number of Sales of the song.
     */
    public int getNumberSales() {
        return numberSales;
    }

     /**
     * setNumberSales: set the number of Sales of the song.
     * @param numberSales: int=> is the new the number of Sales of the song.
     */
    public void setNumberSales(int numberSales) {
        this.numberSales = numberSales;
    }
    /* (non-Javadoc)
     * @see model.PlaySong#playSong()
     */
    @Override
    public String playSong(){
        String msj="song played";
        return msj;
    }
    @Override
    public String playAd(){
        String msj="";
        int choose=(int)(Math.random()*4);
        Ad adChoosed=Ad.COCA_COLA_OPEN_HAPPINESS;
        switch(choose){
            case 0:
                adChoosed=Ad.COCA_COLA_OPEN_HAPPINESS;
                msj="COCA_COLA_OPEN_HAPPINESS";
            break;
            case 1:
                adChoosed=Ad.MM_MELTS_IN_YOUR_MOUTH_NOT_IN_YOUR_HANDS;
                msj="MM_MELTS_IN_YOUR_MOUTH_NOT_IN_YOUR_HANDS";
            break;
            case 2:
                adChoosed=Ad.NIKE_JUST_DO_IT;
                msj="NIKE_JUST_DO_IT";
            break;
            
        }
        return msj;
    }
    @Override
    public String buySong(){
        String msj="song bought";
        return msj;
    } 
}