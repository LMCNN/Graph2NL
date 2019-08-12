package com.graph2nl;

import java.io.*;

/**
 * Read Graph data from file
 *
 * author: Mingchi Li
 * date: 2019.8.8
 */
public class ReadFromFile {
    public static Digraph ReadFromCSV(String vFileName, String eFileName){
        Digraph dg = new Digraph();
        File vFile = new File(vFileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(vFile));
            String temp = null;
            while ((temp = reader.readLine()) != null) {
                String line[] = temp.split(",");
                for (int i = 0; i < line.length; i++){
                    System.out.print(line[i] + " ");
                }
                dg.addVertexToMap(new Vertex(Integer.valueOf(line[0]), line[1], line[2]));
                System.out.println();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("-------------------------------------------");

        File eFile = new File(eFileName);
        reader = null;
        try {
            reader = new BufferedReader(new FileReader(eFile));
            String temp = null;
            while ((temp = reader.readLine()) != null) {
                String line[] = temp.split(",");
                for (int i = 0; i < line.length; i++){
                    System.out.print(line[i] + " ");
                }
                dg.addEdge(new Edge(Integer.valueOf(line[0]), Integer.valueOf(line[1]), Integer.valueOf(line[2]), line[3]));
                System.out.println();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dg;
    }

    public static Digraph parseGEXF(){
        Digraph dg = new Digraph();



        return dg;
    }
}
