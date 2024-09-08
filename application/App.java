package application;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("  -  Welcome to the TGID System :)  -\n");
        int intNumberEntered = 0;
        int intNumberOfDigits;
        do{
            try{
                System.out.print("To get started, register your CPF for an individual or CNPJ for a company: ");
                intNumberEntered = sc.nextInt();
                String strNumberEnteredToString = Integer.toString(intNumberEntered);
                intNumberOfDigits = strNumberEnteredToString.length();
                if(intNumberOfDigits != 11 && intNumberOfDigits != 14){
                    System.out.println(" - Enter a valid CPF or CNPJ number - ");
                }
            }catch (InputMismatchException e){
                System.out.println("Error: You did not enter a valid character, please try again.");
                break;
            }
        }while(intNumberEntered != 11 && intNumberEntered != 14);        
        
        sc.close();
    }
}
