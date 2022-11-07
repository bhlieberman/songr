package com.bhlieberman.songr.controllers;

import com.bhlieberman.songr.albums.Album;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.stream.Collectors;

@Controller
public class HelloController {
    @GetMapping("/")
    String splash() {
        return "splash";
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

    @GetMapping("/albums")
    @ResponseBody
    String showAlbums() throws MalformedURLException {
        Album illmatic = new Album("Illmatic", "Nas", 10, 2391,
                new URL("https://en.wikipedia.org/wiki/Illmatic#/media/File:IllmaticNas.jpg"));
        Album disintegration = new Album("Disintegration", "The Cure", 12, 4305, new URL("https://en.wikipedia.org/wiki/Disintegration_(The_Cure_album)#/media/File:CureDisintegration.jpg"));
        Album townes = new Album("Townes van Zandt", "Townes van Zandt", 10, 2039, new URL("https://en.wikipedia.org/wiki/Townes_Van_Zandt_(album)#/media/File:Townes1.jpg"));
        Album[] albums = {illmatic, disintegration, townes};
        return Arrays.toString(albums);
    }
}
