package com.laxmi.inventory.management.inventory.Model;

public class Outfit {
    private String dayOfWeek;
    private String outfitDescription;
    private String beautifulNote;
    private String weather;
    private String occasion;

    public Outfit(String dayOfWeek, String outfitDescription, String beautifulNote, String weather, String occasion) {
        this.dayOfWeek = dayOfWeek;
        this.outfitDescription = outfitDescription;
        this.beautifulNote = beautifulNote;
        this.weather = weather;
        this.occasion = occasion;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public String getOutfitDescription() {
        return outfitDescription;
    }

    public String getBeautifulNote() {
        return beautifulNote;
    }

    public String getWeather() {
        return weather;
    }

    public String getOccasion() {
        return occasion;
    }

    @Override
    public String toString() {
        return "Day: " + dayOfWeek
                + "\nOutfit: " + outfitDescription
                + "\nBeautiful Note: " + beautifulNote
                + "\nWeather: " + weather
                + "\nOccasion: " + occasion
                + "\n";
    }
}
