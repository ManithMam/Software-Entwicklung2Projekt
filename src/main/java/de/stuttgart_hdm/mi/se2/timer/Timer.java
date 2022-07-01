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

public class Timer implements Runnable {

    private static final Logger log = LogManager.getLogger(Timer.class);

    //stops the thread
    private boolean stop = true;

    //If the timer has to pause, the thread will be stopped and timeLeft saves the remaining time.
    //After restart of the thread, the timer will start with the remaining time.
    //Not ideal, but it works.
    private int timeLeft = 600;

    public void stop() {
        this.stop = false;
    }

    @Override
    public void run() {
        int time = timeLeft;

        for (int i = time; i >= 0; i--) {

            //while loop and make stop volatile didn't work
            if (stop) {

                timeLeft = i;

                String timeString = "";
                int min = (i / 60) % 60;
                int sec = i % 60;

                if (sec < 10) {
                    timeString = String.format("%d:0%d", min, sec);
                } else {
                    timeString = String.format("%d:%d", min, sec);
                }

                Room.getKeyItemList().stream().filter(Watch.class::isInstance).toList().get(0).setDesc(String.format("I feel a sudden uneasiness looking at the watch.%nIt's a countdown.%nThe number on the watch says %s.", timeString));
                log.info(String.format("Player has %s minutes left.", timeString));

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

                if (i == 0) {

                    //without this timer will start again after it hits 0
                    this.stop = false;

                    //shows Losing screen
                    Platform.runLater(() -> {
                        log.info("Player lost");
                        Parent root = Utils.loadFxml(Resource.LOSING_SCREEN);
                        GameView.getPrimaryStage().getScene().setRoot(root);
                        root.requestFocus();
                    });
                }

            } else {

                break;
            }
        }
    }

    public int getTimeLeft() {
        return this.timeLeft;
    }

    public void setTimeLeft(int time) {
        this.timeLeft = time;
    }
}
