package com.project.smartstudybejava.controller;


import com.project.smartstudybejava.service.EmbeddingComponent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class LoadController {

    private final EmbeddingComponent embeddingComponent;

    @GetMapping("/load/single")
    public void loadSingleDocument() {
        log.info("Starting load single document");
        embeddingComponent.loadSingleDocument();
        log.info("End load single document");

    }
}
