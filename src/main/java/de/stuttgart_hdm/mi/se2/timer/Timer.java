package de.stuttgart_hdm.mi.se2.timer;

import de.stuttgart_hdm.mi.se2.gui.Resource;
import de.stuttgart_hdm.mi.se2.gui.Utils;
import de.stuttgart_hdm.mi.se2.gui.view.GameView;
import de.stuttgart_hdm.mi.se2.items.keyItems.Watch;
import de.stuttgart_hdm.mi.se2.rooms.Room;

import javafx.application.Platform;
import javafx.scene.Parent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Timer implements Runnable{
    private static final Logger log = LogManager.getLogger(Timer.class);

    @Override
    public void run() {
        int time = 600;
        for (int i = time; i >= 0; i--) {
            Room.getKeyItemList().stream().filter(Watch.class::isInstance).toList().get(0).setDesc(String.format("I feel a sudden uneasiness looking at the watch.\nIt's a countdown.\nThe number on the watch says %d:%d.", (i/60)%60, i%60));
            log.info(String.format("Player has %d:%d minutes left.", (i/60)%60, i%60 ));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                log.warn("Thread was interrupted and did not sleep." + e.getMessage());
                Platform.runLater(() -> {
                    Parent root = Utils.loadFxml(Resource.MENU_SCREEN);
                    GameView.getPrimaryStage().getScene().setRoot(root);
                    root.requestFocus();
                });
                return;
            }
            if(i == 0){
                Platform.runLater(() -> {
                    log.info("Player lost");
                    Parent root = Utils.loadFxml(Resource.LOSING_SCREEN);
                    GameView.getPrimaryStage().getScene().setRoot(root);
                    root.requestFocus();
                });
            }
        }
    }
}
