package com.example.restService.managment;

import com.example.restService.model.Note;
import com.example.restService.model.TracedNote;
import com.example.restService.repository.TraceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Iterable<TracedNote> getSpecifiedData(Long id){
        return traceRepository.findByNoteidIs(id);
    }

    public TracedNote addData(Note note){
        TracedNote tracedNote = new TracedNote();
        tracedNote.setTitle(note.getTitle());
        tracedNote.setContent(note.getContent());
        tracedNote.setCreated(note.getCreated());
        tracedNote.setMotified(note.getMotified());
        tracedNote.setNoteid(note.getId());
        return traceRepository.save(tracedNote);
    }
}
