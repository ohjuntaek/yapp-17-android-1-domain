package domain;

import java.time.LocalDate;
import java.util.List;

public class Post {
    private final Point point;
    private final String address;
    private final String content;
    private final String city;
    private final LocalDate createDate;

    private PostImages postImages;

    Post(Point point, String address, String content, String city, LocalDate createDate) {
        this.point = point;
        this.address = address;
        this.content = content;
        this.city = city;
        this.createDate = createDate;
    }

    public static Post create(double lat, double lng, String address, String content, String city, LocalDate createDate) {
        return new Post(new Point(lat, lng),address, content, city, createDate);
    }

    public static Post createWithImages(double lat, double lng, String address, String content, String city,
                                        LocalDate createDate, List<PostImage> postImages) {
        Post post = new Post(new Point(lat, lng), address, content, city, createDate);
        post.saveImages(postImages);
        return post;
    }

    public PostImages saveImages(List<PostImage> postImages) {
        this.postImages = new PostImages(postImages);
        return this.postImages;
    }

    public PostImages getPostImages() {
        return postImages;
    }

    @Override public String toString() {
        return "domain.Post{" +
                "point=" + point +
                ", address='" + address + '\'' +
                ", content='" + content + '\'' +
                ", city='" + city + '\'' +
                ", createDate=" + createDate +
                '}';
    }

    public String getRandomImagesUrl() {
        return postImages.getRandomImageUrl();
    }
}
