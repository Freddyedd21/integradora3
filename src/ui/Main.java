package ui;

import java.util.Scanner;

import model.Artist;
import model.Controller;

public class Main{

    private Scanner reader;
    private Controller controller;

    public Main(){
        reader=new Scanner(System.in);
      
        controller = new Controller(); 

    }


    public Scanner getReader(){
        return this.reader;
    }
    public void setReader(Scanner reader){
        this.reader=reader;
    }

    public static void main(String[] args){
        Main main=new Main();
        int option = -1; 
			do{

				option = main.getOptionShowMenu(); 
				main.executeOption(option);

			}while(option != 0);

		}

        

    

    public String printMenu(){
        return
        "<< --------------------------------------------------------------------- >>\n" +
        "<< -                                Welcome                            - >>\n" +
        "<< --------------------------------------------------------------------- >>\n" +
        "1. register usuary producer \n" +
        "2. register usuary consumer \n" +
        "3. create song and podcast \n" +
        "0. exit program";
    
    }
    public int validateIntegerOption(){
        int option = 0; 

        if(reader.hasNextInt()){
            option = reader.nextInt(); 
        }
        else{
            reader.nextLine(); 
            option = -1; 
        }

        return option; 
    }

    public double validateDoubleOption(){
        double option = 0; 

        if(reader.hasNextDouble()){
            option = reader.nextDouble(); 
        }
        else{
            reader.nextLine(); 
            option = -1; 
        }

        return option; 
    }

    public int getOptionShowMenu(){
        int option = 0; 
        System.out.println(printMenu());

        option = validateIntegerOption(); 

        return option; 
    }
    public void executeOption(int option){
        //tools cheack
        String msj=""; int counter=0; int choose=0;
        //tools time change
        int hours=0; int minutes=0; int second=0; 
        //usuary params
        String nickNameUs=""; String idUs=""; String nameProducer=""; String URLproducer=""; 
        //producer params
        int reproductionQuantityProducer=0; 
        //consumer params
        String mostListenedGender=""; String mostListenedArtist="";
        //audio products param
        String nameProduct=""; String idOwner=""; String url=""; int reproductionNumber=0;
        //songs param
        String album=""; int musicGenderSelection=0; double saleValue=0; int numberSales=0; 
        //podCast param
        String description=""; int podcastsCategorySelection=0;

        switch(option){
            case 1: 
                case1(msj, counter, nickNameUs, idUs, nameProducer, URLproducer, reproductionQuantityProducer, hours, minutes, second, choose);   
            break; 

            case 2:
                case2(msj, counter, nickNameUs, idUs, hours, minutes, second, mostListenedGender, mostListenedArtist, choose);
            break;
                
            case 3:
                case3(msj, counter, nameProduct, idOwner, url, hours, minutes, second, reproductionNumber, album, musicGenderSelection, saleValue, numberSales, description, podcastsCategorySelection, choose);
            break;
            case 0: 
                System.out.println("Exit program.");
                break; 

            default: 
                System.out.println("Invalid Option");
                break; 
        }
    }

    public void case1(String msj, int counter, String nickNameUs, String idUs, String nameProducer, String URLproducer, int reproductionQuantityProducer, int hours, int minutes, int second, int choose){
        System.out.println("type the nickname of the usuary");
        nickNameUs=reader.next();
        counter=controller.searchUserByNick(nickNameUs);
        if(counter==-1){
            System.out.println("type the id of the usuary");
            idUs=reader.next();
            counter=controller.searchUserById(idUs);
            if(counter==-1){
                System.out.println("type the name of the producer");
                nameProducer=reader.next();
                System.out.println("type the url image of the producer");
                URLproducer=reader.next();
                do{
                    System.out.println("if your producer is an artist press 1 or a content creator press 2");
                    choose=validateIntegerOption();
                    if(choose!=1 && choose !=2){
                        System.out.println("invalid option try again");
                    }
                }while(choose !=1 && choose !=2);

                msj=controller.createProductorUser(nickNameUs, idUs, nameProducer, URLproducer, reproductionQuantityProducer, hours, minutes, second, choose);
                System.out.println(msj);
            }else{
                System.out.println("this id is already used by another usuary");
            }
        }else{
            System.out.println("this nickname is already used by another usuary");
        }
        
        
        
    }

    public void case2(String msj, int counter, String nickNameUs, String idUs, int hours, int minutes, int second, String mostListenedGender, String mostListenedArtist, int choose){
        System.out.println("type the nickname of the usuary");
        nickNameUs=reader.next();
        counter=controller.searchUserByNick(nickNameUs);
        if(counter==-1){
            System.out.println("type the id of the usuary");
            idUs=reader.next();
            counter=controller.searchUserById(idUs);
            if(counter==-1){
                do{
                    System.out.println("if your consumer is standar press 1 or premium press 2");
                    choose=validateIntegerOption();
                    if(choose!=1 && choose !=2){
                        System.out.println("invalid option try again");
                    }
                }while(choose !=1 && choose !=2);

                msj=controller.createConsumerUser(nickNameUs, idUs, hours, minutes, second, mostListenedGender, mostListenedArtist, choose);
                System.out.println(msj);
            }else{
                System.out.println("this id is already used by another usuary");
            }
        }else{
            System.out.println("this nickname is already used by another usuary");
        }
        
        
        
    }

    public void case3(String msj, int counter, String nameProduct, String idOwner, String url, int hours, int minutes, int second, int reproductionNumber, String album, int musicGenderSelection, double saleValue, int numberSales, String description, int podcastsCategorySelection, int choose){
        System.out.println("type the name of the audio");
        nameProduct=reader.next();
        System.out.println("type the id of the owner of the audio");
        idOwner=reader.next();
        counter=controller.searchUserById(idOwner);
        if(counter!=-1){
                do{
                  System.out.println("type 1 to create a song or type 2 to create a postcast");
                  choose=validateIntegerOption();
                  if(choose!=1 && choose !=2){
                     System.out.println("invalid option try again");
                    }
                }while(choose !=1 && choose !=2);
                if(choose==1){
                    counter=controller.verifyArtistOrCreatorsByid(idOwner);
                    if(counter==1){
                        System.out.println("type the name of the album");
                        album=reader.next();
                        System.out.println("type the image of the album where the song belongs");
                        url=reader.next();
                        do{
                          System.out.println("select the gender of the song\n"+
                          "1)HOUSE\n"+
                          "2)POP\n"+
                          "3)ROCK\n"+
                          "4)TRAP\n");
                           musicGenderSelection=validateIntegerOption();
                           if(musicGenderSelection!=1 && musicGenderSelection!=2 && musicGenderSelection!=3 && musicGenderSelection!=4){
                              System.out.println("invalid option try again");
                            }
                        }while(musicGenderSelection!=1 && musicGenderSelection!=2 && musicGenderSelection!=3 && musicGenderSelection!=4);

                        do {
                           System.out.println("type the hours of the song");
                           hours=validateIntegerOption();
                           if(hours<0){
                             System.out.println("invalid option try again");  
                            }
                            if(hours>=24){
                                System.out.println("invalid option try again");  
                            }
                        } while (hours<0 || hours>=24);
                        do {
                            System.out.println("type the minutes of the song");
                            minutes=validateIntegerOption();
                            if(minutes<0){
                              System.out.println("invalid option try again");  
                            }
                            if(minutes>=60){
                                System.out.println("invalid option try again");  
                            }
                        } while (minutes<0 || minutes>=60);
                        do {
                           System.out.println("type the seconds of the song");
                           second=validateIntegerOption();
                           if(second<0){
                             System.out.println("invalid option try again");  
                            }
                           if(second>=60){
                                System.out.println("invalid option try again");  
                            }
                        } while (second<0 || second>=60);
                        System.out.println("duration is set to "+ hours + " hours, "+ minutes + " minutes, "+ second + " seconds");
                        do{
                          System.out.println("type the sale value of the song");
                          saleValue=validateDoubleOption();
                          if(second<0){
                             System.out.println("invalid option try again");  
                            }
                        }while(saleValue<0);
                        msj=controller.createProducts(nameProduct, idOwner, url, hours, minutes, second, reproductionNumber, album, musicGenderSelection, saleValue, numberSales, description, podcastsCategorySelection, choose);
                        System.out.println(msj);
                    }else{
                        System.out.println("the entered id does not match an artist's id");
                    }
                }else if(choose==2){
                    counter=controller.verifyArtistOrCreatorsByid(idOwner);
                    if(counter==2){  
                        do{
                            System.out.println("select the category of the podcast\n"+
                            "1)POLITICS\n"+
                            "2)ENTERTAINMENT\n"+
                            "3)VIDEOGAMES\n"+
                            "4)FASHION\n");
                            podcastsCategorySelection=validateIntegerOption();
                            if(podcastsCategorySelection!=1 && podcastsCategorySelection!=2 && podcastsCategorySelection!=3 && podcastsCategorySelection!=4){
                                System.out.println("invalid option try again");
                            }
                        }while(podcastsCategorySelection!=1 && podcastsCategorySelection!=2 && podcastsCategorySelection!=3 && podcastsCategorySelection!=4);
                        System.out.println("type the description of the podcast");
                        description=reader.next();
                        do {
                            System.out.println("type the hours of the podcast");
                            hours=validateIntegerOption();
                            if(hours<0){
                               System.out.println("invalid option try podcast");  
                            }
                            if(hours>=24){
                                System.out.println("invalid option try again");  
                            }
                        } while (hours<0 || hours>=24);
                        do {
                            System.out.println("type the minutes of the podcast");
                            minutes=validateIntegerOption();
                            if(minutes<0){
                                System.out.println("invalid option try again");  
                            }
                            if(minutes>=60){
                                System.out.println("invalid option try again");  
                            }
                        } while (minutes<0 || minutes>=60);
                        do {
                            System.out.println("type the seconds of the podcast");
                            second=validateIntegerOption();
                            if(second<0){
                               System.out.println("invalid option try again");  
                            }
                            if(second>=60){
                                System.out.println("invalid option try again");  
                            }
                        } while (second<0 || second>=60);
                        System.out.println("duration is set to "+ hours + " hours, "+ minutes + " minutes, "+ second + " seconds");
                        msj=controller.createProducts(nameProduct, idOwner, url, hours, minutes, second, reproductionNumber, album, musicGenderSelection, saleValue, numberSales, description, podcastsCategorySelection, choose);
                        System.out.println(msj);
                    }else{
                        System.out.println("the entered id does not match an Content creator's id");
                    }

                }
        }else{
            System.out.println("producer id not found");
        }
    }    
    




    
    


}


