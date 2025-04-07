package com.restaurant.service;

import com.restaurant.models.RestaurantDetailsGetByIdResponse;
import com.restaurant.models.Restaurants;

import java.util.List;

public interface RapidApiService {

  List<Restaurants> getRestaurantByLocation(String latitude, String longitude);

  RestaurantDetailsGetByIdResponse getRestaurantDetailsById(String restaurantId);

}
