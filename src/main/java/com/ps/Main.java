package com.ps;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static String userInput = "";
    static Book[] booksInventory = new Book[20]; //book objects
    static String[] bookTitleInventory = {
            "Moonlit Bureaucracy",
            "Snowfall over Yokohama",
            "Blueprints for Justice",
            "Last Words from the Sky",
            "Leaves in the Fog",
            "Static Between Pages",
            "Wings Made of Ink",
            "Veins of Crimson Paper",
            "Symphony in Scarlet",
            "Vesper at the Morgue",
            "The Dead Can Read",
            "Black Petals in Bloom",
            "The Haunting Grammar of War",
            "Darkness is a Language",
            "Ten Thousand Umbrellas",
            "Paper Hearts in Firelight",
            "The Silence of Yellow Roses",
            "The Clockmaker’s Paradox",
            "My Shadow Walks Alone",
            "Ink, Bones, and Lanterns"
    };
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
    static String[] bookIsbnInventory = {
            "978-4-90539-102-1",
            "978-3-74921-008-3",
            "978-1-23459-999-6",
            "978-0-81231-771-0",
            "978-6-15621-451-9",
            "978-2-51234-872-3",
            "978-9-81345-673-5",
            "978-7-09123-553-0",
            "978-8-23456-909-1",
            "978-5-12678-240-2",
            "978-1-90432-233-2",
            "978-3-76453-871-0",
            "999-1-12345-019-3",
            "978-4-81235-876-0",
            "978-4-81818-888-1",
            "978-3-21234-748-9",
            "978-1-57245-918-7",
            "978-4-31900-431-2",
            "978-3-84527-120-5",
            "978-0-68129-337-1"
    };


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

    //display current available books to user
    public static void availableBooks() {
        System.out.println("Current Books not checked out");
        for (Book book : booksInventory) {
            System.out.println(
                    "ID: " + book.getId() +
                    "Title: " + book.getTitle() +
                    "ISBN: " + book.getIsbn());
        }
    }

    //store book object in array fullInventory
    public static void initializeBookInventory() {
        for (int i = 0; i < booksInventory.length; i++) {
            booksInventory[i] = new Book(i+1, bookIsbnInventory[i], bookTitleInventory[i]);

        }
    }

}