package model;

import java.util.ArrayList;

import org.w3c.dom.NameList;

import java.lang.annotation.Retention;
import java.time.LocalTime;

public class Controller{
    private ArrayList<Users> users;
    private ArrayList<Products> products;
    private int reproductionQuantityProgram;

    /**
     * Controller: is the constructor of the class Controller tha contain the arrayslist of product and users
     */
    public Controller(){
        users = new ArrayList<Users>(10);
        products = new ArrayList<Products>(10);
        reproductionQuantityProgram=0;
    }

    /**
     * @return users: arraylist<Users> => get the array list of users
     */
    public ArrayList<Users> getUsers() {
        return users;
    }

    /**
     * @param users arraylist<Users> => set the array list of users
     */
    public void setUsers(ArrayList<Users> users) {
        this.users = users;
    }

    //-----------------------------------------------------------

    /**
     * @return products: arraylist<Products> => get the array list of products
     */
    public ArrayList<Products> getProducts() {
        return products;
    }

    /**
     * @param products arraylist<Products> => set the array list of products
     */
    public void setProducts(ArrayList<Products> products) {
        this.products = products;
    }

    public int getReproductionQuantityProgram() {
        return reproductionQuantityProgram;
    }

    public void setReproductionQuantityProgram(int reproductionQuantityProgram) {
        this.reproductionQuantityProgram += reproductionQuantityProgram;
    }

    //-----------------------------------------------------------

    /**
     * createProductorUser: create user productor.
     * @param nickNameUs: String=> user's nickname.
     * @param idUs: String=> user's id.
     * @param nameProducer: String=> producer's name.
     * @param URLproducer: String=> producer's url image.
     * @param reproductionQuantityProducer: int=> number of playback replays from the producer.
     * @param hours: int=> number of hours of playback.
     * @param minutes: int=> number of minutes of playback.
     * @param second: int=> number of second of playback.
     * @param choose: int=> select tool.
     * @return msj: String=> confirmation message.
     */
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

    /**
     * createConsumerUser: create user consumer.
     * @param nickNameUs: String=> user's nickname.
     * @param idUs: String=> user's id.
     * @param hours: int=> number of hours of playback.
     * @param minutes: int=> number of minutes of playback.
     * @param second: int=> number of second of playback.
     * @param mostListenedGender: String=>most played music genre.
     * @param mostListenedArtist: String=>most played music artist.
     * @param numberOfList: int=> number of playlists
     * @param choose: int=> select tool.
     * @return msj: String=> confirmation message.
     */
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

    /**
     * createProducts: create audio product.
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
     * @param description: String=> podcast description.
     * @param podcastsCategorySelection: int=> podcast category selection.
     * @param choose: int=> select tool.
     * @return msj: String=> confirmatio message.
     */
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

    /**
     * createPlayListToUs: create a play list to a specifically to a usuary
     * @param idUs: String=> consumer user's id.
     * @param nameList: String=> name of the playList.
     * @return msj: String=> confirmatio message.
     */
    public String createPlayListToUs(String idUs, String nameList, int typePlaylistSelection){
        String msj="";
        int posIdUs=searchUserById(idUs);
        
        if(posIdUs!=-1){
            if(users.get(posIdUs) instanceof Consumers){
                PlayList newPlayList = new PlayList(nameList, typePlaylistSelection);
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



    /**
     * searchUserById: search for a user by id.
     * @param idUs: String=> user's id.
     * @return posIdUs: int=> user position in array list.
     */
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
    
    /**
     * searchUserByNick: search for a user by nickName.
     * @param nickNameUs: String=> user's nickName.
     * @return posNickUs: int=> user position in array list.
     */
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

    /**
     * verifyArtistOrCreatorsByid: check the type of producer users by id (whether they are artists or content creators).
     * @param idOwner: String=> user id.
     * @return match: int=> confirmation variable.
     */
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

    /**
     * verifyConsumerByid: check the type of consuemr users by id (whether they are Stadart or premium consumers).
     * @param idUs: String=> user id.
     * @return match: int=> confirmation variable.
     */
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

    /**
     * verifyAudioProductByName: check the type of the AudioProduct by the name (whether they are Songs or Podcasts audio products).
     * @param nameProduct: String=> is the name of the audioProduct.
     * @return match: int=> confirmation variable.
     */
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
    

    /**
     * editPlayList: method that is responsible for editing the playlist
     * @param idUs: String=> user id.
     * @param nameProduct: String=> is the name of the audioProduct.
     * @param nameList: String=> it the name of the play list
     * @param choose: int=> select tool.
     * @return msj: String=> confirmation message.
     */
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

    /**
     * searchPlayListByName: search for a play list by name.
     * @param idUs: String=> user id.
     * @param nameList: String=> it the name of the play list
     * @return posNameList: int=> play list position in array list.
     */
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


    /**
     * searchAudioProductByName: search for a audioProduct by name.
     * @param nameProduct: String=> it the name of the audioProduct. 
     * @return posNameProd: int=> audioProduct position in array list.
     */
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

    /**
     * sharePlaylistMatrix: share the playlist matrix code
     * @param idUs: String=> is the id of the user
     * @param nameList: String=> is the name of the list.
     * @return msj: String=> confirmation message.
     */
    public String sharePlaylistMatrix(String idUs, String nameList){
        String msj="";
        int posUser=searchUserById(idUs);
        if(posUser!=1){
            int posList=searchPlayListByName(idUs, nameList);
            if(posList!=1){
                for(int i=0; i<6; i++){
                    for(int j=0; j<6; j++){
                        msj+=(((Standart)(users.get(posUser))).getPlayLists().get(posList).getMatrixCode()[i][j])+ " ";
                    }
                    msj+="\n";
                }
            }
            
        }
        return msj;
    }

    /**
     * sharePlaylistCode: show the code of the playlist
     * @param idUs: String=> is the id of the user
     * @param nameList: String=> is the name of the list.
     * @return msj: String=> confirmation message.
     */
    public String sharePlaylistCode(String idUs, String nameList){
        String msj="";
        int posUser=searchUserById(idUs);
        if(posUser!=1){
            int posList=searchPlayListByName(idUs, nameList);
            if(posList!=1){
                msj=(((Standart)(users.get(posUser))).getPlayLists().get(posList).getIdList()); 
            }
            
        }
        return msj;
    }

    /**
     * playAudio: play an sepecific audio product
     * @param idUs: String=> is the id of the user
     * @param nameList: String=> is the name of the list.
     * @return msj: String=> confirmation message.
     */
    public String playAudio(String idUs, String nameProduct){
        String msj="";
        int counter=1;
        int posIdUs=searchUserById(idUs);
        if(posIdUs!=-1){
            int posProduct=searchAudioProductByName(nameProduct);
            if(posProduct!=-1){
                String idOwner= products.get(posProduct).getIdOwner();
                int posProducer=searchUserById(idOwner);
                if(posProducer!=-1){
                    setReproductionQuantityProgram(counter);
                    products.get(posProduct).setReproductionNumber(counter);
                    ((Consumers)(users.get(posIdUs))).setReproductionQuantityConsumer(counter);
                    ((Producers)(users.get(posProducer))).setReproductionQuantityProducer(counter);
                    if(users.get(posIdUs) instanceof Standart){
                        msj=playAudioStandart(posProduct);
                    }
                    if(users.get(posProducer) instanceof Premium){
                        msj=playAudioPremium(posProduct);
                    }
                    
                }
            }
        }
        return msj;
    }
    /**
     * playAudioStandart: play an audio for standart users
     * @param posProduct: int=> is the position of the product in the array
     * @return msj: String=> confirmation message.
     */
    public String playAudioStandart(int posProduct){
        String msj="";
        int counterPlay=products.get(posProduct).getCounterPlay();
        if(counterPlay<=2){
            if(products.get(posProduct) instanceof Songs){
                msj=((Songs)(products.get(posProduct))).playSong();  
            }
            if(products.get(posProduct) instanceof Podcasts){
                msj=((Podcasts)(products.get(posProduct))).playPodCast();  
            }
            counterPlay+=1;
            products.get(posProduct).setCounterPlay(counterPlay);
            
        }
        if(counterPlay==3){
            if(products.get(posProduct) instanceof Songs){
                msj=((Songs)(products.get(posProduct))).playSong();  
            }
            if(products.get(posProduct) instanceof Podcasts){
                msj=((Podcasts)(products.get(posProduct))).playPodCast();  
            }
            counterPlay=1;
            products.get(posProduct).setCounterPlay(counterPlay);
            
        }

        return msj;
    }

    /**
     * playAudioPremium: play an audio for premium users
     * @param posProduct: int=> is the position of the product in the array
     * @return msj: String=> confirmation message.
     */
    public String playAudioPremium(int posProduct){
        String msj="";
            if(products.get(posProduct) instanceof Songs){
                msj=((Songs)(products.get(posProduct))).playSong();  
            }
            if(products.get(posProduct) instanceof Podcasts){
                msj=((Podcasts)(products.get(posProduct))).playPodCast();  
            }
        return msj;
    }



    /**
     * buySong: buy an specific song
      * @param idUs: String=> is the id of the user
     * @param nameProduct: String=> is the name of the audio.
     * @return msj: String=> confirmation message.
     */
    public String buySong(String idUs, String nameProduct){
        String msj="";
        int posIdUs=searchUserById(idUs);
        if(posIdUs!=-1){
            int posProduct=searchAudioProductByName(nameProduct);
            if(posProduct!=-1){
                String idOwner= products.get(posProduct).getIdOwner();
                int posProducer=searchUserById(idOwner);
                if(posProducer!=-1){
                    msj=(((Songs)(products.get(posProduct))).buySong());
                }
            }
        }
        return msj;
    }



   

}

