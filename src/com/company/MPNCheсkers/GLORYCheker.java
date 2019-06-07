package com.company.MPNCheсkers;

import com.company.Abstract.FILEChecker;

import java.util.ArrayList;

public class GLORYCheker extends FILEChecker implements Runnable{

    public GLORYCheker(ArrayList<String> logs) {
        super(logs);
    }

    @Override
    public void run() {
        System.out.println("!!GLORY!!");

        openFilesCountErrorsPrintOutputs();
    }
}
