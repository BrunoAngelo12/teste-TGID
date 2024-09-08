package application;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("  -  Welcome to the TGID System :)  -\n");
        int numberEntered;
        try{
            System.out.print("To get started, register your CPF for an individual or CNPJ for a company: ");
            numberEntered = sc.nextInt();
        }catch (InputMismatchException e){
            System.out.println("Error: You did not enter a valid number, please try again.");
        }
        System.out.println(numberEntered);   
        sc.close();
    }
}
