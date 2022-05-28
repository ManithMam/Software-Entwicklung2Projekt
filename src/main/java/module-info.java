module SE2StartupProject {
    requires javafx.controls;
    requires javafx.fxml;

    opens mainpackage;
    opens classes;
    opens mainpackage.gui;
    opens rooms;
    opens items;
    opens items.commonItems;
    opens items.furniture;
    opens items.keyItems;
}
