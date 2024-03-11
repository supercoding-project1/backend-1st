package com.example.postproject.controller;

import com.example.postproject.domain.Post;
import com.example.postproject.dto.AuthInfo;
import com.example.postproject.dto.PostResponse;
import com.example.postproject.dto.Postrequest;
import com.example.postproject.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class PostController {
    private PostService postService;

    @PostMapping
    public ResponseEntity<PostResponse> writePost(
            AuthInfo authInfo,
            @RequestBody Postrequest postrequest
    ) {
        Post post = postService.writePost(postrequest.getTitle(), postrequest.getBody());
        return ResponseEntity.ok(PostResponse.from(post));
    }

    @GetMapping
    public ResponseEntity<List<PostResponse>> getAllPosts(AuthInfo authInfo) {
        return ResponseEntity.ok(
                postService.getAllPosts().stream()
                        .map(PostResponse::from)
                        .collect(Collectors.toList())
        );
    }
    @PutMapping
    public ResponseEntity<Post> updatePost(Long id, Post updatePost){
        try{
            Post post = postService.updatePost(id, updatePost);
            return ResponseEntity.ok(post);
        } catch (NotFoundexception e){
            return ResponseEntity.notFound().build();
        }
    }
}
