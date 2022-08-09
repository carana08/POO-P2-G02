module com.mycompany.parcial2 {
    requires javafx.controls;
    requires javafx.fxml;
    //requires java.base;

    opens com.mycompany.parcial2 to javafx.fxml;
    exports javafxbase;
}
