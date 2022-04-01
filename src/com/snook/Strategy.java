package com.snook;

public class Strategy {
    public Double averageTurns;
    public Double averageProperties;
    public Double percetageIndianaAvenuePurchased;
    public Integer totalGames;

    public Strategy() {
        this.averageTurns = 0.0;
        this.averageProperties = 0.0;
        this.percetageIndianaAvenuePurchased = 0.0;
        this.totalGames = 0;
    }

    public Double getAverageTurns() {
        return averageTurns;
    }

    public void setAverageTurns(Double averageTurns) {
        this.averageTurns = averageTurns;
    }

    public void addAverageTurns(Double averageTurns) {
        this.averageTurns += averageTurns;
    }

    public Double getAverageProperties() {
        return averageProperties;
    }

    public void setAverageProperties(Double averageProperties) {
        this.averageProperties = averageProperties;
    }

    public void addAverageProperties(Double averageProperties) {
        this.averageProperties += averageProperties;
    }

    public Double getPercetageIndianaAvenuePurchased() {
        return percetageIndianaAvenuePurchased;
    }

    public void setPercetageIndianaAvenuePurchased(Double percetageIndianaAvenuePurchased) {
        this.percetageIndianaAvenuePurchased = percetageIndianaAvenuePurchased;
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
