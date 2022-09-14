package com.chalkfung.urlshortener.service;

import com.chalkfung.urlshortener.model.Link;

import java.util.List;
import java.util.Optional;

public interface LinkService {
    public Link saveLink(Link link);
    public List<Link> getAllLinks();
    public Optional<Link> getLinkById(int id);
    public Optional<Link> getLinkByOriginalLink(String originalLink);
    public Optional<Link> getLinkByShortLink(String shortLink);
}
