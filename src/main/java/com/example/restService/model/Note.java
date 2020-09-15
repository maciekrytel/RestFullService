package com.example.restService.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
//@Table(name = "notes")
public class Note {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
//    @Column(name="note_id", nullable=false)
    private Long id;

//    @Column(name="title", nullable=false)
    private String title;

//    @Column(name="content", nullable=false)
    private String content;

//    @Column(name="created_at", nullable=false)
    private LocalDate created;

//    @Column(name="motified_at", nullable=false)
    private LocalDate motified;

    public Note(){
    }

    public Note(Long id, String title, String content, LocalDate created, LocalDate motified) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.created = created;
        this.motified = motified;
    }

    public long getId() {
        return id;
    }

    public void setId() {
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

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public LocalDate getMotified() {
        return motified;
    }

    public void setMotified(LocalDate motified) {
        this.motified = motified;
    }
}
