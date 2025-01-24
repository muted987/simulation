package com.muted987.simulation.entity;

public enum EntitySymbol {
    Tree("T"), Herbivore("H"), Predator("P"), Grass("G"), Rock("R");

    private final String unicodeSymbol;
    EntitySymbol(String unicodeSymbol){
        this.unicodeSymbol = unicodeSymbol;
    }

    public String getUnicodeSymbol() { return unicodeSymbol;}


}
