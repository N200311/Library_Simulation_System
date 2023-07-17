module com.example.librarysystemgui {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;


    opens com.example.librarysystemgui to javafx.fxml;
    exports com.example.librarysystemgui;
}