package org.example.bebyundohwi.week1.domain.post.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostCreateRequest {
    private String content;
    private String title;
}
