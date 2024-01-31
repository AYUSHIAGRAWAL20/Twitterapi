package com.example.twitter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

@Configuration
public class TwitterConfig {

    @Bean
    public Twitter twitter() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("YOUR_CONSUMER_KEY")
                .setOAuthConsumerSecret("YOUR_CONSUMER_SECRET")
                .setOAuthAccessToken("YOUR_ACCESS_TOKEN")
                .setOAuthAccessTokenSecret("YOUR_ACCESS_TOKEN_SECRET");

        TwitterFactory tf = new TwitterFactory(cb.build());
        return tf.getInstance();
    }
}

