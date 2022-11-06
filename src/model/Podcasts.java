package model;




public class Podcasts extends Products{
    private String description;
    private int podcastsCategorySelection;
    private PostCastCategories category;


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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //-----------------------------------------------------------

    public PostCastCategories getCategory() {
        return category;
    }

    public void setCategory(PostCastCategories category) {
        this.category = category;
    }
    
    
}