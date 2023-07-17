package com.example.librarysystemgui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ViewController implements Initializable {
    @FXML
    private TableView<Book> View_Table;
    @FXML
    private TableColumn<Book, Boolean> Borrowed;
    @FXML
    private TableColumn<Book, String> Borrowed_Date;
    @FXML
    private TableColumn<Book, Integer> Borrowed_Period;
    @FXML
    private TableColumn<Book, String> Category;
    @FXML
    private TableColumn<Book, Integer> ID;
    @FXML
    private TableColumn<Book, String> Name;
    private ObservableList<Book> ObserBookList = FXCollections.observableArrayList();
    @FXML
    Label Bio_Label,Math_Label,His_Label,Chem_Label,Poli_Label,Borrow_Label;
    @FXML
    Button MenuBT,ExitBT;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ID.setCellValueFactory(new PropertyValueFactory<Book,Integer>("BookID"));
        Name.setCellValueFactory(new PropertyValueFactory<Book,String>("Book_Name"));
        Category.setCellValueFactory(new PropertyValueFactory<Book,String>("Book_Category"));
        Borrowed.setCellValueFactory(new PropertyValueFactory<Book,Boolean>("Book_Borrowed"));
        Borrowed_Date.setCellValueFactory(new PropertyValueFactory<Book,String>("Book_Borrowed_Date"));
        Borrowed_Period.setCellValueFactory(new PropertyValueFactory<Book,Integer>("Book_Borrowed_Period"));

        for(int i = 0;i < General.Booklist.size(); i++){
            ObserBookList.add(new Book(General.Booklist.get(i).getBookID(),General.Booklist.get(i).getBook_Name(),General.Booklist.get(i).getBook_Category(),
                    General.Booklist.get(i).getBook_Borrowed(),General.Booklist.get(i).getBook_Borrowed_Date(),General.Booklist.get(i).getBook_Borrowed_Period()));
        }

        View_Table.setItems(ObserBookList);

        General.Increment_Category();
        int Borrow_Count = General.Increment_Borrow();

        Bio_Label.setText("Number of Biology Books : " + General.Bio_Count);
        Math_Label.setText("Number of Maths Books : " + General.Math_Count);
        His_Label.setText("Number of History Books : " + General.His_Count);
        Chem_Label.setText("Number of Chemistry Books : " + General.Chem_Count);
        Poli_Label.setText("Number of Politics Books : " + General.Poli_Count);
        Borrow_Label.setText("Number of Borrowed Books : " + Borrow_Count);
    }

    public void MenuBTAction(ActionEvent event) throws IOException {
        General.goToMenu(event);
    }
    public void ExitBTAction(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exiting System");
        alert.setHeaderText("Are You Sure You Want To Exit The System? ");

        if(alert.showAndWait().get() == ButtonType.OK){
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.close();
        }
    }
}
