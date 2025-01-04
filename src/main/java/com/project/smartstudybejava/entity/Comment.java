package com.project.smartstudybejava.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "comments")
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class Comment {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    Long id;
    String content;
    @ManyToOne
    User user;
    @ManyToOne
    NewsFeed newsFeed;
    Long commentLikes;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
