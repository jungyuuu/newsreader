package org.newsreader.web;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
import lombok.RequiredArgsConstructor;
import org.newsreader.domain.posts.Posts;
import org.newsreader.domain.posts.PostsRepository;
import org.newsreader.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class IndexController {
    @Autowired
    PostsRepository postsRepository;
    private final PostService postService;
    @GetMapping("/")
    public String index (Model model) throws Exception{
        model.addAttribute("posts", postService.findAllDesc());
        return "index";
    }

    @GetMapping("/headline")
    public String headline(){
        postsRepository.deleteAll();

        String rssUrl = "https://www.yonhapnewstv.co.kr/category/news/headline/feed/";
        URL feedUrl = null;
        try {
            feedUrl = new URL(rssUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            SyndFeedInput input = new SyndFeedInput();
            SyndFeed feed = input.build(new XmlReader(feedUrl));

            List entries = feed.getEntries();
            for (int i = 0; i < entries.size(); i++) {
                SyndEntry entry = (SyndEntry) entries.get(i);
                System.out.println("--- Entry " + i);
                postsRepository.save(Posts.builder()
                        .category(String.valueOf(entry.getPublishedDate()))
                        .title(entry.getTitle())
                        .content(entry.getLink())

                        .build());
            }
        } catch (Exception e) {

        }
        return "/";
    }
    @GetMapping("/weather")
    public String weather(){
        postsRepository.deleteAll();

        String rssUrl = "https://www.yonhapnewstv.co.kr/category/news/weather/feed/";
        URL feedUrl = null;
        try {
            feedUrl = new URL(rssUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            SyndFeedInput input = new SyndFeedInput();
            SyndFeed feed = input.build(new XmlReader(feedUrl));

            List entries = feed.getEntries();
            for (int i = 0; i < entries.size(); i++) {
                SyndEntry entry = (SyndEntry) entries.get(i);
                System.out.println("--- Entry " + i);
                postsRepository.save(Posts.builder()
                        .category(String.valueOf(entry.getPublishedDate()))
                        .title(entry.getTitle())
                        .content(entry.getLink())
                        .build());
            }
        } catch (Exception e) {

        }
        return "/";
    }
    @GetMapping("/feed")
    public String feed(){
        postsRepository.deleteAll();

        String rssUrl = "https://www.yonhapnewstv.co.kr/browse/feed/";
        URL feedUrl = null;
        try {
            feedUrl = new URL(rssUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            SyndFeedInput input = new SyndFeedInput();
            SyndFeed feed = input.build(new XmlReader(feedUrl));

            List entries = feed.getEntries();
            for (int i = 0; i < entries.size(); i++) {
                SyndEntry entry = (SyndEntry) entries.get(i);
                System.out.println("--- Entry " + i);
                postsRepository.save(Posts.builder()
                        .category(String.valueOf(entry.getPublishedDate()))
                        .title(entry.getTitle())
                        .content(entry.getLink())
                        .build());
            }
        } catch (Exception e) {

        }
        return "/";
    }

    @GetMapping("/economy")
    public String economy(){
        postsRepository.deleteAll();

        String rssUrl = "https://www.yonhapnewstv.co.kr/category/news/economy/feed/";
        URL feedUrl = null;
        try {
            feedUrl = new URL(rssUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            SyndFeedInput input = new SyndFeedInput();
            SyndFeed feed = input.build(new XmlReader(feedUrl));

            List entries = feed.getEntries();
            for (int i = 0; i < entries.size(); i++) {
                SyndEntry entry = (SyndEntry) entries.get(i);
                System.out.println("--- Entry " + i);
                postsRepository.save(Posts.builder()
                        .category(String.valueOf(entry.getPublishedDate()))
                        .title(entry.getTitle())
                        .content(entry.getLink())
                        .build());
            }
        } catch (Exception e) {

        }
        return "/";
    }
}
