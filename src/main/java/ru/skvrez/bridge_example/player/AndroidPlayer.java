package ru.skvrez.bridge_example.player;

import ru.skvrez.bridge_example.shared.PopSong;
import ru.skvrez.bridge_example.shared.Song;
import java.util.List;

public class AndroidPlayer implements Player {

    private List<Song> songList =
            List.of(new PopSong("David Bowie, 'Young Americans'", "05:13", "la-la-la"),
                    new PopSong("Justin Timberlake, 'Cry Me a River'", "03:34", "na-na-na"),
                    new PopSong("Missy Elliott, 'Get Ur Freak On'", "04:18", "ra-ta-ta"));

    @Override
    public String getSongAudioStream(Song song) {
        return String.format("Android player: %s", song.getAudioStream());
    }

    @Override
    public List<Song> getAllSongs() {
        return songList;
    }
}
