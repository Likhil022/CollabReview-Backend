package com.collabreview.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @ManyToOne
    private ReviewSession session;

    @ManyToOne
    private User user;

    private String filePath;
    private  Integer lineNumber;

    @Column(columnDefinition = "TEXT")
    private String body;
}
