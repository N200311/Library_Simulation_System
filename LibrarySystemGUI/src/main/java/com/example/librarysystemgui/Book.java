package com.example.librarysystemgui;

public class Book {
    private int BookID;
    private String Book_Name;
    private String Book_Category;
    private boolean Book_Borrowed;
    private int Book_Borrowed_Period;
    private String Book_Borrowed_Date;
    private String Book_End_date;

    Book(int ID, String name, String cat, boolean borrowed, String borrow_date, int borrow_period){
        BookID = ID;
        Book_Name = name;
        Book_Category = cat;
        Book_Borrowed = borrowed;
        Book_Borrowed_Date = borrow_date;
        Book_Borrowed_Period = borrow_period;
        Book_End_date = "";
    }
    //setters
    public void setBookID(int bookID) {
            BookID = bookID;
        }
    public void setBook_Name(String name){
        this.Book_Name = name;
    }
    public void setBook_Category(String cat){
        this.Book_Category = cat;
    }
    public void setBook_Borrowed(boolean bool){
        this.Book_Borrowed = bool;
    }
    public void setBook_Borrowed_Date(String date){
        this.Book_Borrowed_Date = date;
    }
    public void setBook_BorrowedPeriod(int days) {
        this.Book_Borrowed_Period = days;
    }
    public void setBook_End_date(String book_End_date) {
        Book_End_date = book_End_date;
    }

    //getters
    public int getBookID() {
        return BookID;
    }
    public String getBook_Name(){
        return this.Book_Name;
    }
    public String getBook_Category(){return this.Book_Category;}
    public boolean getBook_Borrowed(){
        return this.Book_Borrowed;
    }
    public String getBook_Borrowed_Date(){return this.Book_Borrowed_Date;}
    public int getBook_Borrowed_Period() {
        return this.Book_Borrowed_Period;
    }
    public String getBook_End_date() {
        return this.Book_End_date;
    }


}
