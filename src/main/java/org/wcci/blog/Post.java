package org.wcci.blog;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
// create an entity
@Entity
public class Post {
//    need id to make a database table
    @Id
    @GeneratedValue
    private long id;
    private String title;

    //  default JPA constructor
    protected Post() {}

// constructor for post class
    public Post(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
