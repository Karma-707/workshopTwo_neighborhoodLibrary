package com.ps;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static String userInput = "";
    public static void main(String[] args) {
        System.out.println("Welcome to Stray Dogs Library!");

        do {
            menu(); //print menu to screen
            userInput = scanner.nextLine().trim(); //Get user input of choice

            //Switch based on user input
            switch (userInput) {
                case "1":

                    break;
                case "2":
                    break;
                case "4":
                    break;
                default:
                    System.out.println("Invalid input, please try again");
                    break;
            }

        } while (!userInput.equals("4")); //exits if user press 4 to quit

    }

    //display menu to user
    public static void menu() {
        System.out.println("What would you like to do today?\n" +
                "Here are some options to choose from:");

        System.out.print("Press 1: Show Available Books\n" +
                "Press 2: Show Checked Out Books\n" +
                "Press 4: Exits");
    }

    //display current avaiable books to user
    public static void availableBooks() {
        System.out.println("Current Books not checked out");
    }

}