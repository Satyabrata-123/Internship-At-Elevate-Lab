

import java.io.*;

public class task4file {
    public static void main(String args[]) {

        String filePath = "notes.txt";
        File file = new File(filePath);

        // Step 1: Create the file if it doesn't exist
        try {
            if (!file.exists()) {
                file.createNewFile();
            } else {
                System.out.println("File already created: " + file.getName());
            }
        } catch (IOException e) {
            System.out.println("Error occurred while creating the file: " + e.getMessage());
        }

        // Step 2: Write to the file
        try (FileWriter fw = new FileWriter(file)) {
            fw.write("My name is Satyabrata Mallik\n");
            fw.write("I attend this internship to grow my career\n");
        } catch (IOException e) {
            System.out.println("Error writing to the file: " + e.getMessage());
        }

        // Step 3: Read from the file
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            System.out.println("Reading notes from the file:");
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading: " + e.getMessage());
        }

        
    }
}
