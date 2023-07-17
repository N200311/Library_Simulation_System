package com.example.librarysystemgui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.util.ArrayList;

public class IntroController {
    @FXML
    private TextField IntroTextField;
    @FXML
    private Label LabelWarning;
    @FXML
    private Button ConBT;

    public void ContinueBTAction(ActionEvent event) throws IOException {
        try{
            General.lib_Capacity = Integer.parseInt(IntroTextField.getText());
            if(General.lib_Capacity == 0){
                LabelWarning.setText("Please Enter Positive Numbers Only");
            }
            else {
                General.Booklist = new ArrayList<>(General.lib_Capacity);
                General.goToMenu(event);
            }
        }
        catch(NumberFormatException e){
            LabelWarning.setText("Please Enter Numbers Only");
        }
        catch (IllegalArgumentException e){
            LabelWarning.setText("Please Enter Positive Numbers Only");
        }
    }
}