package com.project.smartstudybejava.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "history_chatbots")
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class HistoryChatbot {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    User user;
    String title;
    LocalDateTime createdAt;
    @OneToMany(mappedBy = "historyChatbot")
    @JsonIgnoreProperties("historyChatbot")
    List<MessageDetails> messageDetails;
}
