package br.com.terracuraplantmanager.backend.Represantations;

import java.util.List;

public class Sugestions {
    private String id;
    private  String name;
    private Double probability;
    private List<Images> similar_images;
    private Details details;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getProbability() {
        return probability;
    }

    public void setProbability(Double probability) {
        this.probability = probability;
    }

    public List<Images> getSimilar_images() {
        return similar_images;
    }

    public void setSimilar_images(List<Images> similar_images) {
        this.similar_images = similar_images;
    }

    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
        this.details = details;
    }
}
