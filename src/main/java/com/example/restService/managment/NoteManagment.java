package com.example.restService.managment;

import com.example.restService.model.Note;
import com.example.restService.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class NoteManagment {

    private NoteRepository noteRepository;

    @Autowired
    public NoteManagment(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public Optional<Note> getSpecifiedData(Long id){
        return noteRepository.findById(id);
    }

    public Iterable<Note> getAllData(){
        return noteRepository.findAll();
    }

    public Note addData(Note note){
        return noteRepository.save(note);
    }

    public void deleteData(Long id){
        noteRepository.deleteById(id);
    }

//    @EventListener(ApplicationReadyEvent.class)
////    public void databaseFill(){
////        addData(new Note("pierwszy tutul", "to jest pierwsza zawartosc", LocalDateTime.now(),LocalDateTime.now()));
////        addData(new Note("drugi tutul", "druga zawartosc", LocalDateTime.now(),LocalDateTime.now()));
////    }
}
