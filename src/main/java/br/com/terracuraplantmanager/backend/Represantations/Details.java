package br.com.terracuraplantmanager.backend.Represantations;

import java.util.List;

public class Details {
    private CommomNames commom_names;
    private Taxonomy taxonomy;
    private Url url;
    private Integer gbif_id;
    private Integer inaturalist_id;
    private Integer rank;
    private Description description;
    private List<String> synonyms;
    private DescriptionValue image;

    private Watering watering;
    private String propagation_methods;
    private String edible_parts;
    private String entity_id;

    public CommomNames getCommom_names() {
        return commom_names;
    }

    public void setCommom_names(CommomNames commom_names) {
        this.commom_names = commom_names;
    }

    public Taxonomy getTaxonomy() {
        return taxonomy;
    }

    public void setTaxonomy(Taxonomy taxonomy) {
        this.taxonomy = taxonomy;
    }

    public Url getUrl() {
        return url;
    }

    public void setUrl(Url url) {
        this.url = url;
    }

    public Integer getGbif_id() {
        return gbif_id;
    }

    public void setGbif_id(Integer gbif_id) {
        this.gbif_id = gbif_id;
    }

    public Integer getInaturalist_id() {
        return inaturalist_id;
    }

    public void setInaturalist_id(Integer inaturalist_id) {
        this.inaturalist_id = inaturalist_id;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public List<String> getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(List<String> synonyms) {
        this.synonyms = synonyms;
    }

    public DescriptionValue getImage() {
        return image;
    }

    public void setImage(DescriptionValue image) {
        this.image = image;
    }

    public Watering getWatering() {
        return watering;
    }

    public void setWatering(Watering watering) {
        this.watering = watering;
    }

    public String getPropagation_methods() {
        return propagation_methods;
    }

    public void setPropagation_methods(String propagation_methods) {
        this.propagation_methods = propagation_methods;
    }

    public String getEdible_parts() {
        return edible_parts;
    }

    public void setEdible_parts(String edible_parts) {
        this.edible_parts = edible_parts;
    }

    public String getEntity_id() {
        return entity_id;
    }

    public void setEntity_id(String entity_id) {
        this.entity_id = entity_id;
    }
}
