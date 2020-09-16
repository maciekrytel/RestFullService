package com.example.restService.managment;

import com.example.restService.model.Note;
import com.example.restService.model.TracedNote;
import com.example.restService.repository.TraceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TraceManagment {

    private TraceRepository traceRepository;

    @Autowired
    public TraceManagment(TraceRepository traceRepository) {
        this.traceRepository = traceRepository;
    }

    public Iterable<TracedNote> getAllData(){
        return traceRepository.findAll();
    }

    public TracedNote addData(Note note){
        TracedNote tracedNote = new TracedNote();
        tracedNote.setTitle(note.getTitle());
        tracedNote.setContent(note.getContent());
        tracedNote.setCreated(note.getCreated());
        tracedNote.setMotified(note.getMotified());
        return traceRepository.save(tracedNote);
    }

//    @EventListener(ApplicationReadyEvent.class)
//    public void databaseFill(){
//        addData(new TracedNote("pierwszy tutul", "to jest pierwsza zawartosc", LocalDateTime.now(),LocalDateTime.now(), 1L));
//        addData(new TracedNote("drugi tutul", "druga zawartosc", LocalDateTime.now(),LocalDateTime.now()), 2L);
//    }
}
