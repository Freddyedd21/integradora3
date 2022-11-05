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
        "0. exit program";
    
    }
    public int validateIntegerOption(){
        int option = 0; 

        if(reader.hasNextInt()){
            option = reader.nextInt(); 
        }
        else{
            // clear reader. 
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
        String msj="";


        switch(option){
            case 1: 
                    
                break; 

                
            case 0: 
                System.out.println("Exit program.");
                break; 

            default: 
                System.out.println("Invalid Option");
                break; 
        }
    }

    public void case1(){
        
    }


    
    


}


