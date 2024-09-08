package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import application.entities.Client;
import application.entities.Corporation;

public class App{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char charContinue = 'y';
        List<Client> listClient = new ArrayList<>();
        List<Corporation> listCorporation = new ArrayList<>();
        int i =0;

        System.out.println("\n  -  Welcome to the TGID System :)  -\n");
        
        do{
            System.out.println("To proceed with registration, enter the desired number:\n1 - CPF\n2 - CNPJ\n3 - Exit");
            System.out.print("Enter a number: ");
            byte byteSelection = sc.nextByte();
                switch (byteSelection) {
                    case 1:
                        Client newClient = clientRegistration(sc, i);
                        listClient.add(newClient);
                        i++;
                        break;
                    case 2:
                        Corporation newCorporation = corporationRegistration(sc, i);
                        listCorporation.add(newCorporation);
                        i++;
                        break;
                    case 3:
                        System.out.println("Feel free! :)");
                        break;
                    default:
                        System.out.println("Select a valid number");
                        break;
            }
            System.out.print("\n Do you want to register again? - y = yes | n = no: ");
            charContinue = sc.next().charAt(0);
            System.out.println();
        }while(charContinue == 'y');

        System.out.println(" - List of companies - \n");
        for(Corporation x : listCorporation){
            System.out.println(x.toString());
            System.out.println("- - -");
        }
        System.out.println();
        System.out.println(" - Customer list - \n");
        for(Client x : listClient){
            System.out.println(x.toString());
        }
        System.out.println("\n");

        System.out.println("Select the desired operation:\n1 - Withdraw money\n2 - Deposit money");
        System.out.print("Enter a number: ");
        byte byteSelection = sc.nextByte();
        boolean booVerification = false;
        System.out.println();
        switch (byteSelection) {
            case 1:
                System.out.print("Enter the customer ID and company ID to withdraw money\nCustomer ID: ");
                int iDClient = sc.nextInt();
                System.out.print("Company ID: ");
                int iDCompany = sc.nextInt();
                System.out.print("Enter the withdrawal amount: ");
                double doubWithdrawalAmount = sc.nextDouble();
                sc.nextLine();

                for(Client x : listClient){
                    int iD = x.getiD();
                    if(iD == iDClient){
                        do{
                            System.out.print("Enter the customer password: ");
                            int  strPassword = sc.nextInt();
                            if(strPassword == x.getStrPassword()){
                                for(Corporation y : listCorporation){
                                    iD = y.getiD();
                                    if(iD == iDCompany){
                                        y.withdrawMoney(doubWithdrawalAmount);
                                    }else{
                                        System.out.println("Check company ID");
                                    }
                                }
                                booVerification = true;
                            }else{
                                System.out.println("Try the password again: ");
                            }
                        }while(booVerification == false);
                    }
                }
                break;
            case 2:
                System.out.print("Enter Customer ID and Company ID to deposit money\nCustomer ID: ");
                iDClient = sc.nextInt();
                System.out.print("Company ID: ");
                iDCompany = sc.nextInt();
                System.out.print("Enter the deposit amount: ");
                double doubDepositAmount = sc.nextDouble();
                sc.nextLine();

                for(Client x : listClient){
                    int iD = x.getiD();
                    if(iD == iDClient){
                        do{
                            System.out.print("Enter the customer password: ");
                            int  strPassword = sc.nextInt();
                            if(strPassword == x.getStrPassword()){
                                for(Corporation y : listCorporation){
                                    iD = y.getiD();
                                    if(iD == iDCompany){
                                        y.depositMoney(doubDepositAmount);
                                    }else{
                                        System.out.println("Check company ID");
                                    }
                                }
                                booVerification = true;
                            }else{
                                System.out.println("Try the password again: ");
                            }
                        }while(booVerification == false);
                    }
                }
            break;
            default:
                System.out.println("Invalid option, please try again.");
                break;
        }

        System.out.println("Come back often!");
        sc.close();
    }

    public static Client clientRegistration(Scanner sc, int iD){
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
                int strPassword = passwordRegistration(sc);
                Client newClient = new Client(longNumberEntered, strPassword, iD);
                System.out.println("Customer registered successfully!");
                return newClient;
            }
            return null;
    }

    public static Corporation corporationRegistration(Scanner sc, int iD){
        long longNumberEntered = 0;
        long longNumberOfDigits = 0;
        boolean booNumberOk = false;
        boolean booApplicationError = false;
        int intSystemFee = 0;
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
                    System.out.print("Enter the system fee percentage number on transactions: ");
                    intSystemFee = sc.nextInt();
                }catch (InputMismatchException e){
                    System.out.println("Error: You did not enter a valid character, please try again.");
                    booApplicationError = true;
                    break;
                }
            }while(booNumberOk == false);

            if(booApplicationError == true){
                System.out.print("");
            }else{
                int strPassword = passwordRegistration(sc);
                Corporation newCorporation = new Corporation(longNumberEntered, strPassword, intSystemFee, iD);
                System.out.println("Company registered successfully!");
                return newCorporation;
            }    
            return null;
    }

    public static int passwordRegistration(Scanner sc){
        System.out.print("Register your password: ");
        int strPassword = sc.nextInt();
        sc.nextLine();
        return strPassword;
    }
}
