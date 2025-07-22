package com.telusko.SpringAIDemo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class GoogleSearchTool {

    @Value("${serpapi-api-key}")
    private String serpApiKey;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private final WebClient webClient;

    public GoogleSearchTool() {
        this.webClient = WebClient.builder().baseUrl("https://serpapi.com/search").build();
    }

    @Tool(description = "Search in Google using SerpAPI with provided query when information is not available in used LLM Models")
    public String search(String query) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("q", query)
                        .queryParam("engine", "google")
                        .queryParam("api_key", serpApiKey)
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .onErrorReturn("Failed to fetch results")
                .block();
    }

//    @Tool(description = "Search Google for the given query and return the top result")
//    public String searchGoogle(String query) {
//        // Example using SerpAPI (replace API_KEY with your key)
//        String apiKey = serpApiKey;
//        String url = "https://serpapi.com/search.json?q=" + query + "&api_key=" + apiKey;
//        RestTemplate restTemplate = new RestTemplate();
//        String result = restTemplate.getForObject(url, String.class);
//        // Parse and return the top result from the JSON response
//
//        System.out.println("Google Search Result: " + result);
//
//        return result; // You should parse and format this as needed
//    }

//    @Tool(description = "Search Google for the given query and return the top result")
//    public String searchGoogle(String query) {
//        String response = webClient.get()
//                .uri(uriBuilder -> uriBuilder
//                        .path("/search.json")
//                        .queryParam("q", query)
//                        .queryParam("engine", "google")
//                        .queryParam("api_key", serpApiKey)
//                        .build())
//                .retrieve()
//                .bodyToMono(String.class)
//                .onErrorReturn("Failed to fetch results")
//                .block();
//
//        try {
//            JsonNode root = objectMapper.readTree(response);
//            JsonNode results = root.path("organic_results");
//            if (results.isArray() && results.size() > 0) {
//                JsonNode top = results.get(0);
//                String title = top.path("title").asText();
//                String link = top.path("link").asText();
//                return "Top result: " + title + " (" + link + ")";
//            }
//        } catch (Exception e) {
//            return "Failed to parse search results";
//        }
//        return "No results found";
//    }
}
