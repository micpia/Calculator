package calculator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;


public class CalculatorApp {

    private static LinkedHashMap<String, Integer> readFromFile(String filePath) {

        LinkedHashMap<String, Integer> list = new LinkedHashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] pair = line.split(" ");
                list.put(pair[0], Integer.valueOf(pair[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    static Integer process(LinkedHashMap<String, Integer> list) {

        Integer result = list.get("apply");
        list.remove("apply");

        for(Map.Entry<String, Integer> entry : list.entrySet()) {
            switch (entry.getKey()) {
                case "add":
                {
                    result += entry.getValue();
                    break;
                }
                case "subtract":
                {
                    result -= entry.getValue();
                    break;
                }
                case "multiply":
                {
                    result *= entry.getValue();
                    break;
                }
                case "divide":
                {
                    if(entry.getValue() == 0) {
                        System.out.println("No dividing by 0!!!");
                        break;
                    }
                    result /= entry.getValue();
                    break;
                }
                default:
                {
                    break;
                }
            }
        }
        return  result;
    }

    public static void main(String[] args) {

        //file name is hardcoded as there was no indication that application should access other files
        String path = "f1.txt";

        Integer result = process(readFromFile(path));

        System.out.println(result);

    }
}
