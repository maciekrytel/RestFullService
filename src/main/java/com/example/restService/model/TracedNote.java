package com.example.restService.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class TracedNote {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private Long noteid;
    private String title;
    private String content;
    private LocalDateTime created;
    private LocalDateTime motified;

    public TracedNote(){
    }

    public TracedNote(String title, String content, LocalDateTime created, LocalDateTime motified, Long noteid) {
        this.title = title;
        this.content = content;
        this.created = created;
        this.motified = motified;
        this.noteid = noteid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="note_id", nullable=false)
    public Long getNoteid() {
        return noteid;
    }

    public void setNoteid(Long noteid) {
        this.noteid = noteid;
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
