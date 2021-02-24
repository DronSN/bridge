package ru.skvrez.bridge_example;

import ru.skvrez.bridge_example.player.AndroidPlayer;
import ru.skvrez.bridge_example.player.LinuxPlayer;
import ru.skvrez.bridge_example.player.Player;
import ru.skvrez.bridge_example.widget.AndroidWidget;
import ru.skvrez.bridge_example.widget.LinuxWidget;
import ru.skvrez.bridge_example.widget.PlayerControl;
import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class App {

    private static Logger log = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        logConfiguration();
        Player player = new LinuxPlayer();
        PlayerControl playerControl = new LinuxWidget(player);
        playerControl.play();
        playSongsForward(playerControl, 4);
        playSongsBackward(playerControl, 2);

        player = new AndroidPlayer();
        playerControl = new AndroidWidget(player);
        playerControl.play();
        playSongsForward(playerControl, 2);
    }

    private static void logConfiguration() {
        try {
            LogManager.getLogManager().readConfiguration(
                    App.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e) {
            System.err.println("Could not setup logger configuration: " + e.toString());
        }
    }

    private static void playSongsForward(PlayerControl playerControl, int stepNumber) {
        log.info("PLAY FORWARD");
        for (int i = 0; i < stepNumber; i++) {
            playerControl.nextTrack();
        }
    }

    private static void playSongsBackward(PlayerControl playerControl, int stepNumber) {
        log.info("PLAY BACKWARD");
        for (int i = 0; i < stepNumber; i++) {
            playerControl.previousTrack();
        }
    }
}
