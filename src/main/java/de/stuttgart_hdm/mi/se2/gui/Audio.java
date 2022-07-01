package de.stuttgart_hdm.mi.se2.gui;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Responsible for audio
 */
public class Audio {

    private static final Logger log = LogManager.getLogger(Audio.class);

    /**
     * so no one can instantiate objects of utility class Audio
     */
    private Audio() {
        throw new IllegalStateException("Utility class");
    }


    /**
     * loads audio file and plays it
     * @param resource needed resource
     */
    public static void playAudio(Resource resource){
        try {

            MediaPlayer mediaPlayer = new MediaPlayer(new Media(Audio.class.getClassLoader().getResource(resource.getUrl()).toExternalForm()));

            //needed to play audio repeatedly
            mediaPlayer.seek(mediaPlayer.getStartTime());
            mediaPlayer.play();

        } catch (NullPointerException e) {

            log.error(e);
        }
    }
}
