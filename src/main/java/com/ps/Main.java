package com.ps;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static boolean isFirstVisitAvailableBooks = true;
    static Book[] booksInventory = { //book objects
            new Book(1, "978-4-90539-102-1", "Moonlit Bureaucracy", "Doppo Kunikida"),
            new Book(2, "978-3-74921-008-3", "Snowfall over Yokohama", "Yukito Ayatsuji"),
            new Book(3, "978-1-23459-999-6", "Blueprints for Justice", "Naomi Tanizaki"),
            new Book(4, "978-0-81231-771-0", "Last Words from the Sky", "Osamu Dazai"),
            new Book(5, "978-6-15621-451-9", "Leaves in the Fog", "Kenji Miyazawa"),
            new Book(6, "978-2-51234-872-3", "Static Between Pages", "Edogawa Ranpo"),
            new Book(7, "978-9-81345-673-5", "Wings Made of Ink", "Atsushi Nakajima"),
            new Book(8, "978-7-09123-553-0", "Veins of Crimson Paper", "Ryūnosuke Akutagawa"),
            new Book(9, "978-8-23456-909-1", "Symphony in Scarlet", "Chuuya Nakahara"),
            new Book(10, "978-5-12678-240-2", "Vesper at the Morgue", "Kouyou Ozaki"),
            new Book(11, "978-1-90432-233-2", "The Dead Can Read", "Hirotsu Ryurou"),
            new Book(12, "978-3-76453-871-0", "Black Petals in Bloom", "Oda Sakunosuke"),
            new Book(13, "999-1-12345-019-3", "The Haunting Grammar of War", "Sensei Yurei"),
            new Book(14, "978-4-81235-876-0", "Darkness is a Language", "Kairo Gin"),
            new Book(15, "978-4-81818-888-1", "Ten Thousand Umbrellas", "Ango Sakaguchi"),
            new Book(16, "978-3-21234-748-9", "Paper Hearts in Firelight", "Yosano Akiko"),
            new Book(17, "978-1-57245-918-7", "The Silence of Yellow Roses", "Sei Shōnagon"),
            new Book(18, "978-4-31900-431-2", "The Clockmaker’s Paradox", "Kobo Abe"),
            new Book(19, "978-3-84527-120-5", "My Shadow Walks Alone", "Sakutarō Hagiwara"),
            new Book(20, "978-0-68129-337-1", "Ink, Bones, and Lanterns", "Takuboku Ishikawa")
    };

    public static void main(String[] args) throws InterruptedException {
        int mainCommand;
        System.out.println("\n\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("\uD83D\uDD0DWelcome to Stray Dogs Library!\uD83D\uDD0D");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

        int checkOutId;
        do {
            menu(); //print menu to screen
            System.out.print("\uD83D\uDC49 Enter your command: ");
            mainCommand = checkMainCommand(); //Get user input of choice

            //Switch based on user input for menu
            switch (mainCommand) {
                case 1: //Press 1: Show Available Books
                    String checkOutCommand = "";
                    String name;

                    availableBooks(); //show available books

                    //Loop as much as user wants
                    do {
                        System.out.println(
                                "\n\uD83D\uDFE2 Press [C] ➤ Check out a book (ID)" +
                                "\n\uD83D\uDD19 Press [X] ➤ Go back to home screen");
                        System.out.print("\uD83D\uDC49 Enter your command: ");
                        checkOutCommand = checkCheckOutCommand();

                        //Switch based on user input for checkout
                        switch (checkOutCommand.toLowerCase()) {
                            case "c":
                                System.out.print("\n\uD83D\uDCD6Checking out a book!\n\uD83D\uDD8A\uFE0F Enter your name: ");
                                name = scanner.nextLine().trim();
                                System.out.print("\uD83D\uDD16Book ID: ");
                                checkOutId = checkIntInput();
                                boolean bookFound = false;
                                for (int i = 0; i < booksInventory.length; i++) {
                                    if (booksInventory[i].getId() == checkOutId) {
                                        bookFound = true;
                                        //Check if book ID they're looking for AND if book is not checked out
                                        if (!booksInventory[i].getIsCheckedOut()) {
                                            booksInventory[i].checkOut(name);
                                            System.out.println("✅ Book successfully checked out!");
                                            System.out.printf("\uD83D\uDD16ID: %-3d  \uD83D\uDD22ISBN: %-17s  \uD83D\uDCD8Title: %-35s  ✍️Author: %-20s\n",
                                                    booksInventory[i].getId(),
                                                    booksInventory[i].getIsbn(),
                                                    booksInventory[i].getTitle(),
                                                    booksInventory[i].getAuthor());
                                            break;
                                        }
                                        //Check if book ID they're looking for AND book is already checked out
                                        else if (booksInventory[i].getIsCheckedOut()) {
                                            System.out.println("❌ Sorry, the book had already been checked out");
                                            break;
                                        }
                                    }
                                }
                                //If cant find the book id user is looking for after checking the whole book inventory; the book doesn't exist
                                if(!bookFound) {
                                    System.out.println("❌ That book ID doesn't exist");
                                }
                                break;
                            case "x":
                                System.out.println();
                                break;
                            default:
                                System.out.println("⚠\uFE0F Invalid input, please try again");
                        }
                    } while (!checkOutCommand.equalsIgnoreCase("X"));
                    break;
                case 2: //Press 2: Show Checked Out Books
                    //if no books are checked out don't let them return anything; else return list checked out
                    if(!checkedOutBooks()) {
                        break;
                    }

                    String checkInCommand = "";
                    int returnBookId;

                    do {
                        System.out.println(
                                "\n\uD83D\uDCE6 Press [R] ➤ Return a book" +
                                "\n\uD83D\uDD19 Press [X] ➤ Go back to home screen");
                        System.out.print("\uD83D\uDC49 Enter your command: ");
                        checkInCommand = checkCheckInCommand();

//                        if(!checkInCommand.equalsIgnoreCase("x")) {
//                            checkedOutBooks(); //display checked out books
//                        }

                        //Switch based on user input for checkIn/return
                        switch (checkInCommand.toLowerCase()) {
                            case "r":
                                System.out.print("\n\uD83D\uDCE6 Returning a book!\n\uD83D\uDD16Book ID: ");
                                returnBookId = checkIntInput();
                                int bookCount2 = 0;
                                for (int i = 0; i < booksInventory.length; i++) {
                                    bookCount2++;
                                    //Check if returned book id matches AND if book is checked out
                                    if ((booksInventory[i].getId() == returnBookId) && (booksInventory[i].getIsCheckedOut())) {
                                        booksInventory[i].checkIn(); //make book available to others to check out
                                        System.out.println("✅ Book successfully returned!");
                                        System.out.printf("\uD83D\uDD16ID: %-3d  \uD83D\uDD22ISBN: %-17s  \uD83D\uDCD8Title: %-35s  ✍️Author: %-20s\n",
                                                booksInventory[i].getId(),
                                                booksInventory[i].getIsbn(),
                                                booksInventory[i].getTitle(),
                                                booksInventory[i].getAuthor());
                                        break;
                                    }
                                    //Check if book return ID isn't checked out, then you cant return it
                                    else if ((booksInventory[i].getId() == returnBookId) && (!booksInventory[i].getIsCheckedOut())) {
                                        System.out.println("❌ Sorry, the book wasn't checked out");
                                        break;
                                    }
                                    //If cant find the book id user is looking for after checking the whole book inventory; the book doesn't exist
                                    if ((bookCount2 == booksInventory.length) && (booksInventory[i].getId() != returnBookId)) {
                                        System.out.println("❌ That book ID doesn't exist");
                                    }
                                }
                                break;
                            case "x":
                                System.out.println();
                                break;
                            default:
                                System.out.println("⚠\uFE0F Invalid input, please try again");
                        }
                    } while (!checkInCommand.equalsIgnoreCase("x"));
                    break;
                case 0: //Press 0: Exits
                    System.out.println("\uD83D\uDD6F\uFE0F Thank you for visiting Stray Dogs Library! Until next time!");
                    break;
                default:
                    System.out.println("⚠\uFE0F Invalid input, please try again");
                    break;
            }

        } while (mainCommand != 0); //exits if user press 4 to quit

    }

    //display menu to user
    public static void menu() {
        System.out.println("\n✨ What would you like to do today?\n" +
                "\uD83D\uDCCB Here are some options to choose from:");

        System.out.println(
                "1\uFE0F⃣ Press 1 ➤ Show Available Books\n" +
                "2\uFE0F⃣ Press 2 ➤ Show Checked Out Books\n" +
                "0\uFE0F⃣ Press 0 ➤ Exits");
    }

    //display current available books to user
    public static void availableBooks() throws InterruptedException {
        System.out.print("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("\n\n\uD83D\uDCDAAvailable Books to checked out");
        for (int i = 0; i < booksInventory.length; i++) {
            if (isFirstVisitAvailableBooks) {
                Thread.sleep(250);
            }
            if (!booksInventory[i].getIsCheckedOut()) {
                System.out.printf("\uD83D\uDD16ID: %-3d  \uD83D\uDD22ISBN: %-17s  \uD83D\uDCD8Title: %-35s  ✍️Author: %-20s\n",
                        booksInventory[i].getId(),
                        booksInventory[i].getIsbn(),
                        booksInventory[i].getTitle(),
                        booksInventory[i].getAuthor());
            }
        }
        //After first run, make the book display not slow
        isFirstVisitAvailableBooks = false;
    }

    //display checked out books to user
    public static boolean checkedOutBooks() {
        int count = 0;
        System.out.println("\n\uD83D\uDCDABooks currently checked out:");
        for (int i = 0; i < booksInventory.length; i++) {
            if(booksInventory[i].getIsCheckedOut()) {
                System.out.printf(
                        "\uD83D\uDD16ID: %-3d\n\uD83D\uDD22ISBN: %-17s\n\uD83D\uDCD8Title: %-35s\n✍️Author: %-20s\n\uD83D\uDE4BChecked out person: %s\n",
                        booksInventory[i].getId(),
                        booksInventory[i].getIsbn(),
                        booksInventory[i].getTitle(),
                        booksInventory[i].getAuthor(),
                        booksInventory[i].getCheckedOutTo()
                );

                System.out.println();
                count++;
            }
        }
        if(count == 0) {
            System.out.println("\uD83D\uDFE2 All books are currently available!");
            System.out.println("💀 Dazai would say: \"How can you return what you never held in the first place?\"");
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

            return false;
        }
        System.out.println();
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

        return true;
    }

    //Check user commands, methods below

    //check main command is correct and then return it
    public static int checkMainCommand() {
        String userInput = scanner.nextLine();
        //while user input isn't 0 or 1 or 2, keep letting them re-enter value
        while (!userInput.matches("[0-2]")) { //regex for only 0-2 choice for input
            System.out.print("⚠\uFE0F Sorry invalid command. Please try again: ");
            userInput = scanner.nextLine();
        }
        return Integer.parseInt(userInput); //return user value in int
    }

    //Check if user input is int then return int if true
    public static int checkIntInput() {
        String userInput = scanner.nextLine().trim();
        //while user input isn't an int, keep letting them re-enter value
        while (!userInput.matches("\\d+")) {
            System.out.print("⚠\uFE0F Sorry invalid command. Please try again: ");
            userInput = scanner.nextLine();
        }
        return Integer.parseInt(userInput); //return user value in int
    }

    //Check if check out command is correct then return it
    public static String checkCheckOutCommand() {
        String userInput = scanner.nextLine().trim();
        //while user input isn't c or x, keep letting them re-enter value
        while (!userInput.matches("(?i)[cx]")) {
            System.out.print("⚠\uFE0F Sorry invalid command. Please try again: ");
            userInput = scanner.nextLine();
        }
        return userInput; //return user command
    }

    //Check if check in command is correct then return it
    public static String checkCheckInCommand() {
        String userInput = scanner.nextLine().trim();
        //while user input isn't c or x, keep letting them re-enter value
        while (!userInput.matches("(?i)[rx]")) {
            System.out.print("⚠\uFE0F Sorry invalid command. Please try again: ");
            userInput = scanner.nextLine();
        }
        return userInput; //return user command
    }


}

