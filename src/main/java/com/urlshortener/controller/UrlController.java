package com.urlshortener.controller;

import com.urlshortener.controller.dto.ShortenUrlRequest;
import com.urlshortener.entity.Url;
import com.urlshortener.repository.UrlRepository;
import com.urlshortener.services.UrlServices;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;


@RestController
public class UrlController {

    private final UrlRepository urlRepository;
    private final UrlServices urlServices;

    public UrlController(UrlRepository urlRepository, UrlServices urlServices) {
        this.urlRepository = urlRepository;
        this.urlServices = urlServices;
    }

    @PostMapping("/shortenUrl")
    public ResponseEntity<Url> shortenUrl(@RequestBody ShortenUrlRequest shortenRequest){

        String originalUrl = shortenRequest.url();

        if (!shortenRequest.url().startsWith("http://") && !shortenRequest.url().startsWith("https://")) {
            originalUrl = "https://" + shortenRequest.url();
        }

        return ResponseEntity.ok(urlServices.shortenUrl(originalUrl));
    }

    @GetMapping("{shortUrl}")
    public ResponseEntity<Void> redirectUrl (@PathVariable String shortUrl, HttpServletResponse httpServletResponse) {

        var fullUrl = urlServices.redirectUrl(shortUrl);

        if(fullUrl.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(URI.create(fullUrl.get().getOriginalUrl()));

        return ResponseEntity.status(HttpStatus.FOUND).headers(httpHeaders).build();
    }
}
