package com.project.smartstudybejava.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "newsfeeds")
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class NewsFeed {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    Long id;
    String content;
    String imageFile;
    LocalDateTime postedAt;
    @ManyToOne
    User user;
    @ManyToOne
    Classroom classroom;
    Long likes;
}
