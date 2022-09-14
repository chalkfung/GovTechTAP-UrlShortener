package com.chalkfung.urlshortener.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Link {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String originalLink;
    private String shortLink;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getOriginalLink() {
        return originalLink;
    }

    public void setOriginalLink(String originalLink) {
        this.originalLink = originalLink;
    }
    public String getShortLink() {
        return shortLink;
    }

    public void setShortLink(String shortLink) {
        this.shortLink = shortLink;
    }
}
