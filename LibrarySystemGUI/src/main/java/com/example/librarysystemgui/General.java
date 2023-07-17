package com.example.librarysystemgui;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.*;
import java.util.ArrayList;

public class General {
    private static Parent root;
    private static Stage stage;
    private static Scene scene;
    public static ArrayList<Book> Booklist;
    public static int lib_Capacity;
    public static int Bio_Count = 0,Math_Count = 0,His_Count = 0,Chem_Count = 0,Poli_Count = 0;
    public static void goToMenu(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(General.class.getResource("MenuScene.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
    }
    public static void goToAdd(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(General.class.getResource("AddScene.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
    }
    public static void goToRemove(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(General.class.getResource("RemoveScene.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
    }
    public static void goToBorrow(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(General.class.getResource("BorrowScene.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
    }
    public static void goToReturn(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(General.class.getResource("ReturnScene.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
    }
    public static void goToView(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(General.class.getResource("ViewScene.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
    }
    public static boolean checkBorrowed(int id){
        boolean temp = false;
        for(int i = 0; i < Booklist.size(); i++){
            if(Booklist.get(i).getBookID() == id){
                 temp = Booklist.get(i).getBook_Borrowed();
            }
        }
        return temp;
    }
    public static boolean checkID(int id){
        for(int i = 0; i < General.Booklist.size(); i++){
            if(Booklist.get(i).getBookID() == id){
                return true;
            }
        }
        return false;
    }
    public static void SetDate(int id,String stdate,String endate, int days) {
        for(int i = 0; i < Booklist.size(); i++){
            if(Booklist.get(i).getBookID() == id){
                Booklist.get(i).setBook_Borrowed_Date(stdate);
                Booklist.get(i).setBook_BorrowedPeriod(days);
                Booklist.get(i).setBook_End_date(endate);
            }
        }
    }
    public static void RemoveBook(int id){
        for(int i = 0; i < Booklist.size(); i++){
            if(Booklist.get(i).getBookID() == id){
                Booklist.remove(i);
            }
        }

    }
    public static void BorrowBook(int id) {
        for(int i = 0; i < Booklist.size(); i++){
            if(Booklist.get(i).getBookID() == id){
                Booklist.get(i).setBook_Borrowed(true);
            }
        }
    }
    public static void ReturnBook(int id) {
        for(int i = 0; i < Booklist.size(); i++){
            if(Booklist.get(i).getBookID() == id){
                Booklist.get(i).setBook_Borrowed(false);
                Booklist.get(i).setBook_Borrowed_Date("-");
                Booklist.get(i).setBook_End_date("-");
                Booklist.get(i).setBook_BorrowedPeriod(0);
            }
        }
    }
    public static void Increment_Category(){
        Bio_Count = 0;
        Math_Count = 0;
        His_Count = 0;
        Chem_Count = 0;
        Poli_Count = 0;
        for(int i = 0; i < Booklist.size(); i++) {
            switch (Booklist.get(i).getBook_Category()) {
                case "Biology":
                    Bio_Count++;
                    break;
                case "Maths":
                    Math_Count++;
                    break;
                case "History":
                    His_Count++;
                    break;
                case "Chemistry":
                    Chem_Count++;
                    break;
                case "Politics":
                    Poli_Count++;
                    break;
            }
        }
    }
    public static int Increment_Borrow(){
        int Borrow_Count = 0;
        for(int i = 0; i < Booklist.size(); i++){
            if(Booklist.get(i).getBook_Borrowed()){
                Borrow_Count++;
            }
        }
        return Borrow_Count;
    }

}
