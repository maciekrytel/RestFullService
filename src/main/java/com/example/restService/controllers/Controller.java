package com.example.restService.controllers;

import com.example.restService.model.Note;
import com.example.restService.managment.NoteManagment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/api/model")
public class Controller {

    private NoteManagment notes;

    @Autowired
    public Controller(NoteManagment noteManagment) {
        this.notes = noteManagment;
    }

    @GetMapping("/all")
    public Iterable<Note> getNotes(){
        return notes.getAllData();
    }

    @GetMapping
    public Optional<Note> getById(@RequestParam Long index){
        return notes.getSpecifiedData(index);
    }

    @PostMapping
    public Note addNote(@RequestBody Note note){
        note.setMotified(LocalDateTime.now());
        note.setCreated(LocalDateTime.now());
        return notes.addData(note);
    }

    @PutMapping
    public Note modifyNote(@RequestBody Note note){
        note.setCreated(notes.getSpecifiedData(note.getId()).get().getCreated());
        note.setMotified(LocalDateTime.now());
        return notes.addData(note);
    }

    @DeleteMapping
    public void deleteNote(@RequestParam Long index){
        notes.deleteData(index);
    }

//    @RequestMapping(method = RequestMethod.GET, path = "/hello")
//    public String Welcome() {
//        return "Hi, I'm testing now";
//    }
}
