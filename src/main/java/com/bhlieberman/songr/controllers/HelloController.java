package com.bhlieberman.songr.controllers;

import com.bhlieberman.songr.albums.Album;
import com.bhlieberman.songr.albums.AlbumRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class HelloController {

    @Autowired
    private AlbumRepository albumRepository;
//    @GetMapping("/")
//    String splash() {
//        return "splash";
//    }

    Random ids = new Random();
    @PostMapping("/")
    RedirectView addAlbum(@RequestParam @Nullable String artist, @RequestParam @Nullable String title) {
        Album album = new Album();
        album.setId(ids.nextLong());
        album.setTitle(title);
        album.setArtist(artist);
        albumRepository.save(album);
        return new RedirectView("/");
    }

    @GetMapping("/hello")
    @ResponseBody
    String sayHello() {
        return "hello";
    }

    @GetMapping("/capitalize/{word}")
    @ResponseBody
    String capitalize(@PathVariable String word) {
        return Arrays.stream(word.split("\s"))
                .map(String::toUpperCase)
                .collect(Collectors.joining(" "));
    }

    @GetMapping("/")
    String showAlbums(Model m) {
        List<Album> albums = albumRepository.findAll();
        m.addAttribute("albums", albums);
        return "albums";
    }
}
