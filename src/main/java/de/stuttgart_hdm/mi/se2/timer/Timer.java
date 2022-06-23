package de.stuttgart_hdm.mi.se2.timer;

import de.stuttgart_hdm.mi.se2.gui.Resource;
import de.stuttgart_hdm.mi.se2.gui.View;
import javafx.application.Platform;
import javafx.scene.Parent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Timer implements Runnable{
    private static final Logger log = LogManager.getLogger(Timer.class);

    @Override
    public void run() {
        int time = 10;
        for(int i = time; i >= 0; i--){
            log.info("Player has " + i + " seconds left.");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                log.warn("Thread was interrupted and did not sleep." + e.getMessage());
                throw new RuntimeException(e);
            }
            if(i == 0){
                Platform.runLater(() -> {
                    log.info("Player lost the game");
                    Parent root = View.loadFxml(Resource.LOSING_SCREEN);
                    View.getPrimaryStage().getScene().setRoot(root);
                    root.requestFocus();
                });
            }
        }
    }
}
