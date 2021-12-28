package com.devs.muestra.Mapeo;

public class MProductos {
    String author, story_title, story_url, comment_text, created_at, story_id;

    public MProductos(){

    }

    public MProductos(String author, String story_title, String story_url, String comment_text, String created_at, String story_id){
        this.author = author;
        this.story_title = story_title;
        this.story_url = story_url;
        this.comment_text = comment_text;
        this.created_at = created_at;
        this.story_id = story_id;
    }

    public String getStory_id() {
        return story_id;
    }

    public void setStory_id(String story_id) {
        this.story_id = story_id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getStory_title() {
        return story_title;
    }

    public void setStory_title(String story_title) {
        this.story_title = story_title;
    }

    public String getStory_url() {
        return story_url;
    }

    public void setStory_url(String story_url) {
        this.story_url = story_url;
    }

    public String getComment_text() {
        return comment_text;
    }

    public void setComment_text(String comment_text) {
        this.comment_text = comment_text;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }


}
