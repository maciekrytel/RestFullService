package com.example.restService.repository;

import com.example.restService.model.TracedNote;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TraceRepository extends CrudRepository<TracedNote, Long> {
    List<TracedNote> findByNoteidIs(Long id);
}
