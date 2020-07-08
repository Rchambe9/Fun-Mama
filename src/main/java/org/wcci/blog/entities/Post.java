package org.wcci.blog.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
public class Post {

    @Id
    @GeneratedValue
    private Long id;
    private String postTitle;
    private String body;
    private int publishDate;
    private String category;

    @ManyToMany
    private Collection<Hashtag> hashtags;
    private Collection<Author> authors;

    //  default JPA constructor
    protected Post() {}

// constructor for post class
    public  Post(String postTitle, int publishDate, String category, String body, Hashtag hashtag, Author... authors) {
        this.postTitle = postTitle;
        this.body = body;
        this.publishDate = publishDate;
        this.author = authors;
        this.hashtags = hashtags;
    }

    public long getId() {
        return id;
    }

    public String getPostTitle() {
        return postTitle;
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

    public Hashtag getHashtag() { return hashtags; }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", postTitle='" + postTitle + '\'' +
                ", publishDate='" + publishDate + '\'' +
                ", category='" + category + '\'' +
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
                Objects.equals(postTitle, post.postTitle) &&
                Objects.equals(publishDate, post.publishDate) &&
                Objects.equals(category, post.category) &&
                Objects.equals(body, post.body) &&
                Objects.equals(hashtags, post.hashtags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, postTitle, publishDate, category, body, hashtags);
    }
}

//    Author author1 = new Author("Sarah Greene");
//    Author author2 = new Author("Jane Doe");
//    Author author3 = new Author("John Doe");
//
//        authorRepo.save(author1);
//                authorRepo.save(author2);
//                authorRepo.save(author3);
//
//                ArrayList<Author> authors = new ArrayList<Author>();
//        authors.add(author1);
//        authors.add(author2);
//        }