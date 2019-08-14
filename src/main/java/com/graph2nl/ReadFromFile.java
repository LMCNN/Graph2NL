package com.graph2nl;

import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;

/**
 * Read Graph data from file
 *
 * author: Mingchi Li
 * date: 2019.8.8
 */
public class ReadFromFile {
    //Load json configuration file
    public static void loadConfig(Digraph dg){

    }

    //This function can parse .e .v file and convert them into a Digraph object
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

        System.out.println("\n-------------------------------------------\n");

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

    public static Digraph parseGEXF(String fileName){
        Digraph dg = new Digraph();
        File inputFile = new File(fileName);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("node");
            NodeList eList = doc.getElementsByTagName("edge");
            System.out.println("There are " + nList.getLength() + " of vertex.");
            System.out.println("There are " + eList.getLength() + " of edge.\n");

            //Parse Vertices and add them to the graph object
            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    Integer id = Integer.valueOf( eElement.getAttribute("id"));
                    String label = eElement.getAttribute("label");
                    String name = eElement.getElementsByTagName("attvalue").item(0).getAttributes().item(1).getTextContent();
                    System.out.println("Vertex: " + id + " " + label + " " + name);
                    dg.addVertexToMap(new Vertex(id, label, name));
                }
            }

            System.out.println();

            //Parse Edges and add them to the graph object
            for (int i = 0; i < eList.getLength(); i++) {
                Node eNode = eList.item(i);
                if (eNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) eNode;
                    Integer id = Integer.valueOf(eElement.getAttribute("id"));
                    Integer from = Integer.valueOf(eElement.getAttribute("source"));
                    Integer to = Integer.valueOf(eElement.getAttribute("target"));
                    String label = eElement.getElementsByTagName("attvalue").item(0).getAttributes().item(1).getTextContent();
                    System.out.println("Edge: " + id + " " + from + " " + to + " " + label);
                    dg.addEdge(new Edge(id, from, to, label));
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return dg;
    }
}
