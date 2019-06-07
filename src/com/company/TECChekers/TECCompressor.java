package com.company.TECChekers;


import com.company.Abstract.IOHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class TECCompressor extends IOHelper implements Runnable {

    private HashMap<String, Integer> CountsOfErrors = new HashMap();//считается всегда и везде
    private ArrayList<String> listOfEchoes = new ArrayList();//анализируем везде и выводим сразу
    private ArrayList<String> listOfModeStart = new ArrayList();//если эти есть, то начинаем поиск ошибок для соответст режима
    private ArrayList<String> listOfModeEchoes = new ArrayList();//сразу выводим но только в режиме
    private ArrayList<String> listOfModeEnd = new ArrayList();//если это есть, то перестаем считать ошибки для текущего режима
    private ArrayList<String> Logs = new ArrayList();

    public TECCompressor(ArrayList<String> logs) {
        Logs = logs;
    }

    public void openFilesCompress() {

        defineLists(CountsOfErrors, listOfModeEnd, listOfModeEchoes, listOfModeStart, listOfEchoes);

        for (String fileName : Logs) {
            try {
                openFileCarefuly(fileName);
                createLog(fileName);
                compress(fileName);
                closeFiles(fileName);
            } catch (IOException e) {
                writeToLog("\n" + fileName + e.getMessage());
                //              e.printStackTrace();
            } catch (NullPointerException e) {
                writeToLog("\n" + fileName + " не найден при обработке");
                //           e.printStackTrace();
            }

        }
    }

    private void compress(String fileName) throws IOException, NullPointerException {
        BufferedReader fileForCheck = getFileForCheck();
        boolean killSwitch = false;
        turnCountsToZero();
        while (fileForCheck.ready()) {            // в этом цикле идет поиск ошибок и считаются счетчики

            String line = fileForCheck.readLine();

            for (HashMap.Entry i : CountsOfErrors.entrySet()) {
                String error = i.getKey().toString();
                int count = (int) i.getValue();
                if (line.contains(error))
                    CountsOfErrors.put(error, count + 1);
            }


            for (String error : listOfEchoes) {
                if (line.contains(error))
                    writeToLog(line);
            }

            if (killSwitch)
                for (String error : listOfModeEchoes) {
                    if (line.contains(error))
                        writeToLog(line);
                }

            for (String mode : listOfModeStart) {

                if (line.contains(mode)) {
                    killSwitch = true;
                    printCounts();
                    turnCountsToZero();
                    writeToLog(line);


                }
            }
            for (String mode : listOfModeEnd) {

                if (line.contains(mode)) {
                    killSwitch = false;
                    printCounts();
                    turnCountsToZero();
                    writeToLog(line);
                }
            }


        }
        printCounts();
    }

    public void turnCountsToZero() {
        CountsOfErrors.put("CASS_STATUS_CASSFULL", 0);
        CountsOfErrors.put("CASS_STATUS_CASSNO", 0);
        CountsOfErrors.put("CASS_STATUS_LEVEL", 0);
        CountsOfErrors.put("CASS_STATUS_UNKNOWN", 0);
        CountsOfErrors.put("ERROR_COUNTERS", 0);
        CountsOfErrors.put("INTERNAL_ERROR", 0);
        CountsOfErrors.put("MEI_STATUS_CASSFULL", 0);
        CountsOfErrors.put("MEI_STATUS_CASSFULL_JAM", 0);
        CountsOfErrors.put("MEI_STATUS_CASSNO", 0);
        CountsOfErrors.put("MEI_STATUS_ERROR", 0);
        CountsOfErrors.put("MEI_STATUS_FAILURE", 0);
        CountsOfErrors.put("MEI_STATUS_INVALIDCOMMAND", 0);
        CountsOfErrors.put("MEI_STATUS_JAMMED", 0);
        CountsOfErrors.put("MEI_STATUS_OPENPORT", 0);
        CountsOfErrors.put("MEI_STATUS_PAUSE", 0);
        CountsOfErrors.put("POSITION_NOT_EMPTY", 0);
        CountsOfErrors.put("STATNOTEMPTY", 0);
        CountsOfErrors.put("STATNOTEMPTY_REJ", 0);
        CountsOfErrors.put("Cheated", 0);
        CountsOfErrors.put("Exception", 0);
    }

    public void printCounts() {
        for (HashMap.Entry i : CountsOfErrors.entrySet()) {
            int count = (int) i.getValue();
            if (count > 0)
                writeToLog(i.getKey() + " : \t" + i.getValue());
        }
    }

    public void defineLists(HashMap<String, Integer> CountsOfErrors,
                            ArrayList<String> listOfModeEnd,
                            ArrayList<String> listOfModeEchoes,
                            ArrayList<String> listOfModeStart,
                            ArrayList<String> listOfEchoes) {

        turnCountsToZero();

        /////////////////////////////////////////////////

        listOfEchoes.add("+STARTING+");
        listOfEchoes.add("+STARTED+");
        listOfEchoes.add("+Starting+");
        listOfEchoes.add("+EXIT END+");
        listOfEchoes.add("+EXIT+");

        /////////////////////////////////////////////////

        listOfModeStart.add("CashIn start");
        listOfModeStart.add("Command = OnlineEncashment");

        ///////////////////////////////////////////////////

        listOfModeEnd.add("CashIn end");
        listOfModeEnd.add("rc = NoError");
        listOfModeEnd.add("rc = InternalError");
        listOfModeEnd.add("rc = Cancelled");

        //////////////////////////////////////////////////

        listOfModeEchoes.add(" = Timeout");
        listOfModeEchoes.add(" = Error");
        listOfModeEchoes.add(" = Error");
        listOfModeEchoes.add("Tools|Status = SUSPEND");
        listOfModeEchoes.add("Format String can be only");

    }

    @Override
    public void run() {
        openFilesCompress();
    }
}
