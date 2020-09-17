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
        return notes.getSpecifiedData(index);
    }

    @GetMapping("/backup/all")
    public Iterable<TracedNote> getTracedNote(){
        return traces.getAllData();
    }

    @GetMapping("/backup/{index}")
    public Iterable<TracedNote> getTraceById(@PathVariable Long index){
        return traces.getSpecifiedData(index);
    }

    @PostMapping
    public void addData(@RequestBody Note note){
        note.setMotified(LocalDateTime.now());
        note.setCreated(LocalDateTime.now());
        addNote(note);
        addTrace(note);
    }

    public Note addNote(Note note){
        return notes.addData(note);
    }

    public TracedNote addTrace(Note note){
        return traces.addData(note);
    }

    @PutMapping("/{index}")
    public Note modifyNote(@PathVariable Long index, @RequestBody Note note){
        note.setId(index);
        note.setCreated(notes.getSpecifiedData(note.getId()).get().getCreated());
        note.setMotified(LocalDateTime.now());
        addTrace(note);
        return notes.addData(note);
    }

    @DeleteMapping("/{index}")
    public void deleteNote(@PathVariable Long index){
        notes.deleteData(index);
    }

}
