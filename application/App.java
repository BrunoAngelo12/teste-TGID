package application;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("  -  Welcome to the TGID System :)  -\n");
        register(sc);
        System.out.println(":)");  

        sc.close();
    }

    public static void register(Scanner sc){
        long longNumberEntered = 0;
        long longNumberOfDigits;
        boolean booNumberOk = false;
            do{
                try{
                    System.out.print("To get started, register your CPF for an individual or CNPJ for a company: ");
                    longNumberEntered = sc.nextLong();


                    String strNumberEnteredToString = Long.toString(longNumberEntered);
                    longNumberOfDigits = strNumberEnteredToString.length();

                    if(longNumberOfDigits == 11 || longNumberOfDigits == 14){
                        booNumberOk = true;
                    }else{
                        System.out.println("- Enter a valid CPF or CNPJ number - ");
                    }
                }catch (InputMismatchException e){
                    System.out.println("Error: You did not enter a valid character, please try again.");
                    break;
                }
            }while(booNumberOk == false);        
    }
}
