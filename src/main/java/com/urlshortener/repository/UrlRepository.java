package com.urlshortener.repository;

import com.urlshortener.entity.Url;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UrlRepository extends MongoRepository<Url, String> {

    Optional<Url> findOneByShortUrlHash(String shortUrlHash);
}
