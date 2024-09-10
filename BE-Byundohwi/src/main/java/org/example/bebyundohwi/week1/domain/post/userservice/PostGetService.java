package org.example.bebyundohwi.week1.domain.post.userservice;

import lombok.RequiredArgsConstructor;
import org.example.bebyundohwi.week1.domain.post.domain.PostEntity;
import org.example.bebyundohwi.week1.domain.post.dto.NoticeType;
import org.example.bebyundohwi.week1.domain.post.dto.response.PostGetResponse;
import org.example.bebyundohwi.week1.domain.post.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostGetService {
    private final PostRepository postRepository;

    @Transactional
    public PostGetResponse getPost() {
        List<PostEntity> postList = postRepository.findAllByIsNotice(NoticeType.POST);
        List<PostEntity> noticeList = postRepository.findAllByIsNotice(NoticeType.NOTICE);

        return new PostGetResponse(noticeList, postList);
    }
}
