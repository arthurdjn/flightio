package com.example.flightio.engine.save;


import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

import com.example.flightio.engine.coordinates.Point;

public class Export {


    public static void write(ArrayList<String> thingsToWrite, String filename) {
        // Write a file
        Path path = Paths.get(filename);
        String filePath = "D:\\home\\Arthur\\Documents\\Informatique\\Java\\" + filename; // chemin absolu vers le fichier
        Path logFile = Paths.get(filePath);
        if (!Files.exists(logFile)) { // si le fichier n’existe pas on le cree
            try {
                Files.createFile(logFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (BufferedWriter writer = Files.newBufferedWriter(logFile,
                StandardCharsets.UTF_8, StandardOpenOption.WRITE)) { // buffer en ecriture (ecrase l’existant), encodage UTF8
            for (int i = 0; i < thingsToWrite.size(); i++) {
                writer.write(thingsToWrite.get(i) + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void writeLitchi(ArrayList<Point> thingsToWrite, String filename) {
        // Write a file
        //Path path = Paths.get(filename);
        String filePath = "D:\\home\\Arthur\\Documents\\Informatique\\Java\\" + filename; // chemin absolu vers le fichier
        Path logFile = Paths.get(filePath);
        if (!Files.exists(logFile)) { // si le fichier n’existe pas on le cree
            try {
                Files.createFile(logFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (BufferedWriter writer = Files.newBufferedWriter(logFile,
                StandardCharsets.UTF_8, StandardOpenOption.WRITE)) { // buffer en ecriture (ecrase l’existant), encodage UTF8
            writer.write(Litchi.litchiHeader() + "\n");
            for (int i = 0; i < thingsToWrite.size(); i++) {
                Litchi pointLitchi = new Litchi(thingsToWrite.get(i));
                writer.write(pointLitchi.toString() + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }






}