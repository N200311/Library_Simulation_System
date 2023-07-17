package com.example.librarysystemgui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import java.io.IOException;

public class MenuController {
    @FXML
    Button AddBT,RemoveBT,BorrowBT,ReturnBT,ViewBT,ExitBT;

    public void AddBTAction(ActionEvent event) throws IOException {
        if(General.Booklist.size() == General.lib_Capacity){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Library Full");
            alert.setHeaderText("Library at Full Capacity");
            alert.show();
        }
        else {
            General.goToAdd(event);
        }
    }
    public void RemoveBTAction(ActionEvent event) throws IOException {
        General.goToRemove(event);
    }
    public void BorrowBTAction(ActionEvent event) throws IOException{
        General.goToBorrow(event);
    }
    public void ReturnBTAction(ActionEvent event) throws IOException{
        General.goToReturn(event);
    }
    public void ViewBTAction(ActionEvent event) throws IOException{
        General.goToView(event);
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
