package com.restaurant.controller;

import com.restaurant.delegate.RestaurantDelegate;
import com.restaurant.models.RestaurantDetailsGetByIdResponse;
import com.restaurant.models.Restaurants;
import com.restaurant.service.RapidApiService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RestaurantController {


  private final RapidApiService rapidApiService;
  private final RestaurantDelegate restaurantDelegate;

  /**
   * Constructor for IwsDemoController.
   *
   * @param rapidApiService the service to interact with the RapidAPI for restaurant data
   * @param restaurantDelegate the delegate to handle business logic for restaurant data
   */
  @Autowired
  public RestaurantController(RapidApiService rapidApiService,
                              RestaurantDelegate restaurantDelegate) {
    this.rapidApiService = rapidApiService;
    this.restaurantDelegate = restaurantDelegate;
  }

  /**
   * Retrieves a list of restaurants based on the provided location filter.
   *
   * @param filter the filter criteria for the restaurants
   * @return a list of restaurants matching the filter criteria
   */
  @GetMapping(value = "/location")
  public List<Restaurants> getRestaurantByLocation(@Param("filter") String filter) {

    String latitude = "42.33229775411248";
    String longitude = "-71.63008028141098";
    return restaurantDelegate.getRestaurantsByLocation(filter, latitude, longitude);
  }

  /**
   * Retrieves restaurant details by its locationId.
   *
   * @param locationId the locationId of the restaurant
   * @return the details of the restaurant
   */

  @GetMapping(value = "/restaurantId/{locationId}")
  public RestaurantDetailsGetByIdResponse getRestaurantById(
      @PathVariable("locationId") String locationId) {

    return rapidApiService.getRestaurantDetailsById(locationId);
  }


}
