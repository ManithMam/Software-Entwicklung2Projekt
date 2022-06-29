package de.stuttgart_hdm.mi.se2.gui;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Audio {
    private static final MediaPlayer mediaPlayer = new MediaPlayer(new Media(Audio.class.getClassLoader().getResource(Resource.BTN_AUDIO.getUrl()).toExternalForm()));

    public static void playAudio(){
        mediaPlayer.seek(mediaPlayer.getStartTime());
        mediaPlayer.play();
    }

    public static void setVolume(){

    }
}
