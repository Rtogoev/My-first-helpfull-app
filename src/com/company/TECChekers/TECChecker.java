package com.company.TECChekers;

import com.company.Abstract.FILEChecker;

import java.io.IOException;
import java.util.ArrayList;

public class TECChecker extends FILEChecker implements Runnable {

    public TECChecker(ArrayList<String> logs) {
        super(logs);
    }

    @Override
    public void defineErrorsAndOutputs(ArrayList<String> listOfErrors, ArrayList<String> listOfOutputs) {
        listOfErrors.add("+Starting+");
        listOfErrors.add("+STARTING+");
        listOfErrors.add("+STARTED+");
        listOfErrors.add("+EXIT END+");
        listOfErrors.add("+EXIT+");
        listOfErrors.add("CashIn start");
        listOfErrors.add("CashIn end");
        listOfErrors.add("Exception");
        listOfErrors.add(" = Timeout");
        listOfErrors.add(" = Error");
        listOfErrors.add("RestoreManager|Command = OnlineEncashment");


        listOfOutputs.add("Starting");
        listOfOutputs.add("STARTING");
        listOfOutputs.add("STARTED");
        listOfOutputs.add("EXIT END");
        listOfOutputs.add("EXIT");
        listOfOutputs.add("CashIn start");
        listOfOutputs.add("CashIn end");
        listOfOutputs.add("Exception");
        listOfOutputs.add("Сбой авторизации:  = Timeout");
        listOfOutputs.add("Сбой авторизации:  = Error");
        listOfOutputs.add("Начало инкассации");

    }

    @Override
    public void run() {

        openFilesCountErrorsPrintOutputs();
    }


    @Override
    public void printCountsAndOutputs(String fileName, int[] errorsCounts) {
        ArrayList<String> listOfErrors = getListOfErrors();
        int countOfStarting = errorsCounts[listOfErrors.indexOf("+Starting+")];
        int countOfSTARTING = errorsCounts[listOfErrors.indexOf("+STARTING+")];
        int difference;
        /////////////////////////////////////////////////////////////////////////////////
        super.printCountsAndOutputs(fileName, errorsCounts);
        //------------------------------------------------------------------
        if (countOfStarting > 0) {
            difference = errorsCounts[listOfErrors.indexOf("+Starting+")] - errorsCounts[listOfErrors.indexOf("+EXIT END+")];
            if (difference != 0)
                writeToLog("Перезагрузка устройства " + difference + " раз");
            if (errorsCounts[listOfErrors.indexOf("+STARTED+")] != countOfStarting)
                writeToLog("Аварийное выключение");
        }
        //------------------------------------------------------------------
        if (countOfSTARTING > 0) {
            difference = errorsCounts[listOfErrors.indexOf("+STARTING+")] - errorsCounts[listOfErrors.indexOf("+EXIT END+")];
            if (difference != 0)
                writeToLog("Перезагрузка устройства " + difference + " раз");
            if (errorsCounts[listOfErrors.indexOf("+STARTED+")] != countOfSTARTING)
                writeToLog("Аварийное выключение");
        }
        //------------------------------------------------------------------
        difference = errorsCounts[listOfErrors.indexOf("CashIn start")] - errorsCounts[listOfErrors.indexOf("CashIn end")];
        if (difference != 0)
            writeToLog("Внесение прервано " + difference + " раз");
        //------------------------------------------------------------------


    }
}
