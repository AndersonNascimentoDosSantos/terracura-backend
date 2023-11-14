package br.com.terracuraplantmanager.backend.Represantations;

import java.util.List;

public class Classification {
    private List<Sugestions> sugestions;

    public List<Sugestions> getSugestions() {
        return sugestions;
    }

    public void setSugestions(List<Sugestions> sugestions) {
        this.sugestions = sugestions;
    }
}
