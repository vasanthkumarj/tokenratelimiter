package com.learningseries.concurrency.tokenratelimiter.components;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TokenBucket {

    private static final int MAX_TOKENS = 5;
    private int tokens;

    public TokenBucket() {
        this.tokens = MAX_TOKENS;  // Initialize with maximum tokens
    }

    // This method will be triggered every second to refill the tokens
    @Scheduled(fixedRate = 60000)  // Refill every second (1000ms)
    public void refillTokens() {
        if (tokens < MAX_TOKENS) {
            tokens++;
        }
    }

    // Method to check if there are tokens available
    public boolean hasTokens() {
        return tokens > 0;
    }

    // Consume a token
    public void consumeToken() {
        if (hasTokens()) {
            tokens--;
        }
    }

    public int getTokens() {
        return tokens;
    }
}
