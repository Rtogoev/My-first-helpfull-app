package com.company;

import com.company.Abstract.FILEChecker;
import com.company.MPNCheсkers.CCCheсker;
import com.company.MPNCheсkers.GLORYCheker;
import com.company.MPNCheсkers.JCMCheсker;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class MPNChooser extends FILEChecker implements Runnable{
    public MPNChooser(ArrayList<String> logs) {
        super(logs);
    }


    public void run() {

        ArrayList<String> Logs = getLogs();
        for (String fileName : Logs) {

            try {
                openFileCarefuly(fileName);
                createLog(fileName);
                chooseMPN(Logs);
                closeFiles(fileName);
                return;

            } catch (FileNotFoundException e) {
                System.out.println("\n" + fileName + " can't read");
                //      e.printStackTrace();
                continue;
            } catch (IOException e) {
                System.out.println("\n" + fileName + " decompress ERROR");
                //         e.printStackTrace();
            } catch (NullPointerException e) {
                System.out.println("\n" + fileName + " не найден при обработке");
                //          e.printStackTrace();
            }

        }
    }

    void chooseMPN(ArrayList<String> Logs) throws IOException, NullPointerException {
        BufferedReader fileForCheck = getFileForCheck();
        while (fileForCheck.ready()) {
            String line = fileForCheck.readLine();
          /*  if (line.contains("H : 02 08 ")) {
                System.out.println("MEI");
                new Thread(new JCMCheсker()).start();
                return;*/
            if (line.contains(" FC ")) {
                System.out.println("JCM");
                new Thread(new JCMCheсker(Logs)).start();
                return;
            } else if (line.contains("CCNET")) {
                System.out.println("CashCode");
                new Thread(new CCCheсker(Logs)).start();
                return;
            } else if (line.contains("H : 10 02")) {
                System.out.println("GLORY");
                new Thread(new GLORYCheker(Logs)).start();
                return;
            }
        }
    }
}