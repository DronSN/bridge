package ru.skvrez.bridge_example.shared;

public class PopSong implements Song {

    private String title;
    private String length;
    private String stream;

    public PopSong(String title, String length, String stream) {
        this.title = title;
        this.length = length;
        this.stream = stream;
    }

    @Override
    public String getLength() {
        return length;
    }

    @Override
    public String getAudioStream() {
        return stream;
    }

    @Override
    public String getTitle() {
        return title;
    }
}
