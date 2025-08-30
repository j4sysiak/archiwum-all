package drobczyk.bartlomiej.model.dto.api.quote;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QuoteDto {
    @JsonProperty("content")
    private String quote;
    private String author;

    public String getQuote() {
        return quote;
    }

    public String getAuthor() {
        return author;
    }

    public QuoteDto(String quote, String author) {
        this.quote = quote;
        this.author = author;
    }
}