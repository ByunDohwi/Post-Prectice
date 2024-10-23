package org.example.bebyundohwi.week1.domain.post.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.bebyundohwi.week1.domain.post.domain.PostEntity;

import java.util.List;

@Getter
@AllArgsConstructor
public class PostGetResponse {
    private final List<PostEntity> noticeList;
    private final List<PostEntity> postLIst;
}
