package Model;

import java.io.FileWriter;
import java.io.IOException;

public class ParamsSaver {

    //Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";


    public static void deleteFile(){
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter("src/Model/Ressources/settings.csv", false);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void write(String name, String value) {

        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter("src/Model/Ressources/settings.csv", true);

            fileWriter.append(name);
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(value);
            fileWriter.append(NEW_LINE_SEPARATOR);

        } catch (Exception e) {
            System.out.println("Error in ParamsSaver !");
            e.printStackTrace();
        } finally {

            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !");
                e.printStackTrace();
            }

        }
    }
}