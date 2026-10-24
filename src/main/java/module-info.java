module org.uabc.ic.catalogomelodias {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.uabc.ic.catalogomelodias to javafx.fxml;
    exports org.uabc.ic.catalogomelodias;
}