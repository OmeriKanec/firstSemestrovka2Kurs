package com.semestr.firstsemestrovka2kurs.models;

import java.time.LocalDate;

public class Post {
    private long id;
    private String name;
    private String content;
    private long posterId;
    private LocalDate dateOfPost;
    private boolean allowComments;
    private String posterName;

    public Post(long id, String name, String content, long posterId, LocalDate dateOfPost, boolean allowComments, String posterName) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.posterId = posterId;
        this.dateOfPost = dateOfPost;
        this.allowComments = allowComments;
        this.posterName = posterName;
    }

    public Post(String name, String content, long posterId, boolean allowComments, String postername) {
        this.name = name;
        this.content = content;
        this.posterId = posterId;
        this.allowComments = allowComments;
        this.posterName = postername;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPosterName() {
        return posterName;
    }

    public void setPosterName(String posterName) {
        this.posterName = posterName;
    }

    public long getPosterId() {
        return posterId;
    }

    public LocalDate getDateOfPost() {
        return dateOfPost;
    }

    public boolean isAllowComments() {
        return allowComments;
    }

    public void setId(long id) {
        this.id = id;
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

    public void setPosterId(long posterId) {
        this.posterId = posterId;
    }

    public void setDateOfPost(LocalDate dateOfPost) {
        this.dateOfPost = dateOfPost;
    }

    public void setAllowComments(boolean allowComments) {
        this.allowComments = allowComments;
    }
}
