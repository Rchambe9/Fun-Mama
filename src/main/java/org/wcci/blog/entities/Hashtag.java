package org.wcci.blog.entities;



public class Hashtag {
    private String postTitle;
    private String postAuthor;
    private String postPublishDate;
    private int rating;
    private String comment;

    protected Hashtag() {}

    public Hashtag(String postTitle, String postAuthor, String postPublishDate, int rating, String comment ) {
        this.postTitle = postTitle;
        this.postAuthor = postAuthor;
        this.postPublishDate = postPublishDate;
        this.rating = rating;
        this.comment = comment;
    }

    public String getPostTitle() { return postTitle; }

    public String getPostAuthor() {
        return postAuthor;
    }

    public String getPostPublishDate() { return postPublishDate; }

    public int getRating() { return rating;}

    public String getComment(){ return comment; }



}






