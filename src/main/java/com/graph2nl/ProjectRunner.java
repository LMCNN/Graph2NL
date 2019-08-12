package com.graph2nl;

/**
 * This class contains the main method to run this project
 *
 * author: Mingchi Li
 * date: 2019.8.12
 */
public class ProjectRunner {
    public static void main(String[] args){
        try {
            Digraph dg = new Digraph();
            if (args[0].equals("-g") && args.length == 3){
                dg = ReadFromFile.parseGEXF(args[1]);
            }
            else if (args[0].equals("-ve") && args.length == 4){
                dg = ReadFromFile.ReadFromCSV(args[1], args[2]);
            }

            if (args[2].equals("-en")){
                dg.toEnglish();
            }
            else if (args[3].equals("-zh")){
                dg.toChinese();
            }
            else {
                System.err.println("Please select the description language");
            }
        }
        catch (Exception e){
            System.err.println("-g (GEXF file name) (-zh|-en)");
            System.err.println("-ve (.v file .e file) (-zh|-en)");
        }
    }
}
