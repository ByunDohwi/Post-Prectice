package org.example.bebyundohwi.week1.domain.post.service;

import lombok.RequiredArgsConstructor;
import org.example.bebyundohwi.week1.domain.post.domain.PostEntity;
import org.example.bebyundohwi.week1.domain.post.dto.request.PostCreateRequest;
import org.example.bebyundohwi.week1.domain.post.repository.PostRepository;
import org.example.bebyundohwi.week1.domain.user.facade.UserFacade;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PostCreateService {
    private final PostRepository postRepository;
    private final UserFacade userFacade;

    public void createPost(PostCreateRequest request) {
        System.out.println("asdf");
        PostEntity post = PostEntity.builder()
                        .title(request.getTitle())
                        .content(request.getContent())
                        .time(LocalDateTime.now())
                        .name(userFacade.getCurrentUser().getUsername())
                        .build();
        postRepository.save(post);
    }
}
