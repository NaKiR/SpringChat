package com.nakir.chat.domain;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(
                name = "fetchRecentMessages",
                query = "from Message"
        )
})

@Entity
@Table(name="messages")
public class Message {
    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @Column(name="message")
    private String message;

    @ManyToOne
    @JoinColumn(name="author_id")
    private User author;

    public Message() {

    }

    public Message(String message, User author) {
        this.message = message;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public User getAuthor() {
        return this.author;
    }
}
