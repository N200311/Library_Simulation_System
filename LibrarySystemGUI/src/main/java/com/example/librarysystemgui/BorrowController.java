package com.example.librarysystemgui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class BorrowController{
    @FXML
    HBox hbox, datebox;
    @FXML
    Label WarningLabel,DoneLabel,STLabel,ENLabel,IDLabel;
    @FXML
    Button BorrowBT,MenuBT,ExitBT;
    @FXML
    DatePicker STDatePicker,ENDatePicker;
    @FXML
    TextField IDTextField;
    public void BorrowBTAction(ActionEvent event) {
        int ID = Integer.parseInt(IDTextField.getText());
        ID = CheckingID(ID);
        WarningLabel.setText("");
        String date = "";
        if(General.checkBorrowed(ID)){
            for(int i = 0; i < General.Booklist.size(); i++){
                if(General.Booklist.get(i).getBookID() == ID){
                    date = General.Booklist.get(i).getBook_End_date();
                }
            }
            WarningLabel.setText("Book is currently borrowed.\nYou can try again after " + date);
            BorrowBT.setDisable(true);
        }
        else{
            STLabel.setText("Enter Start Date : ");
            ENLabel.setText("Enter End Date : ");
            STDatePicker.setOpacity(1);
            ENDatePicker.setOpacity(1);
            LocalDate Date1 = STDatePicker.getValue();
            String FormattedDate1 = Date1.format(DateTimeFormatter.ofPattern("E, MMM dd yyyy"));
            LocalDate Date2 = ENDatePicker.getValue();
            String FormattedDate2 = Date2.format(DateTimeFormatter.ofPattern("E, MMM dd yyyy"));
            Period difference = Period.between(Date1, Date2);
            General.SetDate(ID,FormattedDate1,FormattedDate2,difference.getDays());

            hbox.setSpacing(70);
            hbox.setAlignment(Pos.CENTER);
            General.BorrowBook(ID);
            WarningLabel.setText("");
            DoneLabel.setText("Book Borrowed Successfully.");
            BorrowBT.setDisable(true);
        }
    }
    public void MenuBTAction(ActionEvent event) throws IOException{
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
    public int CheckingID(int id){
        if(!General.checkID(id)){
            WarningLabel.setText("Invalid ID. Not found in the Library.");
            id = Integer.parseInt(IDTextField.getText());
            CheckingID(id);
        }
        return id;
    }
}
