package com.project.utils;

import com.project.models.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {
    @org.testng.annotations.DataProvider
    public Iterator<Object[]> addNewContactFromCsvFile() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contact1.csv")));

        String line = reader.readLine();
        while (line!=null) {

            String[] split = line.split(",");
            list.add(new Object[]{new User().setEmail(split[0]).setPassword(split[1])});
            line = reader.readLine();
        }

        return list.iterator();
    }
}
