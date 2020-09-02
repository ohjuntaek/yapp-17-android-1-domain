package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static domain.PostTest.*;
import static org.assertj.core.api.Assertions.assertThat;

class PostsTest {

    @Test
    @DisplayName("글 정보 조회 시 여러 개의 사진 url 중 랜덤으로 하나의 url이 출력된다.")
    void getRandomImageUrlTest() {
        Post postWithImages = Post.createWithImages(LAT, LNG, ADDRESS, CONTENT, CITY, CREATE_DATE,
                Arrays.asList(new PostImage(POST_IMAGE_URL + 1), new PostImage(POST_IMAGE_URL + 2)));

        String randomImageUrl = postWithImages.getRandomImagesUrl();

        assertThat(randomImageUrl).isIn(postWithImages.getPostImages().getPostImages());
    }

}
