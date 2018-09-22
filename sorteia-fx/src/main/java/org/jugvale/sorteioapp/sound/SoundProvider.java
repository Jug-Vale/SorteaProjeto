package org.jugvale.sorteioapp.sound;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javafx.scene.media.AudioClip;

public class SoundProvider {

    final static String BASE_URL = "/audio/";

    final static Random RANDOM = new Random();

    final static String[] SONGS = { "ssantos.mp3", 
                    "ohyeah.mp3", 
                    "TheCavalryCharge.mp3", 
                    "VoicesofSpring.mp3",
                    "amclassical_beethoven_fur_elise.mp3"
    };

    static List<AudioClip> clips;

    static {
        clips = Arrays.stream(SONGS)
            .map(BASE_URL::concat)    
            .map(SoundProvider.class::getResource)
            .map(Object::toString)
            .map(AudioClip::new)
            .collect(Collectors.toList());
    };

    private SoundProvider() {
    }

    public static AudioClip get() {
        return clips.get(RANDOM.nextInt(clips.size()));
    }

}
