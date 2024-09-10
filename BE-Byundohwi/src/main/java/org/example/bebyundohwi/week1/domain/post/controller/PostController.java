package org.example.bebyundohwi.week1.domain.post.controller;

import lombok.RequiredArgsConstructor;
import org.example.bebyundohwi.week1.domain.post.dto.request.PostCreateRequest;
import org.example.bebyundohwi.week1.domain.post.userservice.PostCreateService;
import org.example.bebyundohwi.week1.domain.post.userservice.PostDeleteService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users/post")
@RequiredArgsConstructor
public class PostController {
    private final PostCreateService postCreateService;
    private final PostDeleteService postDeleteService;

    @PostMapping("/create")
    public void create(@RequestBody PostCreateRequest request) {
        postCreateService.createPost(request);
    }

    @DeleteMapping("/delete/{postId}")
    public void delete(@PathVariable Long postId){
        postDeleteService.deletePost(postId);
    }
}
