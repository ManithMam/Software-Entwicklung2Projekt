package de.stuttgart_hdm.mi.se2.gui;

import de.stuttgart_hdm.mi.se2.Main;
import de.stuttgart_hdm.mi.se2.gui.view.GameView;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class Utils {

    private static final Logger log = LogManager.getLogger(Utils.class);

    //TODO logg Exception
    //TODO error screen as dialog?
    public static Parent loadFxml(Resource resource) {
        final URL fxmlUrl = GameView.class.getResource(resource.getUrl());

        try {
            return FXMLLoader.load(Objects.requireNonNull(fxmlUrl));
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
            log.error(String.format("File %s could not be found for: %s. Provided file path: %s.%nCheck if file exists or if file path is correct.%n%s", resource.getName() ,resource.getDesc(), resource.getUrl(), e));
            VBox fail = new VBox();
            Label label = new Label("Failed to load " + resource.getName() + " look in logs for details.");
            Button button = new Button();

            label.setTextFill(Color.web("#FF9494"));
            button.setText("OK");
            button.setOnAction(event -> GameView.getPrimaryStage().close());
            fail.getChildren().add(label);
            fail.getChildren().add(button);
            fail.setAlignment(Pos.CENTER);

            return fail;
        }
    }
}
