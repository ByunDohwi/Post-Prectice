package org.example.bebyundohwi.week1.domain.post.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.bebyundohwi.week1.domain.post.dto.request.PostCreateRequest;
import org.example.bebyundohwi.week1.domain.post.dto.response.PostGetResponse;
import org.example.bebyundohwi.week1.domain.post.userservice.PostCreateService;
import org.example.bebyundohwi.week1.domain.post.userservice.PostDeleteService;
import org.example.bebyundohwi.week1.domain.post.userservice.PostGetService;
import org.example.bebyundohwi.week1.domain.post.userservice.PostUpdateService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users/post")
@RequiredArgsConstructor
public class PostController {
    private final PostCreateService postCreateService;
    private final PostDeleteService postDeleteService;
    private final PostGetService postGetService;
    private final PostUpdateService postUpdateService;

    @PostMapping("/create")
    public void create(@RequestBody PostCreateRequest request) {
        postCreateService.createPost(request);
    }

    @DeleteMapping("/delete/{postId}")
    public void delete(@PathVariable Long postId){
        postDeleteService.deletePost(postId);
    }

    @GetMapping("/get")
    public PostGetResponse get() {
        return postGetService.getPost();
    }

    @PatchMapping("/update/{postId}")
    public void update(@RequestBody PostCreateRequest request, @PathVariable Long postId) {
        postUpdateService.update(request,postId);
    }
}
