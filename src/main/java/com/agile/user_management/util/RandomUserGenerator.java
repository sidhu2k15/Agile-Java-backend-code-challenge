package com.agile.user_management.util;

import com.agile.user_management.entity.User;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class RandomUserGenerator {

    private static final String RANDOM_USER_API_URL = "https://randomuser.me/api/?results={count}";
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public RandomUserGenerator() {
        this.restTemplate = new RestTemplate();
        this.objectMapper = new ObjectMapper();
    }

    /**
     * Fetches random users from the Random User Generator API and maps them to User entities.
     *
     * @param count the number of random users to fetch
     * @return a list of User entities
     */
    public List<User> fetchRandomUsers(int count) {
        List<User> users = new ArrayList<>();
        try {
            // Call the Random User API
            String response = restTemplate.getForObject(RANDOM_USER_API_URL, String.class, count);

            // Parse the JSON response
            JsonNode root = objectMapper.readTree(response);
            JsonNode results = root.get("results");

            // Map JSON data to User entities
            for (JsonNode result : results) {
                User user = new User();
                user.setUsername(result.get("login").get("username").asText());
                user.setName(result.get("name").get("first").asText() + " " + result.get("name").get("last").asText());
                user.setEmail(result.get("email").asText());
                user.setGender(result.get("gender").asText());
                user.setPictureUrl(result.get("picture").get("large").asText());
                user.setCountry(result.get("location").get("country").asText());
                user.setState(result.get("location").get("state").asText());
                user.setCity(result.get("location").get("city").asText());
                users.add(user);
            }

        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch random users", e);
        }
        return users;
    }
}
