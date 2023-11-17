package com.semestr.firstsemestrovka2kurs.models;

import java.time.LocalDate;

public class Comment {
    private long id;
    private String name;
    private String content;
    private long commenterId;
    private LocalDate dateOfComment;
    private long postId;
    private String posterName;

    public Comment(long id, String name, String content, long commenterId, LocalDate dateOfComment, long postId, String posterName) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.commenterId = commenterId;
        this.dateOfComment = dateOfComment;
        this.postId = postId;
        this.posterName = posterName;
    }

    public Comment(String name, String content, long commenterId, long postId, String posterName) {
        this.name = name;
        this.content = content;
        this.commenterId = commenterId;
        this.postId = postId;
        this.posterName = posterName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getCommenterId() {
        return commenterId;
    }

    public void setCommenterId(long commenterId) {
        this.commenterId = commenterId;
    }

    public LocalDate getDateOfComment() {
        return dateOfComment;
    }

    public void setDateOfComment(LocalDate dateOfComment) {
        this.dateOfComment = dateOfComment;
    }

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    public String getPosterName() {
        return posterName;
    }

    public void setPosterName(String posterName) {
        this.posterName = posterName;
    }
}
