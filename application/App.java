package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import application.entities.Client;
import application.entities.Corporation;

public class App{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n  -  Welcome to the TGID System :)  -\n");
        System.out.println("To proceed with registration, enter the desired number:\n1 - CPF\n2 - CNPJ\n3 - Exit");
        System.out.print("Enter a number: ");
        byte byteSelection = sc.nextByte();
        switch (byteSelection) {
            case 1:
                Client newClient = clientRegistration(sc);
                break;
            case 2:
                Corporation newCorporation = corporationRegistration(sc);
                break;
            case 3:
                System.out.println("Feel free! :)");
                break;
            default:
                System.out.println("Select a valid number");
                break;
        }
        sc.close();
    }

    public static Client clientRegistration(Scanner sc){
        long longNumberEntered = 0;
        long longNumberOfDigits = 0;
        boolean booNumberOk = false;
        boolean booApplicationError = false;
            do{
                try{
                    System.out.print("To get started, register your CPF (11 Digits): ");
                    longNumberEntered = sc.nextLong();


                    String strNumberEnteredToString = Long.toString(longNumberEntered);
                    longNumberOfDigits = strNumberEnteredToString.length();

                    if(longNumberOfDigits == 11){
                        booNumberOk = true;
                    }else{
                        System.out.println("- Enter a valid CPF - ");
                    }
                }catch (InputMismatchException e){
                    System.out.println("Error: You did not enter a valid character, please try again.");
                    booApplicationError = true;
                    break;
                }
            }while(booNumberOk == false);
            
            if(booApplicationError == true){
                System.out.print("");
            }else{
                String strPassword = passwordRegistration(sc);
                Client newClient = new Client(longNumberEntered, strPassword);
                System.out.println("Customer registered successfully!");
                return newClient;
            }
            return null;
    }

    public static Corporation corporationRegistration(Scanner sc){
        long longNumberEntered = 0;
        long longNumberOfDigits = 0;
        boolean booNumberOk = false;
        boolean booApplicationError = false;
            do{
                try{
                    System.out.print("To get started, register your CNPJ (14 Digits): ");
                    longNumberEntered = sc.nextLong();


                    String strNumberEnteredToString = Long.toString(longNumberEntered);
                    longNumberOfDigits = strNumberEnteredToString.length();

                    if(longNumberOfDigits == 14){
                        booNumberOk = true;
                    }else{
                        System.out.println("- Enter a valid CNPJ - ");
                    }
                }catch (InputMismatchException e){
                    System.out.println("Error: You did not enter a valid character, please try again.");
                    booApplicationError = true;
                    break;
                }
            }while(booNumberOk == false);

            if(booApplicationError == true){
                System.out.print("");
            }else{
                String strPassword = passwordRegistration(sc);
                Corporation newCorporation = new Corporation(longNumberEntered, strPassword);
                System.out.println("Company registered successfully!");
                return newCorporation;
            }    
            return null;
    }

    public static String passwordRegistration(Scanner sc){
        System.out.print("Register your password: ");
        String strPassword = sc.nextLine();
        sc.nextLine();
        return strPassword;
    }
}
