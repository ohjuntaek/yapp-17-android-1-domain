package domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class Post {
    private final Coordinate coordinate;
    private final Address address;
    private final LocalDate createDate;

    private String content;
    private PostImages postImages;
    private Color color;

    public Post(Coordinate coordinate, Address address, LocalDate createDate) {
        this.coordinate = coordinate;
        this.address = address;
        this.createDate = createDate;
        this.color = Color.BLACK;
    }

    public static Post init(Coordinate coordinate, Address address) {
        return new Post(coordinate, address, LocalDate.now());
    }

    @Override public String toString() {
        return "Post{" +
                "coordinate=" + coordinate +
                ", address=" + address +
                ", createDate=" + createDate +
                ", content='" + content + '\'' +
                ", postImages=" + postImages +
                ", color=" + color +
                '}';
    }

    public void saveImages(PostImage... postImages) {
        this.postImages = new PostImages(new ArrayList<>(Arrays.asList(postImages)));
    }

    protected PostImages getPostImages() {
        return postImages;
    }

    public void changeColor(Color updateColor) {
        this.color = updateColor;
    }

    protected Color getColor() {
        return color;
    }
}
