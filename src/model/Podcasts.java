package model;




public class Podcasts extends Products{
    private String description;
    private int podcastsCategorySelection;
    private PostCastCategories category;


    /**
     * Podcasts: is the constructor of the class.
     * @param nameProduct: String=> product's name.
     * @param idOwner: String=> owner's name.
     * @param url: String=> product's url image. 
     * @param hours: int=> hours of duration.
     * @param minutes: int=> minutes of duration.
     * @param second: int=> seconds of duration.
     * @param reproductionNumber: int=> number of playback replays from the product.
     * @param description: String=> podcast description.
     * @param podcastsCategorySelection: int=> podcast category selection.
     */
    public Podcasts(String nameProduct, String idOwner, String url, int hours, int minutes, int second, int reproductionNumber, String description, int podcastsCategorySelection){
        super(nameProduct, idOwner, url, hours, minutes, second, reproductionNumber);
        this.description=description;
        switch(podcastsCategorySelection){
            case 1:
            this.category = PostCastCategories.POLITICS;
            break;
            case 2:
            this.category = PostCastCategories.ENTERTAINMENT;
            break;
            case 3:
            this.category = PostCastCategories.VIDEOGAMES;
            break;
            case 4:
            this.category = PostCastCategories.FASHION;
            break;
        }
       
    }

    /**
     * getDescription: get the description of the podCast.
     * @return description: String=> is the description of the podCast.
     */
    public String getDescription() {
        return description;
    }

    /**
     * setDescription: set the description of the podCast.
     * @param description: String=> is the new description of the podCast.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    //-----------------------------------------------------------

    /**
     * getCategory: get the category of the podCast.
     * @return category: PostCastCategories=> is the category of the podCast.
     */
    public PostCastCategories getCategory() {
        return category;
    }

    /**
     * setCategory: set the category of the podCast.
     * @param category: PostCastCategories=> is the new category of the podCast.
     */
    public void setCategory(PostCastCategories category) {
        this.category = category;
    }
    
    
}