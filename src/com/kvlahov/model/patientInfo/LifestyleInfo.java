/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov.model.patientInfo;

/**
 *
 * @author lordo
 */
public class LifestyleInfo {    
    private boolean isVegetarian;
    private boolean isSmoker;
    private int averageCigarettesPerDay;
    
    private boolean consumesAlcohol;
    private int averageDrinksPerDay;
    
    private String usesStimulants;
    private int coffeineDrinkPerDay;
    private int softDrinkPerDay;
    private String eatingHabits;

    public boolean getIsVegetarian() {
        return isVegetarian;
    }

    public void setIsVegetarian(boolean isVegetarian) {
        this.isVegetarian = isVegetarian;
    }

    public boolean getIsSmoker() {
        return isSmoker;
    }

    public void setIsSmoker(boolean isSmoker) {
        this.isSmoker = isSmoker;
    }

    public int getAverageCigarettesPerDay() {
        return averageCigarettesPerDay;
    }

    public void setAverageCigarettesPerDay(int averageCigarettesPerDay) {
        this.averageCigarettesPerDay = averageCigarettesPerDay;
    }

    public boolean getConsumesAlcohol() {
        return consumesAlcohol;
    }

    public void setConsumesAlcohol(boolean consumesAlcohol) {
        this.consumesAlcohol = consumesAlcohol;
    }

    public int getAverageDrinksPerDay() {
        return averageDrinksPerDay;
    }

    public void setAverageDrinksPerDay(int averageDrinksPerDay) {
        this.averageDrinksPerDay = averageDrinksPerDay;
    }

    public String getUsesStimulants() {
        return usesStimulants;
    }

    public void setUsesStimulants(String usesStimulants) {
        this.usesStimulants = usesStimulants;
    }

    public int getCoffeineDrinkPerDay() {
        return coffeineDrinkPerDay;
    }

    public void setCoffeineDrinkPerDay(int coffeineDrinkPerDay) {
        this.coffeineDrinkPerDay = coffeineDrinkPerDay;
    }

    public int getSoftDrinkPerDay() {
        return softDrinkPerDay;
    }

    public void setSoftDrinkPerDay(int softDrinkPerDay) {
        this.softDrinkPerDay = softDrinkPerDay;
    }

    public String getEatingHabits() {
        return eatingHabits;
    }

    public void setEatingHabits(String eatingHabits) {
        this.eatingHabits = eatingHabits;
    }

    @Override
    public String toString() {
        return "LifestyleInfo{" +
                "\nisVegetarian=" + isVegetarian + 
                "\nisSmoker=" + isSmoker + 
                "\naverageCigarettesPerDay=" + averageCigarettesPerDay +
                "\nconsumesAlcohol=" + consumesAlcohol +
                "\naverageDrinksPerDay=" + averageDrinksPerDay + 
                "\nusesStimulants=" + usesStimulants + 
                "\ncoffeineDrinkPerDay=" + coffeineDrinkPerDay + 
                "\nsoftDrinkPerDay=" + softDrinkPerDay + 
                "\neatingHabits=" + eatingHabits + '}';
    }
    
    
    
}
