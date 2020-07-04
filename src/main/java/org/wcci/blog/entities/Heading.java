package org.wcci.blog.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
public class Heading {
    @Id
    @GeneratedValue
    private long id;
    private String subject;
    private String description;
    @OneToMany(mappedBy = "heading")
    private Collection<Post> posts;

    protected Heading() {
    }

    public Heading(String subject, String description) {
        this.subject = subject;
        this.description = description;
    }

    public String getSubject() {
        return subject;
    }

    public String getDescription() {
        return description;
    }

    public Collection<Post> getPosts() {
        return posts;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Heading{" +
                "id=" + id +
                ", name='" + subject + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Heading heading = (Heading) o;

        if (id != heading.id) return false;
        if (subject != null ? !subject.equals(heading.subject) : heading.subject != null) return false;
        return description != null ? description.equals(heading.description) : heading.description == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
