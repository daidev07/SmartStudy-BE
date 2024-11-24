package com.project.smartstudybejava.controller;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/history-chatbot")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ListeningController {


}
