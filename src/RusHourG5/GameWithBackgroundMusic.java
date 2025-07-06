package RusHourG5;


import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;/**
 * The GameWithBackgroundMusic class is used to control the background music of a game.
 */

public class GameWithBackgroundMusic {/**
 * The backgroundMusic variable stores the Clip object of the game's background music.
 */
    public static Clip backgroundMusic;/**
 * The isMuted variable stores the muted status of the game's background music.
 */

    boolean isMuted;/**
 * The constructor creates and opens a Clip object, loading the game's background music.
 */
    public GameWithBackgroundMusic() {
        // ´´½¨ Clip ¶ÔÏó
        try {
            backgroundMusic = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("src/Music/Russell-Brower-Salty-Sailor.wav"));
            backgroundMusic.open(inputStream);
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }/**
 * The playBackgroundMusic method is used to play the game's background music.
 */

    public static void playBackgroundMusic() {
        if (backgroundMusic != null) {
            backgroundMusic.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }
    /**
     * The toggleMute method is used to toggle the muted status of the game's background music.
     */
    public void toggleMute() {
        if (backgroundMusic != null) {
            if (isMuted) {
                backgroundMusic.start(); // »Ö¸´²¥·ÅÒôÀÖ
                isMuted = false; // ¸üÐÂ½ûÒô×´Ì¬
            } else {
                backgroundMusic.stop(); // ÔÝÍ£²¥·ÅÒôÀÖ
                isMuted = true; // ¸üÐÂ½ûÒô×´Ì¬
            }
        }
    }/**
     * The stopBackgroundMusic method is used to stop the game's background music.
     */


    public static void stopBackgroundMusic() {
        if (backgroundMusic != null && backgroundMusic.isRunning()) {
            backgroundMusic.stop();
        }
    }

    public static void main(String[] args) {
        GameWithBackgroundMusic game = new GameWithBackgroundMusic();
        playBackgroundMusic();
        stopBackgroundMusic();
    }
}
