package com.project.smartstudybejava.service;
import dev.langchain4j.data.document.loader.FileSystemDocumentLoader;
import dev.langchain4j.data.document.parser.apache.pdfbox.ApachePdfBoxDocumentParser;
import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.splitter.DocumentSplitters;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.store.embedding.EmbeddingStore;
import dev.langchain4j.store.embedding.EmbeddingStoreIngestor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EmbeddingComponent {

    private final EmbeddingModel embeddingModel;
    private final EmbeddingStore<TextSegment> embeddingStore;


    public void loadSingleDocument() {
        String currentDir = System.getProperty("user.dir");
        String fileName = "/src/main/resources/documents/Reading_1.pdf";

        Document document = FileSystemDocumentLoader.loadDocument(currentDir + "/" + fileName,
                new ApachePdfBoxDocumentParser());

        EmbeddingStoreIngestor embeddingStoreIngestor = EmbeddingStoreIngestor.builder()
                .documentSplitter(DocumentSplitters.recursive(300, 10))
                .embeddingModel(embeddingModel)
                .embeddingStore(embeddingStore)
                .build();

        embeddingStoreIngestor.ingest(document);
    }
}