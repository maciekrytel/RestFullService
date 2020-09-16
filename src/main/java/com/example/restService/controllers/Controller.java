package com.example.restService.controllers;

import com.example.restService.managment.TraceManagment;
import com.example.restService.model.Note;
import com.example.restService.managment.NoteManagment;
import com.example.restService.model.TracedNote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/api/model")
public class Controller {

    private NoteManagment notes;
    private TraceManagment traces;

    @Autowired
    public Controller(NoteManagment noteManagment, TraceManagment trace) {
        this.notes = noteManagment;
        this.traces = trace;
    }

    @GetMapping("/all")
    public Iterable<Note> getNotes(){
        return notes.getAllData();
    }

    @GetMapping("/{index}")
    public Optional<Note> getById(@PathVariable Long index){
        System.out.println(notes.getSpecifiedData(index).get().getId());
        return notes.getSpecifiedData(index);
    }

    @GetMapping("/backup/all")
    public Iterable<TracedNote> getTracedNote(){
        return traces.getAllData();
    }

    @PostMapping
    public Note addNote(@RequestBody Note note){
        System.out.println(note.getId());
        note.setMotified(LocalDateTime.now());
        note.setCreated(LocalDateTime.now());
        addTrace(note);
        return notes.addData(note);
    }

//    @PostMapping
    public TracedNote addTrace(Note note){
        return traces.addData(note);
    }

    @PutMapping("/modify/{index}")
    public Note modifyNote(@PathVariable Long index, @RequestBody Note note){
        note.setId(index);
        note.setCreated(notes.getSpecifiedData(note.getId()).get().getCreated());
        note.setMotified(LocalDateTime.now());
        addTrace(note);
        return notes.addData(note);
    }

    @DeleteMapping("/delete/{index}")
    public void deleteNote(@PathVariable Long index){
        notes.deleteData(index);
    }

//    @RequestMapping(method = RequestMethod.GET, path = "/hello")
//    public String Welcome() {
//        return "Hi, I'm testing now";
//    }
}
