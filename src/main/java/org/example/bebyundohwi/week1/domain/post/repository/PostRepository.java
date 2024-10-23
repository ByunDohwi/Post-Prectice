package org.example.bebyundohwi.week1.domain.post.repository;

import org.example.bebyundohwi.week1.domain.post.domain.PostEntity;
import org.example.bebyundohwi.week1.domain.post.dto.NoticeType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<PostEntity, Long> {
    List<PostEntity> findAllByIsNotice(NoticeType isNotice);
}
