package model;

import java.util.ArrayList;
import java.time.LocalTime;

public class Controller{
    private ArrayList<Users> users;
    private ArrayList<Products> products;

    public Controller(){
        users = new ArrayList<Users>(10);
        products = new ArrayList<Products>(10);
    }

    public ArrayList<Users> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<Users> users) {
        this.users = users;
    }

    //-----------------------------------------------------------

    public ArrayList<Products> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Products> products) {
        this.products = products;
    }

    //-----------------------------------------------------------

    public String createProductorUser(String nickNameUs, String idUs, String nameProducer, String URLproducer, int reproductionQuantityProducer, int hours, int minutes, int second, int choose){
        String msj="the user cant be added";
        int posIdUs=searchUserById(idUs);
        if(posIdUs==-1){
            switch(choose){
                case 1:
                 Users newArtist = new Artist(nickNameUs, idUs, nameProducer, URLproducer, reproductionQuantityProducer, hours, minutes, second);
                 users.add(newArtist);
                 msj="new artist created";
                break;

                case 2:
                 Users newContentCreators = new ContentCreators(nickNameUs, idUs, nameProducer, URLproducer, reproductionQuantityProducer, hours, minutes, second);
                 users.add(newContentCreators);
                 msj="new content creator created";
                break;
            }
        }else{
            msj="the user is repeat";
        }

        return msj;
    }

    public String createConsumerUser(String nickNameUs, String idUs, int hours, int minutes, int second, String mostListenedGender, String mostListenedArtist, int choose){
        String msj="the user cant be added";
        int posIdUs=searchUserById(idUs);
        if(posIdUs==-1){
            switch(choose){
                case 1:
                 Users newStandart = new Standart(nickNameUs, idUs, hours, minutes, second, mostListenedGender, mostListenedArtist);
                 users.add(newStandart);
                 msj="new consumer standart created";
                break;

                case 2:
                Users newPremium = new Premium(nickNameUs, idUs, hours, minutes, second, mostListenedGender, mostListenedArtist);
                users.add(newPremium);
                msj="new consumer premium created";
                break;
            }
        }else{
            msj="the user is repeat";
        }

        return msj;
    }

    public String createProducts(String nameProduct, String idOwner, String url, int minutes, int second, int reproductionNumber, String album, int musicGenderSelection, double saleValue, int numberSales, String depcription, int podcastsCategorySelection, int choose){
        String msj="the product cant be added";
        switch(choose){
            case 1:
             Products newSong = new Songs(nameProduct, idOwner, url, minutes, second, reproductionNumber, album, musicGenderSelection, saleValue, numberSales);
             products.add(newSong);
             msj = "new song added";
            break;

            case 2:
             Products newPodcast = new Podcasts(nameProduct, idOwner, url, numberSales, minutes, second, reproductionNumber, depcription, podcastsCategorySelection);
             products.add(newPodcast);
             msj = "new podcast added";
            break;
        }
        return msj;

    }

    public String createPlayListToUs(String idUs, String nameList){
        String msj="";
        int posIdUs=searchUserById(idUs);
        if(posIdUs!=-1){
            if(users.get(posIdUs) instanceof Consumers){
                PlayList newPlayList = new PlayList(nameList);
                if(users.get(posIdUs) instanceof Standart){
                    msj=((Standart)(users.get(posIdUs))).addPlaylistStandart(newPlayList);
                }else if(users.get(posIdUs) instanceof Premium){
                    msj=((Premium)(users.get(posIdUs))).addPlaylistPremium(newPlayList);
                }
            }else{
                msj="the user is not a consumer";
            }
        }else{
            msj="the user is not created";
        }
        return msj;
    }


    public int searchUserById(String idUs){
        int posIdUs=-1;
        boolean isFound=false;
        for(int i = 0; i < users.size() && !isFound; i++){
            if(users.get(i)!=null){
                if(users.get(i).getIdUs().equals(idUs)){
                    posIdUs = i;
                    isFound=true;
                }
            }
        }
        return posIdUs;
    }
    
    public int searchUserByNick(String nickNameUs){
        int posNickUs=-1;
        boolean isFound=false;
        for(int i = 0; i < users.size() && !isFound; i++){
            if(users.get(i)!=null){
                if(users.get(i).getNickNameUs().equals(nickNameUs)){
                    posNickUs = i;
                    isFound=true;
                }
            }
        }
        return posNickUs;
    }
}

