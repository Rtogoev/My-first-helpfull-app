package com.company.Abstract;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class IOHelper {
    private BufferedReader fileForCheck = null;
    private ZipFile zipFileForCheck = null;
    private BufferedWriter output = null;

    public BufferedReader getFileForCheck() {
        return fileForCheck;
    }

    public void createLog(String fileName) {
        try {
            output = new BufferedWriter(new FileWriter("c:/Temp/" + fileName.substring(0,fileName.indexOf("."))+".txt"));
        } catch (IOException e) {
            System.out.println("Проблема с созданием лог-файла");
            //e.printStackTrace();
        }
    }
/*
    	//Here true is to append the content to file
    	FileWriter fw = new FileWriter(file,true);
    	//BufferedWriter writer give better performance
    	BufferedWriter bw = new BufferedWriter(fw);
    	bw.write(content);
    	//Closing BufferedWriter Stream
    	bw.close();

*/
    public void writeToLog(String string) {
        try {
            output.write(string);
            output.newLine();
        } catch (IOException e) {
            System.out.println("Проблема с записью в файл");
            // e.printStackTrace();
        }

    }

    public void openFileCarefuly(String fileName) throws IOException {


        try {
            createBufferOpenStream(fileName);
        } catch (IOException e) {
            closeFiles(fileName);
            //          e.printStackTrace();
        } catch (NullPointerException e) {
            System.out.println("\n" + fileName + " не найден при открытии");
            //          e.printStackTrace();
        }


    }

    public void createBufferOpenStream(String fileName) throws IOException {


        if (fileName.contains(".zip")) {

            zipFileForCheck = new ZipFile("c:/Program Files/Lanit/AVIR/Logs/" + fileName);
            ZipEntry zipEntry = zipFileForCheck.entries().nextElement();
            fileForCheck = new BufferedReader(new InputStreamReader(zipFileForCheck.getInputStream(zipEntry)));
        } else
            fileForCheck = new BufferedReader(new FileReader("c:/Program Files/Lanit/AVIR/Logs/" + fileName));
    }

    public void closeFiles(String fileName) throws IOException {
        try {
            fileForCheck.close();
            output.close();
        } catch (NullPointerException e) {

            System.out.println("\n" + fileName + " не найден при закрытии");
            //          e.printStackTrace();
        }


        try {
            zipFileForCheck.close();
        } catch (NullPointerException e) {

            System.out.println("\n" + fileName + " не является архивом");
            //      e.printStackTrace();
        }
    }

}
