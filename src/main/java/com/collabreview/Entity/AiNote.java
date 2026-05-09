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
public class AiNote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private  ReviewSession session;

    private String type;
    @Column(columnDefinition = "TEXT")
    private  String codeSnippet;
    @Column(columnDefinition = "TEXT")
    private String aiResponse;
}
