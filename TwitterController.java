package com.example.twitter.controller;

import com.example.twitter.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import twitter4j.TwitterException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TwitterController {

    private final TweetService tweetService;

    @Autowired
    public TwitterController(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    @GetMapping("/search-tweet-user/{username}")
    public List<String> searchTweetUser(@PathVariable String username) throws TwitterException {
        return tweetService.searchTweetUser(username);
    }

    @GetMapping("/get-tweets/{username}")
    public List<String> getTweetsOfUser(@PathVariable String username) throws TwitterException {
        return tweetService.getTweetsOfUser(username);
    }
}
