package com.example.restService.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Note {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String title;
    private String content;
    private LocalDateTime created;
    private LocalDateTime motified;

    public Note(){
    }

    public Note(String title, String content, LocalDateTime created, LocalDateTime motified) {
        this.title = title;
        this.content = content;
        this.created = created;
        this.motified = motified;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getMotified() {
        return motified;
    }

    public void setMotified(LocalDateTime motified) {
        this.motified = motified;
    }
}
