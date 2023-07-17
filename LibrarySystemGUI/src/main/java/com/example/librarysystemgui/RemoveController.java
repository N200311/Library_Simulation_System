package com.example.librarysystemgui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.io.IOException;

public class RemoveController{
    @FXML
    HBox hbox;
    @FXML
    Label WarningLabel,DoneLabel,IDLabel;
    @FXML
    Button RemoveBT,MenuBT,ExitBT;
    @FXML
    TextField IDTextField;

    public void RemoveBTAction(ActionEvent event){
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
            RemoveBT.setDisable(true);
        }
        else{
            hbox.setSpacing(70);
            General.RemoveBook(ID);
            DoneLabel.setText("Book is successfully removed.");
            RemoveBT.setDisable(true);
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
