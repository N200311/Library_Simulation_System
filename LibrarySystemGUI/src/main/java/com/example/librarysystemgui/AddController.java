package com.example.librarysystemgui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class AddController implements Initializable {
    @FXML
    TextField NameTF;
    @FXML
    Label DoneLabel;
    @FXML
    Button AddBT,MenuBT,ExitBT;
    @FXML
    ChoiceBox<String> Categories;
    private String[] CatList = {"Biology","Maths","History","Chemistry","Politics"};
    private String tempCat;
    public void AddBTAction(ActionEvent event){
        Random rand = new Random();
        int BID = rand.nextInt(100,900);
        String Bname = NameTF.getText();
        Book temp = new Book(BID,Bname, tempCat, false,"-",0);
        General.Booklist.add(temp);
        int id = 0;
        for (int i = 0; i < General.Booklist.size(); i++) {
            if (General.Booklist.get(i).getBook_Name().equals(Bname)) {
                id = General.Booklist.get(i).getBookID();
                break;
            }
        }
        DoneLabel.setText("Book Added Successfully. Book ID: " + id);
        DoneLabel.setAlignment(Pos.CENTER);
        AddBT.setDisable(true);
    }
    public void MenuBTAction(ActionEvent event) throws IOException{
        General.goToMenu(event);
    }
    public void ExitBTAction(ActionEvent event) throws IOException{
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exiting System");
        alert.setHeaderText("Are You Sure You Want To Exit The System? ");

        if(alert.showAndWait().get() == ButtonType.OK){
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.close();
        }
    }
    public void getCategory(ActionEvent event){
       tempCat = Categories.getValue();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Categories.getItems().addAll(CatList);
        Categories.setOnAction(this::getCategory);
    }
}

