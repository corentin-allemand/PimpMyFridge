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
        String[][] allParams = new String [3][2];
        try {

            br = new BufferedReader(new FileReader(csvFile));
            int x = 0;

            while ((line = br.readLine()) != null) {

                param = line.split(cvsSplitBy);

                allParams[x][0] = param[0];
                allParams[x][1] = param[1];
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