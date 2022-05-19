package mainpackage;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import mainpackage.gui.Resource;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

//TODO documentation
public class Utilities {

    //TODO Exception loggen
    //TODO Fehler screen als Dialog?
    public static Parent loadFxml(Resource resource) {
        final URL fxmlUrl = Utilities.class.getResource(resource.getUrl());

        try {
            return FXMLLoader.load(Objects.requireNonNull(fxmlUrl));
        } catch (IOException e) {
            e.printStackTrace();

            VBox fail = new VBox();
            Label label = new Label("Failed to load " + resource.getName());

            label.setTextFill(Color.web("#FF9494"));
            fail.getChildren().add(label);
            fail.setAlignment(Pos.CENTER);

            return fail;
        }
    }

    //TODO method for positioning window on new loaded stage
    public static void positionWindow() {

    }
}
