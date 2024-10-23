package org.example.bebyundohwi.week1.domain.post.userservice;

import lombok.RequiredArgsConstructor;
import org.example.bebyundohwi.week1.domain.post.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostDeleteService {
    private final PostRepository postRepository;
    @Transactional
    public void deletePost(Long postId){
        postRepository.deleteById(postId);
    }
}
