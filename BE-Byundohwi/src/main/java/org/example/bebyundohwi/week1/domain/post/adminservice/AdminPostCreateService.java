package org.example.bebyundohwi.week1.domain.post.adminservice;

import lombok.RequiredArgsConstructor;
import org.example.bebyundohwi.week1.domain.post.domain.PostEntity;
import org.example.bebyundohwi.week1.domain.post.dto.NoticeType;
import org.example.bebyundohwi.week1.domain.post.dto.request.PostCreateRequest;
import org.example.bebyundohwi.week1.domain.post.repository.PostRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AdminPostCreateService {
    private final PostRepository postRepository;
    public void createpost(PostCreateRequest request) {

        PostEntity post = PostEntity.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .time(LocalDateTime.now())
                .name(SecurityContextHolder.getContext().getAuthentication().getName())
                .isNotice(NoticeType.NOTICE)
                .build();
        postRepository.save(post);
    }
}
