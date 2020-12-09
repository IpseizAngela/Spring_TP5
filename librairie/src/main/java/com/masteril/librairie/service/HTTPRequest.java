package com.masteril.librairie.service;

import com.masteril.librairie.model.Parser;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class HTTPRequest {

    private static final String SERVICE_URI = "http://localhost:8080/Books";
    private static RestTemplate template;

    public HTTPRequest() {
        template = new RestTemplate();
    }

    public void addBook(String title, String author, String description, double price) {
        HttpEntity<String> request = makeRequest(title, author, description, price);
        template.postForLocation(SERVICE_URI, request);
    }

    public String getAllBooks() {
        ResponseEntity<String> responseEntity = template.getForEntity(SERVICE_URI, String.class);
        return Parser.parseList(responseEntity.getBody());
    }

    public String getBook(String title) {
        return Parser.parse(getBookJSON(title));
    }

    public String getBookJSON(String title) {
        ResponseEntity<String> responseEntity = template.getForEntity(SERVICE_URI + "/title/" + title, String.class);
        return responseEntity.getBody();
    }

    public void updateBook(int id, String title, String author, String description, double price) {
        HttpEntity<String> request = makeRequest(title, author, description, price);
        template.put(SERVICE_URI + "/"+id, request);
    }

    public void deleteBook(String title) {
        String json = getBookJSON(title);
        int id = Parser.getId(json);
        template.delete(SERVICE_URI + "/" + id);
    }

    private HttpEntity<String> makeRequest(String title, String author, String description, double price) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject bookJsonObject = new JSONObject();
        try {
            bookJsonObject.put("title", title);
            bookJsonObject.put("author", author);
            bookJsonObject.put("description", description);
            bookJsonObject.put("price", price);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new HttpEntity<>(bookJsonObject.toString(), headers);
    }

}
