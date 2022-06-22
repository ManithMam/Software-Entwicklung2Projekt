module SE2StartupProject {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires org.apache.logging.log4j.core;
    requires org.apache.logging.log4j;

    opens de.stuttgart_hdm.mi.se2;
    opens de.stuttgart_hdm.mi.se2.gui;
    opens de.stuttgart_hdm.mi.se2.rooms;
    opens de.stuttgart_hdm.mi.se2.items;
    opens de.stuttgart_hdm.mi.se2.items.commonItems;
    opens de.stuttgart_hdm.mi.se2.items.furniture;
    opens de.stuttgart_hdm.mi.se2.items.keyItems;
}
