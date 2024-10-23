package org.example.bebyundohwi.week1.domain.post.domain;

import jakarta.persistence.*;
import lombok.*;
import org.example.bebyundohwi.week1.domain.post.dto.NoticeType;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(value = EnumType.STRING)
    private NoticeType isNotice;


    private LocalDateTime time;
    private String title;
    private String content;

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
