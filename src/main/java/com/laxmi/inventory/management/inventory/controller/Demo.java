package com.laxmi.inventory.management.inventory.controller;

import com.laxmi.inventory.management.inventory.Model.Outfit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/outfit")
public class Demo {


    @GetMapping("all")
    private List<Outfit> generateOutfits() {
        //List<Outfit> outfits = generateOutfits();
        return generateOutfits1();
    }


    public static List<Outfit> generateOutfits1() {
        ArrayList<Outfit> outfits = new ArrayList<>();
        Set<String> uniqueOutfits = new HashSet<>(); // To store unique outfits

        String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        String[] outfitsDescriptions = {
                "Casual jeans and t-shirt",
                "Formal business attire",
                "Sporty tracksuit",
                "Elegant dress",
                "Comfy sweater and leggings",
                "Beachwear",
                "Relaxed pajamas",
                // Add more outfit options here if desired
        };
        String[] beautifulNotes = {
                "Feel confident and comfortable all day!",
                "Impress in the office with this professional look.",
                "Stay active and ready for any sports activities.",
                "Be the center of attention at the event tonight!",
                "Snuggle up with this cozy outfit.",
                "Enjoy the sun and sand with style.",
                "Relax and unwind with these comfy pajamas.",
                // Add more beautiful notes here if desired
        };
        String[] weatherOptions = {"Sunny", "Rainy", "Cloudy", "Snowy"};
        String[] occasionOptions = {"Work", "Party", "Exercise", "Wedding", "Casual", "Vacation"};

        int numberOfDays = 10; // You can change this to generate outfits for a different number of days

        int outfitCount = 0;

        while (outfitCount < numberOfDays) {
            String dayOfWeek = daysOfWeek[outfitCount % daysOfWeek.length];
            String outfitDescription = outfitsDescriptions[outfitCount % outfitsDescriptions.length];
            String beautifulNote = beautifulNotes[outfitCount % beautifulNotes.length];
            String weather = weatherOptions[outfitCount % weatherOptions.length];
            String occasion = occasionOptions[outfitCount % occasionOptions.length];

            // Generate a unique outfit key using outfit description and weather
            String outfitKey = outfitDescription + "-" + weather;

            // Check if the outfit is unique; if yes, add it to the list and set
            if (!uniqueOutfits.contains(outfitKey)) {
                outfits.add(new Outfit(dayOfWeek, outfitDescription, beautifulNote, weather, occasion));
                uniqueOutfits.add(outfitKey);
                outfitCount++;
            }
        }

        return outfits;
    }


}
