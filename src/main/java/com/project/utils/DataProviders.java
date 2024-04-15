package com.project.utils;

import com.project.models.NewUser;
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
    public Iterator<Object[]> addNewUserCsvFile() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contact2.csv")));

        String line = reader.readLine();
        while (line!=null) {

            String[] split = line.split(",");
            list.add(new Object[]{new NewUser().setFirstName(split[0]).setLastName(split[1]).setEmail(split[2]).setPassword(split[3]).setConfirmPassword(split[4])});
            line = reader.readLine();
        }

        return list.iterator();
    }
}
