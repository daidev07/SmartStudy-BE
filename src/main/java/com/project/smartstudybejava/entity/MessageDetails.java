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
@Table(name = "message_details")
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class MessageDetails {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    HistoryChatbot historyChatbot;
    String messageUser;
    String messageBot;
    LocalDateTime respondedAt;
}
