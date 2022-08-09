module com.mycompany.parcial2 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.parcial2 to javafx.fxml;
    exports com.mycompany.parcial2;
}
