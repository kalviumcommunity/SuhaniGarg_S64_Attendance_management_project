package com.school;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class FileStorageService {
    
    /**
     * Saves a list of Storable objects to a text file
     * @param items List of objects implementing Storable interface
     * @param filename Name of the file to save to
     */
    public static void saveData(List<? extends Storable> items, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Storable item : items) {
                writer.println(item.toDataString());
            }
            System.out.println("✅ Successfully saved " + items.size() + " items to " + filename);
        } catch (IOException e) {
            System.err.println("❌ Error saving data to " + filename + ": " + e.getMessage());
        }
    }
}