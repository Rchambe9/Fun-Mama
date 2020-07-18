package org.wcci.blog.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.OneToMany;

@Entity
public class Author {
    @Id
    @GeneratedValue
    private long id;
    private String firstName;
    private String lastName;
    @OneToMany(mappedBy = "author")
    private Collection<Post> posts;


    protected Author() {
    }

    public Author(String firstName, String lastName) {

        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }
    public String getFirstName(){ return firstName;}
    public String getLastName(){ return lastName;}

    public Collection<Post> getPosts() {
        return posts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return id == author.id &&
                Objects.equals(firstName, author.firstName) &&
                Objects.equals(lastName, author.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName=" + lastName + '\'' +
                '}';
    }
}



