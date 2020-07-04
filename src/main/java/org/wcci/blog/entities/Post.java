package org.wcci.blog.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

// create an entity
@Entity
public class Post {
//    need id to make a database table
    @Id
    @GeneratedValue
    private long id;
    private String title;
    private String body;
    private String publishDate;

    @ManyToMany
    private Collection<Author> authors;
    private String name;
    private String posts;
    private String category;
    @ManyToOne
    private Heading heading;

    //  default JPA constructor
    protected Post() {}

// constructor for post class
    public  Post(String title, Author...authors, String category, Heading topic, String publishDate, String body) {
        this.title = title;
        this.body = body;
        this.publishDate = publishDate;
        this.category = category;
        this.authors = new ArrayList<>(Arrays.asList(authors));
        this.heading = heading;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Collection<Author> getAuthors() {
        return authors;
    }

    public String getBody() {
        return body;
    }

    public String getCategory() {
        return category;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public Heading getCampus() { return heading; }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isbn='" + publishDate + '\'' +
                ", description='" + category + '\'' +
                ", campus=" + heading +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return id == post.id &&
                Objects.equals(title, post.title) &&
                Objects.equals(publishDate, post.publishDate) &&
                Objects.equals(category, post.category) &&
                Objects.equals(heading, post.heading);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, publishDate, category, heading);
    }
}

