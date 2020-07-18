package org.wcci.blog.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Hashtag {
    @Id
    @GeneratedValue
    private Long id;
    private String tag;
    @ManyToMany(mappedBy = "hashtags")
    private Collection<Post> posts;

    protected Hashtag() {}

    public Hashtag(String tag) {
        posts = new ArrayList<>();
        this.tag = tag;
    }

    public Long getId() {
        return id;
    }

    public String getTag() {
        return tag;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hashtag hashtag = (Hashtag) o;
        return id == hashtag.id &&
                Objects.equals(hashtag, hashtag.tag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tag);
    }


}






