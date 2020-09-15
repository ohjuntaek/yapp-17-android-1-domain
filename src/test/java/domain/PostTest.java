package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PostTest {
    public static final double LAT = 1.123;
    public static final double LNG = 1.123;
    public static final String ADDRESS = "서울시 삼평동";
    public static final String ADDR_CITY = "서울시";
    public static final String ADDR_DO = null;
    public static final String ADDR_GU = "구로구";

    private Coordinate coordinate;
    private Address address;

    private Post post;

    @BeforeEach
    void setUp() {
        coordinate = new Coordinate(LAT, LNG);
        address = new Address(ADDRESS, ADDR_CITY, ADDR_DO, ADDR_GU);
        post = Post.init(coordinate, address);
    }

    @Test
    @DisplayName("특정 위치를 선택해 게시글을 생성")
    void init() {

        assertThat(post.toString()).contains("서울시 삼평동", "서울시", "구로구", "1.123");
    }

    @Test
    @DisplayName("한 게시글에 여러 개의 사진을 달 수 있다.")
    void saveImageInPostTest() {
        Post post = Post.init(coordinate, address);
        String url = "url-example";
        String url2 = "url-example2";
        PostImage postImage = new PostImage(url);
        PostImage postImage2 = new PostImage(url2);
        post.saveImages(postImage, postImage2);

        PostImages expectPostImages = new PostImages(List.of(postImage, postImage2));
        assertThat(post.postImages).isEqualTo(expectPostImages);
    }


}