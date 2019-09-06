package com.graph2nl;

import gnu.getopt.Getopt;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * This class contains the main method to run this project
 *
 * author: Mingchi Li
 * date: 2019.8.12
 */
public class ProjectRunner {
    public static void usage(){
        System.out.println("Usage: java -jar Graph2NL.jar [-h] [-v <directory> | -g <fileName>] [-j]\n\n" +
                "\t-h                  Print this help\n\n" +
//                "\t-c <fileName>       Use .json config file\n\n" +
                "\t-v <directory>      Use .e.v file as input file\n\n" +
                "\t-g <fileName>       Use .gexf file as input file\n\n" +
                "\t-j                  Convert the graph to json") ;
    }

    public static void main(String[] args){
        if (args.length == 0){
            usage();
            System.exit(0);
        }

        Digraph dg = new Digraph();
        String config = null;
        List<String> fileNames = new ArrayList<>();
        boolean getJson = false;

        //parse options and their argument
        Getopt g = new Getopt("Graph2NL", args, "c:v:g:hj");
        int c;
        String arg;
        while ((c = g.getopt()) != -1) {
            switch(c) {
                case 'h':
                    usage();
                    System.exit(0);
                    break;
                case 'c':
                    config = g.getOptarg();
                    break;
                case 'g':
                    fileNames.add(g.getOptarg());
                    break;
                case 'v':
                    File folder = new File(g.getOptarg());
                    File[] listOfFiles = folder.listFiles();
                    String[] fileName = new String[2];
                    for (int i = 0; i < listOfFiles.length; i++) {
                        if (listOfFiles[i].isFile()) {
                            String temp = listOfFiles[i].getName();
                            temp = temp.substring(temp.length() - 2);
                            fileNames.add("");
                            fileNames.add("");
                            if (temp.equals(".v")) fileNames.set(0, g.getOptarg() + "/" + listOfFiles[i].getName());
                            if (temp.equals(".e")) fileNames.set(1, g.getOptarg() + "/" + listOfFiles[i].getName());
                        }
                    }
                    break;
                case 'j':
                    getJson = true;
                    break;
                case '?':
                    break; // getopt() already printed an error
                default:
                    System.out.print("getopt() returned " + c + "\n");
            }
        }

        //load config file
        if (config != null){
            try {
                ReadFromFile.loadConfig(config, dg);
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
        }

        //load the graph
        if (fileNames.size() == 1){
            ReadFromFile.parseGEXF(fileNames.get(0), dg);
        }
        else {
            ReadFromFile.ReadFromCSV(fileNames.get(0), fileNames.get(1), dg);
        }

        if (getJson) {
            System.out.print(dg.getJson());
        }
        else {
            //describe the graph
            dg.describe();
        }

    }
}
