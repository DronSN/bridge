package ru.skvrez.bridge_example.player;

import ru.skvrez.bridge_example.shared.Song;

import java.util.List;

public interface Player {
    String getSongAudioStream(Song song);
    List<Song> getAllSongs();
}
