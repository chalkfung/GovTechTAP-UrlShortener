package com.chalkfung.urlshortener.controller;

import com.chalkfung.urlshortener.model.Link;
import com.chalkfung.urlshortener.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
public class LinkController {

    @Autowired
    private LinkService linkService;

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestParam String link)
    {
        try
        {
            Optional<Link> result = linkService.getLinkByOriginalLink(link);
            if(result.isPresent()) {
                return new ResponseEntity<String>(result.get().getShortLink(), HttpStatus.OK);
            }else{
                Link newLink = new Link();
                newLink.setOriginalLink(link);
                Link saved = linkService.saveLink(newLink);
                saved.setShortLink(encode(saved.getId()));
                saved = linkService.saveLink(saved);
                return new ResponseEntity<String>(saved.getShortLink(), HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<String>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<String> getLinkByShortLink(@PathVariable String id)
    {
        try
        {
            Optional<Link> result = linkService.getLinkByShortLink(id);
            if(result.isPresent())
            {
                return new ResponseEntity<String>(result.get().getOriginalLink(), HttpStatus.OK);
            }
            else
            {
                return new ResponseEntity<String>("Not found", HttpStatus.NOT_FOUND);
            }

        }
        catch (Exception e) {
            return new ResponseEntity<String>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private String encode(int base10)
    {
        final char[] ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        final int ENCODE_LENGTH = ALPHABET.length;
        final List<Character> list = new ArrayList<>();

        do {
            list.add(ALPHABET[base10 % ENCODE_LENGTH]);
                base10 /= ENCODE_LENGTH;
        } while (base10 > 0);

        Collections.reverse(list);
        return list.toString().substring(1, list.toString().length() - 1);
    }
}

