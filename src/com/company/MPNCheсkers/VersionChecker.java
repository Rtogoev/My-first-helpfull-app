package com.company.MPNCheсkers;

import com.company.Abstract.FILEChecker;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class VersionChecker extends FILEChecker implements Runnable {

    public VersionChecker(ArrayList<String> logs) {
        super(logs);
    }

    @Override
    public void run() {
        ArrayList<String> Logs = getLogs();
        for (String fileName : Logs) {
            HashSet<String> versionsOfOneDay = new HashSet();
            try {
                openFileCarefuly(fileName);
                createLog(fileName);
                findVersions(fileName, versionsOfOneDay);
                printVersions(fileName, versionsOfOneDay);
                closeFiles(fileName);
            } catch (IOException e) {
                System.out.println("\n" + fileName + e.getMessage());
                //        e.printStackTrace();
            } catch (IndexOutOfBoundsException e) {
                System.out.println("\n" + fileName + " нет логирования прошивки");
                //         e.printStackTrace();
            } catch (NullPointerException e) {
                System.out.println("\n" + fileName + " не найден при обработке");
                //             e.printStackTrace();
            }

        }
    }


    void findVersions(String fileName, HashSet<String> versionsOfOneDay) throws IOException, IndexOutOfBoundsException, NullPointerException {
        BufferedReader fileForCheck = getFileForCheck();

        while (fileForCheck.ready()) {

            String line = fileForCheck.readLine();
            if (line.contains("Ver info ID")) {
                versionsOfOneDay.add(line.substring(line.indexOf("Ver") + 23));
            }
        }

    }

    private void printVersions(String fileName, HashSet<String> versionsOfOneDay)  throws NullPointerException{
        if (versionsOfOneDay.isEmpty())
            throw new IndexOutOfBoundsException();
        for (String version : versionsOfOneDay)
            writeToLog(version);

    }
}

