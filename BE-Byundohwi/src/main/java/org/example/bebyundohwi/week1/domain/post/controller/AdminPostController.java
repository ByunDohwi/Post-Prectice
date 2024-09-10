package org.example.bebyundohwi.week1.domain.post.controller;

import lombok.RequiredArgsConstructor;
import org.example.bebyundohwi.week1.domain.post.adminservice.AdminPostCreateService;
import org.example.bebyundohwi.week1.domain.post.dto.request.PostCreateRequest;
import org.example.bebyundohwi.week1.domain.post.dto.response.PostGetResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/post")
public class AdminPostController {
    private final AdminPostCreateService adminPostCreateService;

    @PostMapping("/create")
    public void create(@RequestBody PostCreateRequest request){
        adminPostCreateService.createpost(request);
    }
}
