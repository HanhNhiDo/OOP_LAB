package hust.soict.hedspi.aims.media;

import java.util.Objects;

public class Track implements Playable {
    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() { return title; }
    public int getLength() { return length; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Track)) return false;
        Track track = (Track) o;
        return length == track.length && title.equalsIgnoreCase(track.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title.toLowerCase(), length);
    }

    @Override
    public void play() {
        if (length > 0) {
            System.out.println("Playing Track: " + title + " - Length: " + length);
        } else {
            System.out.println("Track cannot be played. Length <= 0");
        }
    }

    @Override
    public String toString() {
        return "Track: " + title + " - Length: " + length;
    }
}