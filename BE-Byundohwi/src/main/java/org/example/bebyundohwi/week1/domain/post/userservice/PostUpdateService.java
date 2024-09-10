package org.example.bebyundohwi.week1.domain.post.userservice;

import lombok.RequiredArgsConstructor;
import org.example.bebyundohwi.week1.domain.post.domain.PostEntity;
import org.example.bebyundohwi.week1.domain.post.dto.request.PostCreateRequest;
import org.example.bebyundohwi.week1.domain.post.exception.PostNotFoundException;
import org.example.bebyundohwi.week1.domain.post.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostUpdateService {
    private final PostRepository postRepository;

    @Transactional
    public void update(PostCreateRequest request, Long id){
        PostEntity post = postRepository.findById(id).orElseThrow(()-> PostNotFoundException.EXCEPTION);

        post.update(request.getTitle(),request.getContent());
    }
}
