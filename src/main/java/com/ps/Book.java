package com.ps;

public class Book {
    private static int id;
    private static String isbn;
    private static String title;
    private static boolean isCheckedOut; //if bk is checked out
    private static String checkedOutTo; //who the bk is checked out to
    private static String[] checkedOutToName = new String[20]; //name of person who checked out stored in
    private static String[] bookTitleInventory = {
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
    private static String[] bookAuthorInventory = {
            "Doppo Kunikida",
            "Yukito Ayatsuji",
            "Naomi Tanizaki",
            "Osamu Dazai",
            "Kenji Miyazawa",
            "Edogawa Ranpo",
            "Atsushi Nakajima",
            "Ryūnosuke Akutagawa",
            "Chuuya Nakahara",
            "Kouyou Ozaki",
            "Hirotsu Ryurou",
            "Oda Sakunosuke",
            "Sensei Yurei",
            "Kairo Gin",
            "Ango Sakaguchi",
            "Yosano Akiko",
            "Sei Shōnagon",
            "Kobo Abe",
            "Sakutarō Hagiwara",
            "Takuboku Ishikawa"
    };
    private static String[] bookIsbnInventory = {
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
    private static int[] bookIdInventory = new int[20];



    //Constructors
    public Book() {

    }



    //checkOut method
    public static void checkOut(String name) {
        isCheckedOut = true;
        checkedOutTo = name;
        for(int i = 0; i < bookIdInventory.length; i++) {
//            if(bookIdInventory.)
        }
    }

    //checkIn method
    public static void checkIn() {

    }

    //put all the bks in inventory
    private static void giveBookIds() {
        for (int i = 0; i < bookIdInventory.length; i++) {
            bookIdInventory[i] = i+1;
        }
    }





    //Getter Methods
    public static int getId() {
        return id;
    } //Get id

    public static String getIsbn() {
        return isbn;
    } //Get isbn

    public static String getTitle() {
        return title;
    } //Get book title

    public static boolean isIsCheckedOut() {
        return isCheckedOut;
    } // true/fa;se if checked out

    public static String getCheckedOutTo() {
        return checkedOutTo;
    } // checked out to who

    //Setter Methods
    public static void setId(int id) {
        Book.id = id;
    }

    public static void setIsbn(String isbn) {
        Book.isbn = isbn;
    }

    public static void setTitle(String title) {
        Book.title = title;
    }

    public static void setIsCheckedOut(boolean isCheckedOut) {
        Book.isCheckedOut = isCheckedOut;
    }

    public static void setCheckedOutTo(String checkedOutTo) {
        Book.checkedOutTo = checkedOutTo;
    }

}
