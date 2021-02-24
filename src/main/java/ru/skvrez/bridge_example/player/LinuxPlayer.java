package ru.skvrez.bridge_example.player;

import ru.skvrez.bridge_example.shared.PopSong;
import ru.skvrez.bridge_example.shared.Song;

import java.util.List;

public class LinuxPlayer implements Player {

    private List<Song> songList =
            List.of(new PopSong("Gloria Gaynor, 'I Will Survive'", "05:13", "la-la-la"),
                    new PopSong("Joan Jett and the Blackhearts, 'I Love Rock 'N Roll'", "03:34", "na-na-na"),
                    new PopSong("Coldplay, 'Clocks'", "04:18", "ra-ta-ta"));

    @Override
    public String getSongAudioStream(Song song) {
        return String.format("Linux player: %s", song.getAudioStream());
    }

    @Override
    public List<Song> getAllSongs() {
        return songList;
    }
}
