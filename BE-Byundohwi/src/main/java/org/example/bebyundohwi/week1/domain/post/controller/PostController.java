package org.example.bebyundohwi.week1.domain.post.controller;

import lombok.RequiredArgsConstructor;
import org.example.bebyundohwi.week1.domain.post.dto.request.PostCreateRequest;
import org.example.bebyundohwi.week1.domain.post.service.PostCreateService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    private final PostCreateService postCreateService;

    @PostMapping("/create")
    public void create(@RequestBody PostCreateRequest request) {
        System.out.println("yuio");
        postCreateService.createPost(request);
    }
}
