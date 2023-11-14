package br.com.terracuraplantmanager.backend.Represantations;

public class Result {
    private Classification classification;
    private IsPlant isPlant;

    public Classification getClassification() {
        return classification;
    }

    public void setClassification(Classification classification) {
        this.classification = classification;
    }

    public IsPlant getIsPlant() {
        return isPlant;
    }

    public void setIsPlant(IsPlant isPlant) {
        this.isPlant = isPlant;
    }
}
