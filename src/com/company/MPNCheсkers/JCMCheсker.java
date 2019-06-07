package com.company.MPNCheсkers;


import com.company.Abstract.FILEChecker;

import java.util.ArrayList;

public class JCMCheсker extends FILEChecker implements Runnable{


    public JCMCheсker(ArrayList<String> logs) {
        super(logs);
    }

    @Override
    public void defineErrorsAndOutputs(ArrayList<String> listOfErrors, ArrayList<String> listOfOutputs) {
        listOfErrors.add("OnNoteAccepted id = 2");
        listOfErrors.add("OnNoteAccepted id = 1");
        listOfErrors.add("Rejecting ID = 2");
        listOfErrors.add("Rejecting ID = 1");

        listOfOutputs.add("OnNoteAccepted id = 2");
        listOfOutputs.add("OnNoteAccepted id = 1");
        listOfOutputs.add("Rejecting ID = 2");
        listOfOutputs.add("Rejecting ID = 1");

        super.defineErrorsAndOutputs(listOfErrors, listOfOutputs);

    }

    @Override
    public void printCountsAndOutputs(String fileName, int[] errorsCounts) {
        ArrayList<String> listOfErrors = getListOfErrors();
        float countOfOnNoteAcceptedId1 = errorsCounts[listOfErrors.indexOf("OnNoteAccepted id = 1")];
        float countOfOnNoteAcceptedId2 = errorsCounts[listOfErrors.indexOf("OnNoteAccepted id = 2")];
        float difference;
        /////////////////////////////////////////////////////////////////////////////////
        super.printCountsAndOutputs(fileName, errorsCounts);
        //------------------------------------------------------------------
        if (countOfOnNoteAcceptedId1 > countOfOnNoteAcceptedId2) {
            difference = countOfOnNoteAcceptedId1/countOfOnNoteAcceptedId2;
            if (difference > 1.3)
                writeToLog("Купюоприемник ID = 2 простаивает очень долго");
        }
        else {
            difference = countOfOnNoteAcceptedId2/countOfOnNoteAcceptedId1;
            if (difference > 1.3)
                writeToLog("Купюоприемник ID = 1 простаивает очень долго");
        }

    }

    @Override
    public void run() {

        openFilesCountErrorsPrintOutputs();

    }
}
