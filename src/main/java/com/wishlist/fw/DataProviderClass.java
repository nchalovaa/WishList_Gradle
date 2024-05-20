package com.wishlist.fw;

//import com.opencsv.CSVReader;
//import com.opencsv.exceptions.CsvValidationException;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderClass {

    //    @DataProvider
//    public Iterator<Object[]> loginNewUserFromCsvFile() throws IOException {
//        List<Object[]> list = new ArrayList<>();
//        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/UserDataLogin.csv")));
//
//        String line = reader.readLine();
//        while (line != null) {
//            String[] data = line.split(",");
//            list.add(new Object[]{new UserLogin(data[0],data[1])});
//                  // .setEmail(split[0]).s});
//        }
//        line = reader.readLine();
//        return list.iterator();
//    }
//    private Object[][] readDataFromCSV(String fileName) {
//        String filePath = "./src/test/resources/csv/" + fileName;
//        List<Object[]> data = new ArrayList<>();
//        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
//            String[] line;
//            while ((line = reader.readNext()) != null) {
//                data.add(line);
//            }
//        } catch (IOException | CsvValidationException e) {
//            throw new RuntimeException(e);
//        }
//        return data.toArray(new Object[data.size()][]);
//    }
//
//    @DataProvider(name = "validLoginData")
//    public Object[][] getValidLoginData() {
//        return readDataFromCSV("LoginValidData.csv");
//    }
//
//    @DataProvider(name = "iNvalidLoginData")
//    public Object[][] getInValidLoginData() {
//        return readDataFromCSV("LoginValidData.csv");
//    }
}