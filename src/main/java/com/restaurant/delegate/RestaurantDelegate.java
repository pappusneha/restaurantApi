package com.restaurant.delegate;

import com.restaurant.models.FilterCriteria;
import com.restaurant.models.KeyValuePair;
import com.restaurant.models.Restaurants;
import com.restaurant.service.RapidApiService;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RestaurantDelegate {


  private final RapidApiService rapidApiService;

  @Autowired
  public RestaurantDelegate(RapidApiService rapidApiService) {
    this.rapidApiService = rapidApiService;
  }

  /**
   * Retrieves a list of restaurants based on the provided filter and location.
   *
   * @param filter the filter criteria for the restaurants
   * @param latitude the latitude of the location
   * @param longitude the longitude of the location
   * @return a list of restaurants matching the filter criteria
   */
  public List<Restaurants> getRestaurantsByLocation(String filter, String latitude,
                                                    String longitude) {

    List<Restaurants> restaurantsList = rapidApiService
        .getRestaurantByLocation(latitude, longitude);

    if (filter.equalsIgnoreCase("All")) {
      return restaurantsList;
    } else {
      List<Restaurants> filteredList = new ArrayList<>();

      FilterCriteria filterCriteria = FilterCriteria.valueOf(filter);
      restaurantsList.forEach(restaurant -> {
        List<KeyValuePair> cuisines = restaurant.getCuisine();
        if (cuisines != null && !cuisines.isEmpty() && cuisines.stream().anyMatch(cuisine ->
            cuisine.getName().equalsIgnoreCase(filterCriteria.filterOption)
        )) {
          filteredList.add(restaurant);
        }
      });
      return filteredList;
    }
  }
}