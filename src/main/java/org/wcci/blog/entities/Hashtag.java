package org.wcci.blog.entities;

public class Hashtag {

        private String postTitle;
        private String postAuthor;
        private String postPublishDate;
        private int rating;
        private String content;

        public Hashtag(String postTitle, String postAuthor, String postPublishDate, int rating, String content) {
            this.postTitle = postTitle;
            this.postAuthor = postAuthor;
            this.postPublishDate = postPublishDate;
            this.rating = rating;
            this.content = content;
        }

        public String getPostTitle() {
            return postTitle;
        }

        public String getPostAuthor() {
            return postAuthor;
        }

        public String getBookPublishDate() {
            return postPublishDate;
        }

        public int getRating() {
            return rating;
        }

        public String getContent() {
            return content;
        }

    }


