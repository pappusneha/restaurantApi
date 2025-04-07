package com.restaurant.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RestaurantDetailsGetByIdResponse {

  private String location_id;
  private String name;
  private Photo photo;
  private List<KeyValuePair> cuisine;
  private List<KeyValuePair> dietaryRestrictions;

  public String getLocation_id() {
    return location_id;
  }

  public void setLocation_id(String location_id) {
    this.location_id = location_id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Photo getPhoto() {
    return photo;
  }

  public void setPhoto(Photo photo) {
    this.photo = photo;
  }

  public List<KeyValuePair> getCuisine() {
    return cuisine;
  }

  public void setCuisine(List<KeyValuePair> cuisine) {
    this.cuisine = cuisine;
  }

  public List<KeyValuePair> getDietaryRestrictions() {
    return dietaryRestrictions;
  }

  public void setDietaryRestrictions(
      List<KeyValuePair> dietaryRestrictions) {
    this.dietaryRestrictions = dietaryRestrictions;
  }
}
