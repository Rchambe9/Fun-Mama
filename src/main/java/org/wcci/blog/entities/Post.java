package org.wcci.blog.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Post {

    @Id
    @GeneratedValue
    private long id;
    private String title;
    private String body;
    private int publishDate;
    @ManyToOne
    private Author author;
    @ManyToOne
    private Category category;
    @ManyToMany
    private Collection<Hashtag> hashtags;

    //  default JPA constructor
    protected Post() {}

// constructor for post class
    public  Post(String title, Category category, int publishDate, String body, Author author, Hashtag hashtag) {
        this.title = title;
        this.body = body;
        this.publishDate = publishDate;
        this.author = author;
        this.hashtags = hashtags;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {   return author;  }

    public String getBody() {
        return body;
    }

    public Category getCategory() {
        return category;
    }

    public int getPublishDate() {
        return publishDate;
    }

    public Collection<Hashtag> getHashtag() { return hashtags; }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", publishDate='" + publishDate + '\'' +
                ", body='" + body + '\'' +
                ", hashtag=" + hashtags +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return id == post.id &&
                Objects.equals(category, post.category) &&
                Objects.equals(title, post.title) &&
                Objects.equals(publishDate, post.publishDate) &&
                Objects.equals(body, post.body) &&
                Objects.equals(hashtags, post.hashtags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category, publishDate, body, hashtags);
    }
}

