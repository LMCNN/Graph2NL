package com.graph2nl;

import gnu.getopt.Getopt;

import java.io.File;

/**
 * This class contains the main method to run this project
 *
 * author: Mingchi Li
 * date: 2019.8.12
 */
public class ProjectRunner {
    public static void usage(){
        System.out.println("Usage:java -jar Graph2NL.jar (-h | -(e|z) -(v|g)(argument))\n" +
                "\t\t\t\t-h\tPrint this help\n" +
                "\t\t\t\t-e\tPrint out English result\n" +
                "\t\t\t\t-z\tPrint out Chinese result\n" +
                "\t\t\t\t-v\tUse .e.v file as input\n" +
                "\t\t\t\t-g\tUse .gexf file as input\n" +
                "\t\t\t\targument:For .e.v file is the directory contain those two file\n" +
                "         \t\t\t\tFor .gexf file is it filename");
    }

    public static void main(String[] args){
        Digraph dg = new Digraph();
        int language = 0;
        if (args.length == 0) usage();
        Getopt g = new Getopt("Graph2NL", args, "v:g:ceh");
        int c;
        String arg;
        while ((c = g.getopt()) != -1) {
            switch(c) {
                case 'h':
                    usage();
                    break;
                case 'e':
                    language = 0;
                    break;
                case 'c':
                    language = 1;
                    break;
                case 'g':
                    dg = ReadFromFile.parseGEXF(g.getOptarg());
                    break;
                case 'v':
                    File folder = new File(g.getOptarg());
                    File[] listOfFiles = folder.listFiles();
                    String[] fileName = new String[2];
                    for (int i = 0; i < listOfFiles.length; i++) {
                        if (listOfFiles[i].isFile()) {
                            String temp = listOfFiles[i].getName();
                            temp = temp.substring(temp.length() - 2);
                            if (temp.equals(".v")) fileName[0] = g.getOptarg() + "/" + listOfFiles[i].getName();
                            if (temp.equals(".e")) fileName[1] = g.getOptarg() + "/" + listOfFiles[i].getName();
                        }
                    }
                    dg = ReadFromFile.ReadFromCSV(fileName[0], fileName[1]);
                    break;
                case '?':
                    break; // getopt() already printed an error
                default:
                    System.out.print("getopt() returned " + c + "\n");
            }

            switch (language){
                case 0:
                    dg.toEnglish();
                    break;
                case 1:
                    dg.toChinese();
                    break;
            }
        }
    }
}
