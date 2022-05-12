package mainpackage;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class Utilities {
    public static Parent loadFxml(String fxmlName, Class neededClass) {
        final URL fxmlFileUrl = neededClass.getClassLoader().getResource(fxmlName);
        try {
            return FXMLLoader.load(Objects.requireNonNull(fxmlFileUrl));
        }catch (IOException e){
            e.printStackTrace();

            VBox fail= new VBox();
            Label label = new Label("Failed to load " + fxmlName);

            label.setTextFill(Color.web("#FF9494"));
            fail.getChildren().add(label);
            fail.setAlignment(Pos.CENTER);

            return fail;
        }
    }
}
