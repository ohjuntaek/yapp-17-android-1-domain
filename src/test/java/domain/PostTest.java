package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PostTest {

    static final double LAT = 27.0000001;
    static final double LNG = 152.000001;
    static final String ADDRESS = "서울시 강남구";
    static final String CONTENT = "글내용";
    static final String CITY = "서울특별시";
    static final LocalDate CREATE_DATE = LocalDate.of(1993, 8, 25);

    static final String POST_IMAGE_URL = "https://example.com/";

    @Test
    @DisplayName("게시글 생성 및 조회 테스트")
    void createTest() {
        Post post = new Post(new Point(LAT, LNG),
                ADDRESS,
                CONTENT,
                CITY,
                CREATE_DATE);

        assertThat(post.toString()).contains(String.valueOf(LAT), String.valueOf(LNG), ADDRESS, CONTENT, CITY, CREATE_DATE.toString());
    }

    @Test
    @DisplayName("게시글에 여러 개의 사진을 달 수 있다.")
    void createWithPostImageTest() {
        Post post = Post.create(LAT, LNG, ADDRESS, CONTENT, CITY, CREATE_DATE);

        PostImage postImage = new PostImage(POST_IMAGE_URL + 1);
        PostImage postImage1 = new PostImage(POST_IMAGE_URL + 2);

        List<PostImage> postImages = Arrays.asList(postImage, postImage1);
        List<PostImage> saveImages = post.saveImages(postImages).getPostImages();

        assertEquals(postImages, saveImages);
    }
}
