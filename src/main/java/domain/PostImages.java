package domain;

import java.util.List;
import java.util.Random;

public class PostImages {
    public static final Random random = new Random();

    private List<PostImage> postImages;

    public PostImages(List<PostImage> postImages) {
        this.postImages = postImages;
    }

    public List<PostImage> getPostImages() {
        return postImages;
    }

    public String getRandomImageUrl() {
        int randomIndex = random.nextInt(postImages.size());
        return postImages.get(randomIndex).getUrl();
    }
}
