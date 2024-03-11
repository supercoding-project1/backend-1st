package com.example.postproject.dto;

import com.example.postproject.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
@Builder
@AllArgsConstructor
@Getter
public class PostResponse {
    private Long postID;
    private Long writerMemberID;
    private String title;
    private String body;
    private LocalDateTime createdAt;

    public static PostResponse from(Post post){
        return PostResponse.builder()
                .postID(post.getId())
//                .writerMemberID(post.getWriter().getID())
                .title(post.getTitle())
                .body(post.getBody())
                .createdAt(post.getCreatedAt())
                .build();
    }
}
