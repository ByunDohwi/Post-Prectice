package org.example.bebyundohwi.week1.domain.post.userservice;

import lombok.RequiredArgsConstructor;
import org.example.bebyundohwi.week1.domain.post.domain.PostEntity;
import org.example.bebyundohwi.week1.domain.post.dto.NoticeType;
import org.example.bebyundohwi.week1.domain.post.dto.request.PostCreateRequest;
import org.example.bebyundohwi.week1.domain.post.repository.PostRepository;
import org.example.bebyundohwi.week1.domain.user.facade.UserFacade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PostCreateService {
    private final PostRepository postRepository;
    private final UserFacade userFacade;

    @Transactional
    public void createPost(PostCreateRequest request) {

        PostEntity post = PostEntity.builder()
                        .title(request.getTitle())
                        .content(request.getContent())
                        .time(LocalDateTime.now())
                        .name(userFacade.getCurrentUser().getUsername())
                        .isNotice(NoticeType.POST)
                        .build();
        postRepository.save(post);
    }
}
