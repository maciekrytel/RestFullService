package com.example.restService.repository;

import com.example.restService.model.TracedNote;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TraceRepository extends CrudRepository<TracedNote, Long> {
}
