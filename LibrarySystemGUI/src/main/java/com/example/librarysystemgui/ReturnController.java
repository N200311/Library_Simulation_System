package com.example.librarysystemgui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.io.IOException;


public class ReturnController{
    HBox hbox;
    @FXML
    Label WarningLabel,DoneLabel,IDLabel;
    @FXML
    Button ReturnBT,MenuBT,ExitBT;
    @FXML
    TextField IDTextField;

    public void ReturnBTAction(ActionEvent event) {
        IDLabel.setText("Enter Book ID :");
        int ID = Integer.parseInt(IDTextField.getText());
        ID = CheckingID(ID);
        if(General.checkBorrowed(ID)){
            for(int i = 0; i < General.Booklist.size(); i++){
                if(General.Booklist.get(i).getBookID() == ID){
                    General.ReturnBook(ID);
                    WarningLabel.setText("");
                    DoneLabel.setText("Book is successfully returned.");
                    ReturnBT.setDisable(true);
                }
            }
        }
        else {
            WarningLabel.setText("Book is not borrowed.");
            ReturnBT.setDisable(true);
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
