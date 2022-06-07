module SE2StartupProject {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.logging.log4j.core;
    requires org.apache.logging.log4j;

    opens mainpackage;
    opens classes;
    opens mainpackage.gui;
    opens rooms;
    opens items;
    opens items.commonItems;
    opens items.furniture;
    opens items.keyItems;
}
