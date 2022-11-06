package model;

import java.util.ArrayList;
import java.lang.annotation.Retention;
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

    public String createConsumerUser(String nickNameUs, String idUs, int hours, int minutes, int second, String mostListenedGender, String mostListenedArtist, int numberOfList, int choose){
        String msj="the user cant be added";
        int posIdUs=searchUserById(idUs);
        if(posIdUs==-1){
            switch(choose){
                case 1:
                 Users newStandart = new Standart(nickNameUs, idUs, hours, minutes, second, mostListenedGender, mostListenedArtist, numberOfList);
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

    public String createProducts(String nameProduct, String idOwner, String url, int hours, int minutes, int second, int reproductionNumber, String album, int musicGenderSelection, double saleValue, int numberSales, String description, int podcastsCategorySelection, int choose){
        String msj="the product cant be added";
        int posIdUs=searchUserById(idOwner);
        switch(choose){
            case 1:
             if(users.get(posIdUs) instanceof Artist){
                Products newSong = new Songs(nameProduct, idOwner, url, hours, minutes, second, reproductionNumber, album, musicGenderSelection, saleValue, numberSales);
                products.add(newSong);
                msj = "new song added";
             }else{
                msj="the entered id does not match an artist's id";
             }
             
            break;

            case 2:
            if(users.get(posIdUs) instanceof ContentCreators){
                Products newPodcast = new Podcasts(nameProduct, idOwner, url, hours, minutes, second, reproductionNumber, description, podcastsCategorySelection);
                products.add(newPodcast);
                msj = "new podcast added";
            }else{
                msj="the entered id does not match an content creators's id"; 
            }
             
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

    public int verifyArtistOrCreatorsByid(String idOwner){
        int match=0;
        int posIdUs=searchUserById(idOwner);
        if(posIdUs!=-1){
            if(users.get(posIdUs) instanceof Artist){
                match=1;
            }
            if(users.get(posIdUs) instanceof ContentCreators){
                match=2;
            }
        }
        return match;
    }

    public int verifyConsumerByid(String idUs){
        int match=0;
        int posIdUs=searchUserById(idUs);
        if(posIdUs!=-1){
            if(users.get(posIdUs) instanceof Standart){
                match=1;
            }
            if(users.get(posIdUs) instanceof Premium){
                match=1;
            }
        }
        return match;
    }

    public int verifyAudioProductByName(String nameProduct){
        int match=0;
        int posNameProd=searchAudioProductByName(nameProduct);
        if(posNameProd!=-1){
            if(products.get(posNameProd) instanceof Songs){
                match=1;
            }
            if(products.get(posNameProd) instanceof Podcasts){
                match=2;
            }
        }
        return match;
    }
    

    public String editPlayList(String idUs, String nameProduct, String nameList, int choose){
        String msj="";
        int posIdUs=searchUserById(idUs);
        int posNameList=searchPlayListByName(idUs, nameList);
        int posNameProd=searchAudioProductByName(nameProduct);
        Products newProductList=products.get(posNameProd);
        switch(choose){
            case 1:
               
               if(users.get(posIdUs) instanceof Standart){
                msj=((Standart)(users.get(posIdUs))).addSongtoPlaylistStandart(newProductList, posNameList);
               }
               if(users.get(posIdUs) instanceof Premium){
                msj=((Premium)(users.get(posIdUs))).addSongtoPlaylistPremium(newProductList, posNameList);
               }
            break;
            case 2:
               if(users.get(posIdUs) instanceof Standart){
                msj=((Standart)(users.get(posIdUs))).addPodcastToPlaylistStandart(newProductList, posNameList);
               }
               if(users.get(posIdUs) instanceof Premium){
                msj=((Premium)(users.get(posIdUs))).addPodcastToPlaylistPremium(newProductList, posNameList);
               }
            case 3:
               if(users.get(posIdUs) instanceof Standart){
                 msj=((Standart)(users.get(posIdUs))).removeSongtoPlaylistStandart(posNameList, nameProduct);
                }
               if(users.get(posIdUs) instanceof Premium){
                 msj=((Premium)(users.get(posIdUs))).removeSongtoPlaylistPremium(posNameList, nameProduct);
                }
            break;
            case 4:
               if(users.get(posIdUs) instanceof Standart){
                 msj=((Standart)(users.get(posIdUs))).removePodCasttoPlaylistStandart(posNameList, nameProduct);
               }
              if(users.get(posIdUs) instanceof Premium){
                 msj=((Premium)(users.get(posIdUs))).removeSongtoPlaylistPremium(posNameList, nameProduct);
               }
            break;

        }
        return msj;
    }

    public int searchPlayListByName(String idUs, String nameList){
        int posIdUs=searchUserById(idUs);
        int posNameList=-1;
        boolean isFound=false;
        if(users.get(posIdUs) instanceof Standart){
            for(int i=0; i<((Standart)(users.get(posIdUs))).getNumberOfList() && !isFound; i++){
                if(((Standart)(users.get(posIdUs))).getPlayLists().get(i).getNameList().equals(nameList)){
                    posNameList=i;
                    isFound=true;
                }
            }
        }

        if(users.get(posIdUs) instanceof Premium){
            for(int i=0; i<((Premium)(users.get(posIdUs))).getPlayLists().size() && !isFound; i++){
                if(((Premium)(users.get(posIdUs))).getPlayLists().get(i).getNameList().equals(nameList)){
                    posNameList=i;
                    isFound=true;
                }
            }
        }
        return  posNameList;
        
    }


    public int searchAudioProductByName(String nameProduct){
        int posNameProd=-1;
        boolean isFound=false;
        for(int i = 0; i < products.size() && !isFound; i++){
            if(products.get(i)!=null){
                if(products.get(i).getNameProduct().equals(nameProduct)){
                    posNameProd = i;
                    isFound=true;
                }
            }
        }
        return posNameProd;
    }


   

}

