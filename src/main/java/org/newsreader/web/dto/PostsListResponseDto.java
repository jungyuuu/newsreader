package org.newsreader.web.dto;

import lombok.Getter;
import org.newsreader.domain.posts.Posts;

@Getter
public class PostsListResponseDto {
    private Long id;
    private String title;
    private String content;
    private String category;
    public PostsListResponseDto(Posts entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.category = entity.getCategory();
    }
}
