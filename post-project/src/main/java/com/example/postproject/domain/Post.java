package com.example.postproject.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Post {
    @Id
    @GeneratedValue
    private  Long id;

//    @ManyToOne
//    @JoinColumn(name = "writer_member_id")
//    private Member writer;

    private String title;

    private String body;
    private LocalDateTime createdAt;
}