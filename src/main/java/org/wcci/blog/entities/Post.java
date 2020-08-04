package org.wcci.blog.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
public class Post {

    @Id
    @GeneratedValue
    private long id;
    private String imageUrl;
    @Column(length = 100000)
    @Lob
    private String body;
    private LocalDate publishDate;
    @ManyToOne
    private Author author;
    @ManyToOne
    private Category category;
    private String title;
    @ManyToMany
    private Collection<Hashtag> hashtags;

    // constructor for post class
    public Post(String title, Author author, String publishDate, String imageUrl, String body, Category category, Hashtag... hashtags) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.body = body;
        this.publishDate = LocalDate.parse(publishDate);
        this.author = author;
        this.category = category;
        this.hashtags = new ArrayList<>(Arrays.asList(hashtags));

    }

    protected Post() {
    }


    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getBody() {
        return body;
    }


    public Category getCategory() {
        return category;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public Collection<Hashtag> getHashtags() {
        return hashtags;
    }

    public void addHashtag(Hashtag hashtag) {
        hashtags.add(hashtag);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publishDate='" + publishDate + '\'' +
                ", body='" + body + '\'' +
                ", category=" + category +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;
        Post post = (Post) o;
        return id == post.id &&
                Objects.equals(category, post.category) &&
                Objects.equals(title, post.title) &&
                Objects.equals(publishDate, post.publishDate) &&
                Objects.equals(body, post.body);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, title, publishDate, body, category);

    }


}

