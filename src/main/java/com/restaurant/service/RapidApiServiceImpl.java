package com.restaurant.service;

import com.restaurant.models.RestaurantByLoactionGetResponse;
import com.restaurant.models.RestaurantDetailsGetByIdResponse;
import com.restaurant.models.Restaurants;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RapidApiServiceImpl implements RapidApiService {

  private static final String API_HOST = "travel-advisor.p.rapidapi.com";
  private static final String API_KEY = "f99e6502cbmshf3c67c121c57598p1be604jsnc35c14130368";
  private static final String BASE_URL = "https://travel-advisor.p.rapidapi.com";

  private final RestTemplate restTemplate;

  public RapidApiServiceImpl(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }


  @Override
  public List<Restaurants> getRestaurantByLocation(String latitude, String longitude) {
    HttpHeaders headers = createHeaders();
    HttpEntity<HttpHeaders> entity = new HttpEntity<>(headers);

    String url = String.format("%s/restaurants/list-by-latlng?latitude=%s&longitude=%s&limit=30&currency=USD&distance=2&open_now=false&lunit=km&lang=en_US",
            BASE_URL, latitude, longitude);

    ResponseEntity<RestaurantByLoactionGetResponse> response = restTemplate.exchange(
            url, HttpMethod.GET, entity, RestaurantByLoactionGetResponse.class);

    if( response.getBody() == null) {
      return Collections.emptyList();
    }
    return response.getBody().getData();
  }

  @Override
  public RestaurantDetailsGetByIdResponse getRestaurantDetailsById(String restaurantId) {
    HttpHeaders headers = createHeaders();
    HttpEntity<HttpHeaders> entity = new HttpEntity<>(headers);

    String url = String.format("%s/restaurants/get-details?location_id=%s&currency=USD&lang=en_US",
            BASE_URL, restaurantId);

    ResponseEntity<RestaurantDetailsGetByIdResponse> response = restTemplate.exchange(
            url, HttpMethod.GET, entity, RestaurantDetailsGetByIdResponse.class);

    return response.getBody();
  }

  private HttpHeaders createHeaders() {
    HttpHeaders headers = new HttpHeaders();
    headers.add("X-RapidAPI-Host", API_HOST);
    headers.add("X-RapidAPI-Key", API_KEY);
    return headers;
  }
}