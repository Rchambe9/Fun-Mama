package org.wcci.blog.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Hashtag {
    @Id
    @GeneratedValue
    private long id;
    private String tagName;
    @ManyToMany (mappedBy = "hashtags")
    private Collection<Post> posts = new ArrayList<>();

    protected Hashtag() {}

    public Hashtag(String tagName) {
        this.tagName = tagName;

    }

    public long getId() {return id;}
    public String getTagName(){return tagName;}

    public Collection<Post> getPosts() {
        return posts;
    }

    public void setTagName(String tagName){
        this.tagName = tagName;
    }
    public void addPost(Post post){
        this.posts.add(post);
    }

}






