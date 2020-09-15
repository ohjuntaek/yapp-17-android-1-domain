package domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class Post {
    private final Coordinate coordinate;
    private final Address address;
    private final LocalDate createDate;

    protected String content;
    protected PostImages postImages;

    public Post(Coordinate coordinate, Address address, LocalDate createDate) {
        this.coordinate = coordinate;
        this.address = address;
        this.createDate = createDate;
    }

    public static Post init(Coordinate coordinate, Address address) {
        return new Post(coordinate, address, LocalDate.now());
    }

    public void saveImages(PostImage... postImages) {
        this.postImages = new PostImages(new ArrayList<>(Arrays.asList(postImages)));
    }

    @Override public String toString() {
        return "Post{" +
                "coordinate=" + coordinate +
                ", address=" + address +
                ", postImages=" + postImages +
                ", content='" + content + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
