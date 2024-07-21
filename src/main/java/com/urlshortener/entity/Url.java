package com.urlshortener.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.web.bind.annotation.Mapping;

import java.time.LocalDateTime;

@Document(collection = "url")
public class Url {
    @Id
    private String id;

    @Field("original_url")
    private String originalUrl;

    @Field("short_url_hash")
    private String shortUrlHash;

    @Field("user_id")
    private String userId;

    @CreatedDate
    @Field("created_at")
    private LocalDateTime createdAt;

    public Url() {

    }

    public Url(String originalUrl, String shortUrlHash) {
        this.originalUrl = originalUrl;
        this.shortUrlHash = shortUrlHash;
    }

    public String getId() {
        return id;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public String getShortUrlHash() {
        return shortUrlHash;
    }

    public void setShortUrlHash(String shortUrlHash) {
        this.shortUrlHash = shortUrlHash;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
