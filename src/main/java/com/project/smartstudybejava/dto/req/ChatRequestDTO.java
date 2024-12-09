package com.project.smartstudybejava.dto.req;

public record ChatRequestDTO(String question, Long userId, String expandedContent) {
}
