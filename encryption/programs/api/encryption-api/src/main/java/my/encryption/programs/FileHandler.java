package my.encryption.programs;

import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FileHandler {
    public static boolean isFilePath(String input) {
        return input.endsWith(".txt") || input.endsWith(".dat");
    }

    public static void encryptFiles(String filePath, int choice) {
        ExecutorService executor = Executors.newFixedThreadPool(4);

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                final String chunk = line;
                executor.submit(() -> {
                    String encryptedChunk = EncryptionUtil.encryptData(chunk, choice);
                    System.out.println("Encrypted chunk: " + encryptedChunk);
                    // Placeholder: write encryptedChunk back to file or other output
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void encryptMessage(String message, int choice) {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        String[] chunks = message.split("(?<=\\G.{64})");

        for (String chunk : chunks) {
            executor.submit(() -> {
                String encryptedChunk = EncryptionUtil.encryptData(chunk, choice);
                System.out.println("Encrypted chunk: " + encryptedChunk);
            });
        }

        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
