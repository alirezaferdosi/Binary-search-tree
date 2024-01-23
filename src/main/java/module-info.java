module com.example.javaproject {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.javaproject to javafx.fxml;
    exports com.example.javaproject;
}