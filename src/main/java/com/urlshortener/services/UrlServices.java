package com.urlshortener.services;

import com.urlshortener.entity.Url;
import com.urlshortener.repository.UrlRepository;
import com.urlshortener.util.HashGenerator;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Service
public class UrlServices {

    private final UrlRepository urlRepository;


    public UrlServices(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public Url shortenUrl(String originalUrl) {
        String hashUrlShortener = null;
        try {
            hashUrlShortener = HashGenerator.generator(originalUrl);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        Url url = new Url(originalUrl, hashUrlShortener);

        return urlRepository.save(url);

    }

    public Optional<Url> redirectUrl(String shortUrl) {
        return urlRepository.findOneByShortUrlHash(shortUrl);
    }

}
