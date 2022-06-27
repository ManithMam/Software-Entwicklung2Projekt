package de.stuttgart_hdm.mi.se2.timer;

import de.stuttgart_hdm.mi.se2.gui.Resource;
import de.stuttgart_hdm.mi.se2.gui.Utils;
import de.stuttgart_hdm.mi.se2.gui.view.GameView;
import de.stuttgart_hdm.mi.se2.items.keyItems.Clock;
import de.stuttgart_hdm.mi.se2.rooms.Room;

import javafx.application.Platform;
import javafx.scene.Parent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Timer implements Runnable{
    private static final Logger log = LogManager.getLogger(Timer.class);

    @Override
    public void run() {
        int time = 10;
        for (int i = time; i >= 0; i--) {
            Room.getKeyItemList().stream().filter(Clock.class::isInstance).toList().get(0).setDesc("I feel a sudden uneasiness watching at the watch.\n The number on the watch says " + i + " .");
            log.info("Player has " + i + " seconds left.");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.warn("Thread was interrupted and did not sleep." + e.getMessage());
                Platform.runLater(() -> {
                    Parent root = Utils.loadFxml(Resource.ERROR_SCREEN);
                    GameView.getPrimaryStage().getScene().setRoot(root);
                    root.requestFocus();
                });
            }
            if(i == 0){
                Platform.runLater(() -> {
                    log.info("I suddenly feel dizzy and my legs are shaking. I feel like I am loosing consciousness....");
                    Parent root = Utils.loadFxml(Resource.LOSING_SCREEN);
                    GameView.getPrimaryStage().getScene().setRoot(root);
                    root.requestFocus();
                });
            }
        }
    }
}
