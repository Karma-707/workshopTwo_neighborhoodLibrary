package com.ps;

public class Book {
    private int id;
    private String isbn;
    private String title;
    private static boolean isCheckedOut; //if bk is checked out
    private static String checkedOutTo; //who the bk is checked out to
//    private String[] checkedOutToName = new String[20]; //name of person who checked out stored in



    //Constructors
    public Book(int id, String isbn, String title) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
    }


    //checkOut method
    public static void checkOut(String name) {
        isCheckedOut = true;
        checkedOutTo = name;
    }

    //checkIn method
    public static void checkIn() {
        checkedOutTo = ""; //empty the checkOutTo make it available for others
        isCheckedOut = false;
    }






    //Getter Methods
    public int getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public static boolean isIsCheckedOut() {
        return isCheckedOut;
    }

    public static String getCheckedOutTo() {
        return checkedOutTo;
    }



    //Setter Methods
    public void setId(int id) {
        this.id = id;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static void setIsCheckedOut(boolean isCheckedOut) {
        Book.isCheckedOut = isCheckedOut;
    }

    public static void setCheckedOutTo(String checkedOutTo) {
        Book.checkedOutTo = checkedOutTo;
    }


}
