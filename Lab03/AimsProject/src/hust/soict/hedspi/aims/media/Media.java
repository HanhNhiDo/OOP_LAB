package hust.soict.hedspi.aims.media;

import java.util.Comparator;
import java.util.Objects;

public abstract class Media {
    private static int currentId = 0;
    private int id;
    private String title;
    private String category;
    private float cost;

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    public Media(String title, String category, float cost) {
        this.id = ++currentId;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public float getCost() { return cost; }

    @Override
    public String toString() {
        return "ID: " + id + " - " + title + " - " + category + " : " + cost + "$";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Media)) return false;
        Media media = (Media) o;
        return title.equalsIgnoreCase(media.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title.toLowerCase());
    }

    public static class MediaComparatorByCostTitle implements Comparator<Media> {
        @Override
        public int compare(Media m1, Media m2) {
            int costCompare = Float.compare(m2.getCost(), m1.getCost()); // cost giảm dần
            if (costCompare != 0) return costCompare;
            return m1.getTitle().compareToIgnoreCase(m2.getTitle()); // title tăng dần
        }
    }

    public static class MediaComparatorByTitleCost implements Comparator<Media> {
        @Override
        public int compare(Media m1, Media m2) {
            int titleCompare = m1.getTitle().compareToIgnoreCase(m2.getTitle()); // title tăng dần
            if (titleCompare != 0) return titleCompare;
            return Float.compare(m2.getCost(), m1.getCost()); // cost giảm dần
        }
    }
} 