package Model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ParamsLoader {

    String csvFile = "src/Model/Ressources/settings.csv";
    BufferedReader br = null;
    String line = "";
    String cvsSplitBy = ",";

    public ParamsLoader() {


    }

    public String[][] read(){

        String[] param;
        String[][] allParams = null;
        try {

            br = new BufferedReader(new FileReader(csvFile));
            int x = 0;
            int y = 0;
            while ((line = br.readLine()) != null) {

                // use comma as separator
                param = line.split(cvsSplitBy);

                allParams[x][y] = param[0];
                allParams[x][y+1] = param[1];
                x++;

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return allParams;
    }

}