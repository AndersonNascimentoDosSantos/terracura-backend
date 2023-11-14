package br.com.terracuraplantmanager.backend.Represantations;

import java.util.List;

public class Input {
    private Double latitude;
    private Double longitude;

    private Boolean similar_images;
    private List<String> images;
    private String datetime;

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Boolean getSimilar_images() {
        return similar_images;
    }

    public void setSimilar_images(Boolean similar_images) {
        this.similar_images = similar_images;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }
}
