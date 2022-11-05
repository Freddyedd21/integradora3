package ui;

import java.util.Scanner;


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

        switch(option){
            case 1: 
                case1(msj, counter, nickNameUs, idUs, nameProducer, URLproducer, reproductionQuantityProducer, hours, minutes, second, choose);   
            break; 

            case 2:
                case2(msj, counter, nickNameUs, idUs, hours, minutes, second, mostListenedGender, mostListenedArtist, choose);
            break;

            case 3:
                
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
                    if(choose==-1){
                        System.out.println("invalid option try again");
                    }else if(choose!=1 && choose !=2){
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
                    if(choose==-1){
                        System.out.println("invalid option try again");
                    }else if(choose!=1 && choose !=2){
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

    




    
    


}


