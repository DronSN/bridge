package ru.skvrez.bridge_example.widget;

import ru.skvrez.bridge_example.player.Player;
import ru.skvrez.bridge_example.shared.Song;
import java.util.List;
import java.util.logging.Logger;

public class LinuxWidget implements PlayerControl {

    private static final Logger log = Logger.getLogger(LinuxWidget.class.getName());
    private static final String DELIMITER = "_____________________________________";
    private final Player player;
    private final List<Song> playList;
    private int songIndex;

    public LinuxWidget(Player player) {
        this.player = player;
        this.playList = player.getAllSongs();
        this.songIndex = 0;
    }

    @Override
    public void play() {
        log.info("LINUX widget");
        log.info(() -> "Название композиции: " + playList.get(songIndex).getTitle());
        log.info(() -> "Продолжительность: " + playList.get(songIndex).getLength());
        log.info(() -> "Сейчас звучит: " + player.getSongAudioStream(playList.get(songIndex)));
    }

    @Override
    public void stop() {
        log.info(() -> "Проигрование композиции остановлено: %s" + playList.get(songIndex).getTitle());
        log.info(DELIMITER);
    }

    @Override
    public void nextTrack() {
        stop();
        songIndex = getNextIndex(songIndex);
        play();
    }

    @Override
    public void previousTrack() {
        stop();
        songIndex = getPreviousIndex(songIndex);
        play();
    }

    private int getNextIndex(int currentIndex) {
        int nextIndex = ++currentIndex;
        return nextIndex % playList.size();
    }

    private int getPreviousIndex(int currentIndex) {
        int nextIndex = --currentIndex;
        if (nextIndex < 0) {
            nextIndex = playList.size() - 1;
        }
        return nextIndex;
    }
}
