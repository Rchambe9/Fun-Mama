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
    private String category;
    @ManyToOne
    private Collection<Author> authors;
//    private Author author;
    private Collection<Category> categories;
    @ManyToMany
    private Collection<Hashtag> hashtags;

    //  default JPA constructor
    protected Post() {}

// constructor for post class
    public  Post(String title, int publishDate, String body, Author author, Hashtag hashtag) {
        this.title = title;
        this.body = body;
        this.publishDate = publishDate;
        this.authors = authors;
        this.hashtags = hashtags;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Collection<Author> getAuthors() {   return authors;  }

    public String getBody() {
        return body;
    }

    public String getCategory() {
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

