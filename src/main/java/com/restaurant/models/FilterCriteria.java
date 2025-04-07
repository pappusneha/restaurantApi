package com.restaurant.models;

import java.util.HashMap;
import java.util.Map;

public enum FilterCriteria {

  VEG("Vegetarian Friendly"),
  VEGAN("Vegan Options"),
  GLUTENFREE("Gluten Free Options"),
  DAIRYFREE("Vegan Options");

  private static final Map<String, FilterCriteria> filters = new HashMap<>();

  static {
    for (FilterCriteria f : values()) {
      filters.put(f.filterOption, f);
    }
  }

  public final String filterOption;

  FilterCriteria(String filterOption) {
    this.filterOption = filterOption;
  }

  public static FilterCriteria valueOfFilter(String filterOption) {
    for (FilterCriteria e : values()) {
      if (e.filterOption.equals(filterOption)) {
        return e;
      }
    }
    return null;
  }
}
