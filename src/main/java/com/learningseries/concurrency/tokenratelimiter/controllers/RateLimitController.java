package com.learningseries.concurrency.tokenratelimiter.controllers;

import com.learningseries.concurrency.tokenratelimiter.components.TokenBucket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLimitController {

    private final TokenBucket tokenBucket;

    @Autowired
    public RateLimitController(TokenBucket tokenBucket) {
        this.tokenBucket = tokenBucket;
    }

    // Endpoint to simulate token consumption
    @GetMapping("/consume-token")
    public String consumeToken() {
        if (tokenBucket.hasTokens()) {
            tokenBucket.consumeToken();
            return "Token consumed. Tokens remaining: " + tokenBucket.getTokens();
        } else {
            return "No tokens available!";
        }
    }

    // Endpoint to check the current number of tokens
    @GetMapping("/tokens")
    public String getTokenCount() {
        return "Current tokens: " + tokenBucket.getTokens();
    }
}
