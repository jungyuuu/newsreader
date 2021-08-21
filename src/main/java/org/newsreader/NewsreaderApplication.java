package org.newsreader;

import org.newsreader.domain.posts.PostsRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NewsreaderApplication {
    PostsRepository postsRepository;
    public static void main(String[] args) {
        SpringApplication.run(NewsreaderApplication.class, args);
    }
}
