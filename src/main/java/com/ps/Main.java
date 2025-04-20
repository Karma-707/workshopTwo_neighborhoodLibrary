package com.ps;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Book[] booksInventory = { //book objects
            new Book(1, "978-4-90539-102-1", "Moonlit Bureaucracy"),
            new Book(2, "978-3-74921-008-3", "Snowfall over Yokohama"),
            new Book(3, "978-1-23459-999-6", "Blueprints for Justice"),
            new Book(4, "978-0-81231-771-0", "Last Words from the Sky"),
            new Book(5, "978-6-15621-451-9", "Leaves in the Fog"),
            new Book(6, "978-2-51234-872-3", "Static Between Pages"),
            new Book(7, "978-9-81345-673-5", "Wings Made of Ink"),
            new Book(8, "978-7-09123-553-0", "Veins of Crimson Paper"),
            new Book(9, "978-8-23456-909-1", "Symphony in Scarlet"),
            new Book(10, "978-5-12678-240-2", "Vesper at the Morgue"),
            new Book(11, "978-1-90432-233-2", "The Dead Can Read"),
            new Book(12, "978-3-76453-871-0", "Black Petals in Bloom"),
            new Book(13, "999-1-12345-019-3", "The Haunting Grammar of War"),
            new Book(14, "978-4-81235-876-0", "Darkness is a Language"),
            new Book(15, "978-4-81818-888-1", "Ten Thousand Umbrellas"),
            new Book(16, "978-3-21234-748-9", "Paper Hearts in Firelight"),
            new Book(17, "978-1-57245-918-7", "The Silence of Yellow Roses"),
            new Book(18, "978-4-31900-431-2", "The Clockmaker’s Paradox"),
            new Book(19, "978-3-84527-120-5", "My Shadow Walks Alone"),
            new Book(20, "978-0-68129-337-1", "Ink, Bones, and Lanterns")
    };

    public static void main(String[] args) {
        int mainCommand;
        System.out.println("\n\n\uD83D\uDD0DWelcome to Stray Dogs Library!\uD83D\uDD0D");
        int checkOutId;
        do {
            menu(); //print menu to screen
            System.out.print("Enter your command: ");
            mainCommand = checkMainCommand(); //Get user input of choice

            //Switch based on user input for menu
            switch (mainCommand) {
                case 1: //Press 1: Show Available Books
                    String checkOutCommand = "";
                    String name;

                    //Loop as much as user wants
                    do {
                        availableBooks(); //show available books
                        System.out.println(
                                "\nPress [C]: Check out a book (ID)" +
                                "\nPress [X]: Go back to home screen");
                        System.out.print("Enter your command: ");
//                        scanner.nextLine(); //eat the white space
                        checkOutCommand = checkCheckOutCommand();

                        //Switch based on user input for checkout
                        switch (checkOutCommand.toLowerCase()) {
                            case "c":
                                System.out.print("\nChecking out a book!\nEnter your name: ");
                                name = scanner.nextLine().trim();
                                System.out.print("\nBook ID: ");
                                checkOutId = checkIntInput();
                                int bookCount = 0;
                                for (int i = 0; i < booksInventory.length; i++) {
                                    bookCount++; //count how many books searched
                                    //Check if book ID they're looking for AND if book is not checked out
                                    if((booksInventory[i].getId() == checkOutId) && (!booksInventory[i].getIsCheckedOut())) {
                                        booksInventory[i].checkOut(name);
                                        System.out.println("✅ Book successfully checked out: " + booksInventory[i].getTitle() +
                                                " with ID#: " + booksInventory[i].getId());
                                        break;
                                    }
                                    //Check if book ID they're looking for AND book is already checked out
                                    else if ((booksInventory[i].getId() == checkOutId) && (booksInventory[i].getIsCheckedOut())) {
                                        System.out.println("❌ Sorry, the book had already been checked out");
                                    }
                                    //If cant find the book id user is looking for after checking the whole book inventory; the book doesn't exist
                                    if((bookCount == booksInventory.length) && (booksInventory[i].getId() != checkOutId) ) {
                                        System.out.println("❌ That book ID doesn't exist");
                                    }
                                }
                                break;
                            case "x":
                                System.out.println();
                                break;
                            default:
                                System.out.println("Invalid input, please try again");
                        }
                    } while (!checkOutCommand.equalsIgnoreCase("X"));
                    break;
                case 2: //Press 2: Show Checked Out Books
                    String checkInCommand = "";
                    int returnBookId;
                    checkedOutBooks(); //display checked out books
                    System.out.println(
                            "\nPress [R]: Return a book" +
                            "\nPress [X]: Go back to home screen");
                    System.out.print("Enter your command: ");
//                    scanner.nextLine(); //eat the white space
//                    scanner.nextLine(); //eat the white space

                    checkInCommand = checkCheckInCommand();

                    //Switch based on user input for checkIn/return
                    switch (checkInCommand.toLowerCase()) {
                        case "r":
                            System.out.print("\nReturning a book!\nID of the book your returning: ");
                            returnBookId = checkIntInput();
                            int bookCount2 = 0;
                            for (int i = 0; i < booksInventory.length; i++) {
                                bookCount2++;
                                //Check if returned book id matches AND if book is checked out
                                if ( (booksInventory[i].getId() == returnBookId) && (booksInventory[i].getIsCheckedOut()) ) {
                                    booksInventory[i].checkIn(); //make book available to others to check out
                                    System.out.println("✅ Book successfully returned: " + booksInventory[i].getTitle() +
                                            " with ID#: " + booksInventory[i].getId());
                                    break;
                                }
                                //Check if book return ID isn't checked out, then you cant return it
                                else if ( (booksInventory[i].getId() == returnBookId) && (!booksInventory[i].getIsCheckedOut()) ) {
                                    System.out.println("❌ Sorry, the book wasn't checked out: " + booksInventory[i].getTitle() +
                                            " with ID#: " + booksInventory[i].getId());
                                    break;
                                }
                                //If cant find the book id user is looking for after checking the whole book inventory; the book doesn't exist
                                if((bookCount2 == booksInventory.length) && (booksInventory[i].getId() != returnBookId) ) {
                                    System.out.println("❌ That book ID doesn't exist");
                                }
                            }
                            break;
                        case "x":
                            System.out.println();
                            break;
                        default:
                            System.out.println("Invalid input, please try again");
                    }


                    break;
                case 0: //Press 0: Exits
                    System.out.println("Thank you for visiting Stray Dogs Library! Have a safe trip!");
                    break;
                default:
                    System.out.println("Invalid input, please try again");
                    break;
            }

        } while (mainCommand != 0); //exits if user press 4 to quit

    }

    //display menu to user
    public static void menu() {
        System.out.println("\nWhat would you like to do today?\n" +
                "Here are some options to choose from:");

        System.out.println(
                "Press 1: Show Available Books\n" +
                "Press 2: Show Checked Out Books\n" +
                "Press 0: Exits");
    }

    //display current available books to user
    public static void availableBooks() {
        System.out.println("\n\nAvailable Books to checked out");
        for (int i = 0; i < booksInventory.length; i++) {
            if (!booksInventory[i].getIsCheckedOut()) {
                System.out.println(
                        "ID: " + booksInventory[i].getId() +
                        "\tISBN: " + booksInventory[i].getIsbn() +
                        "\tTitle: " + booksInventory[i].getTitle() );
            }
        }
    }

    //display checked out books to user
    public static void checkedOutBooks() {
        int count = 0;
        System.out.println("\n\uD83D\uDCDABooks currently checked out:");
        for (int i = 0; i < booksInventory.length; i++) {
            if(booksInventory[i].getIsCheckedOut()) {
                System.out.println(
                        "\uD83D\uDD16ID: " + booksInventory[i].getId() +
                                "\n\uD83D\uDD22ISBN: " + booksInventory[i].getIsbn() +
                                "\n\uD83D\uDCD8Title: " + booksInventory[i].getTitle() +
                                "\n\uD83D\uDE4BChecked out person: " + booksInventory[i].getCheckedOutTo());
                System.out.println();
                count++;
            }
        }
        if(count == 0) {
            System.out.println("Currently no books checked out\n\n");
        }
        System.out.println();
    }

    //check main command is correct and then return it
    public static int checkMainCommand() {
        String userInput = scanner.nextLine();
        //while user input isn't 0 or 1 or 2, keep letting them re-enter value
        while (!userInput.matches("[0-2]")) { //regex for only 0-2 choice for input
            System.out.print("Sorry invalid command. Please try again: ");
            userInput = scanner.nextLine();
        }
        return Integer.parseInt(userInput); //return user value in int
    }

    //Check if user input is int then return int if true
    public static int checkIntInput() {
        String userInput = scanner.nextLine().trim();
        //while user input isn't an int, keep letting them re-enter value
        while (!userInput.matches("\\d+")) {
            System.out.print("Sorry invalid command. Please try again: ");
            userInput = scanner.nextLine();
        }
        return Integer.parseInt(userInput); //return user value in int
    }

    //Check if check out command is correct then return it
    public static String checkCheckOutCommand() {
        String userInput = scanner.nextLine().trim();
        //while user input isn't c or x, keep letting them re-enter value
        while (!userInput.matches("(?i)[cx]")) {
            System.out.print("Sorry invalid command. Please try again: ");
            userInput = scanner.nextLine();
        }
        return userInput; //return user command
    }

    //Check if check in command is correct then return it
    public static String checkCheckInCommand() {
        String userInput = scanner.nextLine().trim();
        //while user input isn't c or x, keep letting them re-enter value
        while (!userInput.matches("(?i)[rx]")) {
            System.out.print("Sorry invalid command. Please try again: ");
            userInput = scanner.nextLine();
        }
        return userInput; //return user command
    }


}

//    static String[] bookAuthorInventory = {
//            "Doppo Kunikida",
//            "Yukito Ayatsuji",
//            "Naomi Tanizaki",
//            "Osamu Dazai",
//            "Kenji Miyazawa",
//            "Edogawa Ranpo",
//            "Atsushi Nakajima",
//            "Ryūnosuke Akutagawa",
//            "Chuuya Nakahara",
//            "Kouyou Ozaki",
//            "Hirotsu Ryurou",
//            "Oda Sakunosuke",
//            "Sensei Yurei",
//            "Kairo Gin",
//            "Ango Sakaguchi",
//            "Yosano Akiko",
//            "Sei Shōnagon",
//            "Kobo Abe",
//            "Sakutarō Hagiwara",
//            "Takuboku Ishikawa"
//    };