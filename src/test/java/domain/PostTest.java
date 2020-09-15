package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PostTest {

    @Test
    @DisplayName("특정 위치를 선택해 게시글을 생성")
    void init() {
        Coordinate coordinate = new Coordinate(1.123, 1.123);
        Address address = new Address("서울시 삼평동", "서울시", null, "구로구");
        Post post = Post.init(coordinate, address);
        assertThat(post.toString()).contains("서울시 삼평동", "서울시", "구로구", "1.123");
    }


}