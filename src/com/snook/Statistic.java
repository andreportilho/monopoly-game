package com.snook;

public class Statistic {
    private Double averageTurns;
    private Integer totalPurchasedProperties;
    private Integer totalIndianaAvenuePurchased;
    private Integer totalGames;

    public Statistic() {
        this.averageTurns = 0.0;
        this.totalPurchasedProperties = 0;
        this.totalIndianaAvenuePurchased = 0;
        this.totalGames = 0;
    }

    public Double getAverageTurns() {
        return averageTurns;
    }

    public void addAverageTurns(Double averageTurns) {
        this.averageTurns += averageTurns;
    }

    public Integer getTotalPurchasedProperties() {
        return totalPurchasedProperties;
    }

    public void addAverageProperties(Integer averageProperties) {
        this.totalPurchasedProperties += averageProperties;
    }

    public void addTotalIndianaAvenuePurchased() {
        this.totalIndianaAvenuePurchased += 1;
    }

    public Integer getTotalIndianaAvenuePurchased() {
        return totalIndianaAvenuePurchased;
    }

    public Integer getTotalGames() {
        return totalGames;
    }

    public void setTotalGames(Integer totalGames) {
        this.totalGames = totalGames;
    }

    public void addTotalGames() {
        this.totalGames += 1;
    }
}
