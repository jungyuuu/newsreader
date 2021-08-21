package org.newsreader.domain.posts;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest{
    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup() {
        postsRepository.deleteAll();
    }
    @Test
    public void rss저장() throws Exception{
        String rssUrl = "https://www.yonhapnewstv.co.kr/category/news/headline/feed/";
        URL feedUrl = new URL(rssUrl);
        try {
            SyndFeedInput input = new SyndFeedInput();
            SyndFeed feed = input.build(new XmlReader(feedUrl));

            List entries = feed.getEntries();
            for (int i = 0; i < entries.size(); i++) {
                SyndEntry entry = (SyndEntry) entries.get(i);
                System.out.println("--- Entry " + i);
                postsRepository.save(Posts.builder()
                        .title(entry.getTitle())
                        .content(entry.getLink())
                        .build());
            }
//            List<Posts> postsList = postsRepository.findAllDesc();
//            Posts posts = postsList.get(0);
        } catch (Exception e) {

        }
    }
}
