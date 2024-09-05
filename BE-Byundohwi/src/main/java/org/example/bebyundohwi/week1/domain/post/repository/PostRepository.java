package org.example.bebyundohwi.week1.domain.post.repository;

import org.example.bebyundohwi.week1.domain.post.domain.PostEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<PostEntity, Long> {

}
