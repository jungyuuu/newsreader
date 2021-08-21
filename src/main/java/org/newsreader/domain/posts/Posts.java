package org.newsreader.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String category;
    @Column(length = 500, nullable = false)
    private String title;

    @Column(nullable = false, length = 500, columnDefinition = "TEXT")
    private String content;

    @Builder
    public Posts(String title, String category, String content){
        this.title = title;
        this.content = content;
        this.category = category;
    }
}
