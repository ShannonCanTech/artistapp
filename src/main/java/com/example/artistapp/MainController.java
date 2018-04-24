package com.example.artistapp;

import com.example.artistapp.repository.ArtistRepository;
import com.example.artistapp.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class MainController {

    @Autowired
    ArtistRepository artistRepo;
    @Autowired
    SongRepository songRepo;

    @RequestMapping("/")
    public String showIndex(Model model){
        model.addAttribute("artists", artistRepo.findAll());
        model.addAttribute("songs", songRepo.findAll());
        model.addAttribute("somestuff", "home");
        return "index";
    }

    @GetMapping("/addartist")
    public String addArtist(Model model){
        model.addAttribute("anArtist", new Artist());
        model.addAttribute("somestuff", "addartist");
        return "addartist";
    }

    @GetMapping("/addsong")
    public String addSong(Model model) {
        model.addAttribute("aSong", new Song());
        model.addAttribute("somestuff", "addsong");
        return "addsong";
    }

    @RequestMapping("/artists")
    public String showArtists(Model model){
        model.addAttribute("artists", artistRepo.findAll());
        model.addAttribute("somestuff", "artists");
        return "listartists";
    }

    @RequestMapping("/songs")
    public String showSongs(Model model){
        model.addAttribute("songs", songRepo.findAll());
        model.addAttribute("somestuff", "songs");
        return "listsongs";
    }

    @PostMapping("/saveartist")
    public String saveArtist(@Valid @ModelAttribute("artist") Artist artist, BindingResult result){

        if(result.hasErrors()){
            return "addartist";
        }
        artistRepo.save(artist);
        return "redirect:artists";
    }

    @PostMapping("/savesong")
    public String saveSong(@Valid @ModelAttribute("song") Song song, BindingResult result){

        if(result.hasErrors()){
            return "addsong";
        }
        songRepo.save(song);
        return "redirect:songs";
    }

/*
    @RequestMapping("/changeartist/{id}")
    public String artistChange(@PathVariable("id") long id)
    {
        Artist thisArtist = artistRepo.findById(id).get();

        thisArtist.setArtistDone(!thisArtist.isArtistDone());
        artistRepo.save(thisArtist);
        return "redirect:artists";
    }

    @RequestMapping("/updateartist/{id}")
    public String artistUpdate(@PathVariable("id") long id, Model model)
    {
        model.addAttribute("anArtist",artistRepo.findById(id).get());
        return "addartist";
    }

    @RequestMapping("/changesong/{id}")
    public String songChange(@PathVariable("id") long id)
    {
        Song thisSong = songRepo.findById(id).get();

        thisSong.setSongDone(!thisSong.isSongDone());
        songRepo.save(thisSong);
        return "redirect:songs";
    }

    @RequestMapping("/updateartist/{id}")
    public String songUpdate(@PathVariable("id") long id, Model model)
    {
        model.addAttribute("anArtist",artistRepo.findById(id).get());
        return "addsong";
    }
*/

}
