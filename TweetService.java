package com.example.twitter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.User;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TweetService {

    private final Twitter twitter;

    @Autowired
    public TweetService(Twitter twitter) {
        this.twitter = twitter;
    }

    public List<String> searchTweetUser(String username) throws TwitterException {
        Query query = new Query("from:" + username);
        QueryResult result = twitter.search(query);
        return result.getTweets().stream().map(Status::getText).collect(Collectors.toList());
    }

    public List<String> getTweetsOfUser(String username) throws TwitterException {
        User user = twitter.showUser(username);
        List<Status> tweets = twitter.getUserTimeline(user.getId());
        return tweets.stream().map(Status::getText).collect(Collectors.toList());
    }
}
