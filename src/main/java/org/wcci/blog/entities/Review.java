package org.wcci.blog.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Review {
    @Id
    @GeneratedValue
    private Long id;
    private String postTitle;
    private int userRating;
    private String userReviewComment;
    @ManyToOne
    private Post post ;
    @ManyToMany
    private Collection<Hashtag> hashtags;

    protected Review(){
    }

    public Review(String postTitle, int userRating, String userReviewComment, Hashtag...hashtags) {
        this.postTitle = postTitle;
        this.userRating = userRating;
        this.userReviewComment = userReviewComment;
        this.hashtags = new ArrayList<>(Arrays.asList(hashtags));
    }
    public String getPostTitle(){return postTitle; }

    public int getUserRating(){ return userRating; }

    public String getUserReviewComment(){ return userReviewComment; }

    public Long getId(){ return id; }

    public Collection<Hashtag> getHashtags(){ return hashtags; }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", postTitle='" + postTitle + '\'' +
                ", userRating='" + userRating + '\'' +
                ", userReviewComment='" + userReviewComment + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return id == review.id &&
                Objects.equals(postTitle, review.postTitle) &&
                Objects.equals(userRating, review.userRating) &&
                Objects.equals(userReviewComment, review.userReviewComment);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, postTitle, userRating, userReviewComment);
    }

    public void addHashtag(Hashtag hashtagtoAdd, Hashtag hashtagToAdd) {
        hashtags.add(hashtagToAdd);
    }
}







