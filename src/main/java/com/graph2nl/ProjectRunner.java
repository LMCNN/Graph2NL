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
        System.out.println("Usage:java -jar Graph2NL.jar (-h | -(e|z) -(v|g)(argument) -c(.json config))\n" +
                "\t\t\t\t-h\tPrint this help\n" +
                "\t\t\t\t-c\tUse .json config file\n" +
                "\t\t\t\t-e\tPrint out English result\n" +
                "\t\t\t\t-z\tPrint out Chinese result\n" +
                "\t\t\t\t-v\tUse .e.v file as argument\n" +
                "\t\t\t\t-g\tUse .gexf file as argument\n" +
                "\t\t\t\targument:For .e .v file is the directory path which contains those two files\n" +
                "         \t\t\t\tFor .gexf file is the filename\n" +
                "         \t\t\t\tFor .json file is the filename");
    }

    public static void main(String[] args){
        if (args.length == 0){
            usage();
            System.exit(0);
        }

        Digraph dg = new Digraph();
        char language = 'e';
        String config = null;
        List<String> fileNames = new ArrayList<>();

        Getopt g = new Getopt("Graph2NL", args, "c:v:g:zeh");
        int c;
        String arg;
        while ((c = g.getopt()) != -1) {
            switch(c) {
                case 'h':
                    usage();
                    System.exit(0);
                    break;
                case 'e':
                case 'z':
                    language = (char) c;
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
                    //ReadFromFile.ReadFromCSV(fileName[0], fileName[1], dg);
                    break;
                case '?':
                    break; // getopt() already printed an error
                default:
                    System.out.print("getopt() returned " + c + "\n");
            }
        }

        if (config != null){
            try {
                ReadFromFile.loadConfig(config, dg);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        if (fileNames.size() == 1){
            ReadFromFile.parseGEXF(fileNames.get(0), dg);
        }
        else {
            ReadFromFile.ReadFromCSV(fileNames.get(0), fileNames.get(1), dg);
        }

        dg.describe(language);
    }
}
