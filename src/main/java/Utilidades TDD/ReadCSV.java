package Guru99;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadCSV {
    public static void main(String[] args) {
        ReadCSV readCSV = new ReadCSV();
        readCSV.parseFile("dada.csv");
    }

    private static final String CSV_SEPARATOR = ",(?=(?:[^\"]\"[^\"]\")[^\"]$)";
    public List<String[]> parseFile(String fileName) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            br.readLine(); // skip header;
            String line = br.readLine();
            List<String[]> lines = new ArrayList();
            while (line != null) {
                //System.out.println(line.toString());
                lines.add(line.split(CSV_SEPARATOR));
                line = br.readLine();
            }
            return lines;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
