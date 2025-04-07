package com.restaurant.models;

public class Images {

  private ImageDetails small;
  private ImageDetails thumbnail;
  private ImageDetails original;
  private ImageDetails large;
  private ImageDetails medium;

  public ImageDetails getSmall() {
    return small;
  }

  public void setSmall(ImageDetails small) {
    this.small = small;
  }

  public ImageDetails getThumbnail() {
    return thumbnail;
  }

  public void setThumbnail(ImageDetails thumbnail) {
    this.thumbnail = thumbnail;
  }

  public ImageDetails getOriginal() {
    return original;
  }

  public void setOriginal(ImageDetails original) {
    this.original = original;
  }

  public ImageDetails getLarge() {
    return large;
  }

  public void setLarge(ImageDetails large) {
    this.large = large;
  }

  public ImageDetails getMedium() {
    return medium;
  }

  public void setMedium(ImageDetails medium) {
    this.medium = medium;
  }
}
