package com.example.postproject.service;

import com.example.postproject.domain.Post;
import com.example.postproject.dto.Postrequest;
import com.example.postproject.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Member;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {
    private final PostRepository postRepository;

    public Post writePost(String title, String body) {
        return postRepository.save(
                Post.builder()
                        .title(title)
                        .body(body)
                        .createdAt(LocalDateTime.now())
                        .build()
        );
    }

    @Transactional(readOnly = true)
    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }
}
