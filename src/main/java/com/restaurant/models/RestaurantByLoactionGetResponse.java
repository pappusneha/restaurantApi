package com.restaurant.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RestaurantByLoactionGetResponse {

  private List<Restaurants> data;

  public List<Restaurants> getData() {
    return data;
  }

  public void setData(List<Restaurants> data) {
    this.data = data;
  }
}
