package com.company;

import com.company.MPNCheсkers.VersionChecker;
import com.company.TECChekers.TECChecker;
import com.company.TECChekers.TECCompressor;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Main {
    private static ArrayList<String> TECLogs;
    private static ArrayList<String> MPNLogs;

    /*
    * */
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string;

        do {//join
            manageLogsLists();

            for (String fileName : TECLogs)
                System.out.println(fileName);
            for (String fileName : MPNLogs)
                System.out.println(fileName);

          //  new Thread(new TECChecker(TECLogs)).start();
                     new Thread((new TECCompressor(TECLogs))).start();
               new Thread(new MPNChooser(MPNLogs)).start();
        //    new Thread(new VersionChecker(MPNLogs)).start();
            System.out.println(
                    "11 - Выход");
            string = reader.readLine();

    } while(!string.equals("11"));
        reader.close();
}

    public static void manageLogsLists() {

        File folder = new File("c:/Program Files/Lanit/AVIR/Logs");
        MPNLogs = new ArrayList();
        TECLogs = new ArrayList();
        String[] fileNames = folder.list();


        if (fileNames == null) {
            System.out.println("c:/Program Files/Lanit/AVIR/Logs not found");
            return; // не убирать
        }

        for (String fileName : fileNames)
            if (fileName.contains("MPN"))
                MPNLogs.add(fileName);
            else if (fileName.contains("TEC"))
                TECLogs.add(fileName);
    }
}


