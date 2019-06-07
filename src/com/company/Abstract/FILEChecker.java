package com.company.Abstract;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * типичный проверя\льщик текстового файла имеет типичный набор методов как в этом файле
 */
public class FILEChecker extends IOHelper{

    private ArrayList<String> listOfErrors = new ArrayList();
    private ArrayList<String> listOfOutputs = new ArrayList();
    private ArrayList<String> Logs = new ArrayList();



    public FILEChecker(ArrayList<String> logs) {
        Logs = logs;
    }


    public void openFilesCountErrorsPrintOutputs() {

        defineErrorsAndOutputs(listOfErrors, listOfOutputs);

        for (String fileName : Logs) {
            int[] errorsCounts = new int[listOfErrors.size()];
            try {
                openFileCarefuly(fileName);
                createLog(fileName);
                countErrors(errorsCounts);
                printCountsAndOutputs(fileName, errorsCounts);
                closeFiles(fileName);
            } catch (IOException e) {
                System.out.println("\n" + fileName + e.getMessage());
                //              e.printStackTrace();
            } catch (NullPointerException e) {
                System.out.println("\n" + fileName + " не найден при обработке");
                //           e.printStackTrace();
            }

        }
    }



    public void countErrors(int[] errorsCounts) throws IOException, NullPointerException {

        BufferedReader fileForCheck = getFileForCheck();
        while (fileForCheck.ready()) {            // в этом цикле идет поиск ошибок и считаются счетчики

            String line = fileForCheck.readLine();

            for (int i = 0; i < listOfErrors.size(); i++) {

                if (line.contains(listOfErrors.get(i))) {
                    errorsCounts[i] = errorsCounts[i] + 1;
                }
            }
        }
    }





    public void defineErrorsAndOutputs(ArrayList<String> listOfErrors, ArrayList<String> listOfOutputs) {
        listOfErrors.add("CASHIN_END");
        listOfErrors.add("CASS_STATUS_CASSFULL");
        listOfErrors.add("CASS_STATUS_CASSNO");
        listOfErrors.add("CASS_STATUS_LEVEL");
        listOfErrors.add("CASS_STATUS_UNKNOWN");
        listOfErrors.add("ERROR_COUNTERS");
        listOfErrors.add("INTERNAL_ERROR");
        listOfErrors.add("MEI_STATUS_CASSFULL");
        listOfErrors.add("MEI_STATUS_CASSFULL_JAM");
        listOfErrors.add("MEI_STATUS_CASSNO");
        listOfErrors.add("MEI_STATUS_ERROR");
        listOfErrors.add("MEI_STATUS_FAILURE");
        listOfErrors.add("MEI_STATUS_INVALIDCOMMAND");
        listOfErrors.add("MEI_STATUS_JAMMED");
        listOfErrors.add("MEI_STATUS_OPENPORT");
        listOfErrors.add("MEI_STATUS_PAUSE");
        listOfErrors.add("POSITION_NOT_EMPTY");
        listOfErrors.add("STATNOTEMPTY");
        listOfErrors.add("STATNOTEMPTY_REJ");
        listOfErrors.add("Cheated");
        listOfErrors.add("Exception");
        listOfErrors.add("Wrong CRC");

        listOfOutputs.add("CASHIN_END");
        listOfOutputs.add("CASS_STATUS_CASSFULL");
        listOfOutputs.add("CASS_STATUS_CASSNO");
        listOfOutputs.add("CASS_STATUS_LEVEL");
        listOfOutputs.add("CASS_STATUS_UNKNOWN");
        listOfOutputs.add("ERROR_COUNTERS");
        listOfOutputs.add("INTERNAL_ERROR");
        listOfOutputs.add("MEI_STATUS_CASSFULL");
        listOfOutputs.add("MEI_STATUS_CASSFULL_JAM");
        listOfOutputs.add("MEI_STATUS_CASSNO");
        listOfOutputs.add("MEI_STATUS_ERROR");
        listOfOutputs.add("MEI_STATUS_FAILURE");
        listOfOutputs.add("MEI_STATUS_INVALIDCOMMAND");
        listOfOutputs.add("MEI_STATUS_JAMMED");
        listOfOutputs.add("MEI_STATUS_OPENPORT");
        listOfOutputs.add("MEI_STATUS_PAUSE");
        listOfOutputs.add("POSITION_NOT_EMPTY");
        listOfOutputs.add("STATNOTEMPTY");
        listOfOutputs.add("STATNOTEMPTY_REJ");
        listOfOutputs.add("Купюра отбракована со статусом Cheated. Возможно она попала в кассету, но не была учтена в сумме транзакции");
        listOfOutputs.add("Exception");
        listOfOutputs.add("Wrong CRC");
    }



    public void printCountsAndOutputs(String fileName, int[] errorsCounts) {
        for (int i = 0; i < listOfErrors.size(); i++)
            if (errorsCounts[i] > 0)
               writeToLog(listOfOutputs.get(i) + ":\t" + errorsCounts[i]);

    }

    public ArrayList<String> getLogs() {
        return Logs;
    }


    public ArrayList<String> getListOfErrors() {
        return listOfErrors;
    }

}