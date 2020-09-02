package domain;

import java.util.Objects;

public class PostImage {
    private final String url;

    public PostImage(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostImage postImage = (PostImage) o;
        return url.equals(postImage.url);
    }

    @Override public int hashCode() {
        return Objects.hash(url);
    }
}
