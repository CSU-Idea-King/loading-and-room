module org.example.modesellection {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.modesellection to javafx.fxml;
    exports org.example.modesellection;
}