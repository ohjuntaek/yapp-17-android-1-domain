package domain;

import java.time.LocalDate;

public class Post {
    private final Coordinate coordinate;
    private final Address address;
    private final PostImages postImages;
    private final String content;
    private final LocalDate createDate;

    public Post(Coordinate coordinate, Address address, PostImages postImages, String content, LocalDate createDate) {
        this.coordinate = coordinate;
        this.address = address;
        this.postImages = postImages;
        this.content = content;
        this.createDate = createDate;
    }

    public static Post init(Coordinate coordinate, Address address) {
        return new Post(coordinate, address, null, null, LocalDate.now());
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
