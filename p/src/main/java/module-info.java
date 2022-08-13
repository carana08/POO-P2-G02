module com.mycompany.p {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.p to javafx.fxml;
    exports com.mycompany.p;
}
