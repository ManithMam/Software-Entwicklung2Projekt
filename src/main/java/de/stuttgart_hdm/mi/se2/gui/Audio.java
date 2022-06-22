package de.stuttgart_hdm.mi.se2.gui;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class Audio {
    private static final MediaPlayer mediaPlayer = new MediaPlayer(new Media(new File(Resource.BTN_AUDIO.getUrl()).toURI().toString()));

    public static void playAudio(){
        mediaPlayer.seek(mediaPlayer.getStartTime());
        mediaPlayer.play();
    }

    public static void setVolume(){

    }
}
