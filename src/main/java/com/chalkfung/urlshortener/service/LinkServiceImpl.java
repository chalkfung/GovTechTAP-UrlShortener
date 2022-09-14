package com.chalkfung.urlshortener.service;

import com.chalkfung.urlshortener.model.Link;
import com.chalkfung.urlshortener.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LinkServiceImpl implements LinkService{

    @Autowired
    private LinkRepository linkRepository;

    @Override
    public Link saveLink(Link link) {
        return linkRepository.save(link);
    }

    @Override
    public List<Link> getAllLinks()
    {
        return linkRepository.findAll();
    }

    @Override
    public Optional<Link> getLinkById(int id) { return linkRepository.findById(id); }

    @Override
    public Optional<Link> getLinkByOriginalLink(String originalLink)
    {
        return Optional.ofNullable(getAllLinks().parallelStream()
            .filter(link -> link.getOriginalLink().equals(originalLink))
            .findFirst()
            .orElse(null));
    }
    @Override
    public Optional<Link> getLinkByShortLink(String shortLink)
    {
        return Optional.ofNullable(getAllLinks().parallelStream()
                .filter(link -> link.getShortLink().equals(shortLink))
                .findFirst()
                .orElse(null));
    }
}
