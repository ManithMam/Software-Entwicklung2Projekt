package de.stuttgart_hdm.mi.se2.gui;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Audio {

    private static final Logger log = LogManager.getLogger(Audio.class);

    private static MediaPlayer mediaPlayer;


    private Audio() {
        throw new IllegalStateException("Utility class");
    }


    public static void playAudio(Resource resource){
        try {

            mediaPlayer = new MediaPlayer(new Media(Audio.class.getClassLoader().getResource(resource.getUrl()).toExternalForm()));
            mediaPlayer.seek(mediaPlayer.getStartTime());
            mediaPlayer.play();

        } catch (NullPointerException e) {

            log.error(e);
        }
    }


    public static void setVolume(){

    }
}
