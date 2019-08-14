package com.graph2nl;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
/**
 * Read Graph data from file
 *
 * author: Mingchi Li
 * date: 2019.8.8
 */
public class ReadFromFile {
    //Load json configuration file
    public static void loadConfig(String config, Digraph dg) throws IOException, ParseException {
        // parsing file "config.json"
        Object obj = new JSONParser().parse(new FileReader(config));

        // typecasting obj to JSONObject
        JSONObject jo = (JSONObject) obj;

        // getting VertexLabel
        JSONArray jv = (JSONArray) jo.get("VertexLabel");
        // iterating vertex label
        Iterator itr = jv.iterator();
        Map<String, VertexLabel> tempMapV = new HashMap<>();
        while (itr.hasNext())
        {
            JSONObject tempV = (JSONObject) itr.next();
            String name = (String) tempV.get("name");
            Long priority = (Long) tempV.get("priority");
            VertexLabel tempLabel = new VertexLabel(name);
            tempLabel.setPriority(priority);
            tempMapV.put(name, tempLabel);
//            System.out.println("{name: " + name +  ", \npriority: " + priority +"}");
        }
        dg.setVertexLabelMap(tempMapV);

        // getting EdgeLabel
        JSONArray je = (JSONArray) jo.get("EdgeLabel");
        Map<String, EdgeLabel> tempMapE = new HashMap<>();
        itr = je.iterator();
        while (itr.hasNext())
        {
            JSONObject tempE = (JSONObject) itr.next();
            String name = (String) tempE.get("name");
            Long priority = (Long) tempE.get("priority");
            String prefix = (String) tempE.get("prefix");
            String postfix = (String) tempE.get("postfix");
            EdgeLabel tempLabel = new EdgeLabel(name);
            tempLabel.setPriority(priority);
            tempLabel.setPrefix(prefix);
            tempLabel.setPostfix(postfix);
            tempMapE.put(name, tempLabel);
//            System.out.println("{name: " + name +  ",\n" +
//                    " priority: " + priority +",\n" +
//                    " prefix: " + prefix + ",\n" +
//                    " postfix: " + postfix + "}");
        }
        dg.setEdgeLabelMap(tempMapE);
    }

    //This function can parse .e .v file and convert them into a Digraph object
//    public static Digraph ReadFromCSV(String vFileName, String eFileName, Digraph dg){
//        File vFile = new File(vFileName);
//        BufferedReader reader = null;
//        try {
//            reader = new BufferedReader(new FileReader(vFile));
//            String temp = null;
//            while ((temp = reader.readLine()) != null) {
//                VertexLabel[] line[] = temp.split(",");
//                for (int i = 0; i < line.length; i++){
//                    System.out.print(line[i] + " ");
//                }
//                dg.addVertexToMap(new Vertex(Long.valueOf(line[0]), line[1], line[2]));
//                System.out.println();
//            }
//            reader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("\n-------------------------------------------\n");
//
//        File eFile = new File(eFileName);
//        reader = null;
//        try {
//            reader = new BufferedReader(new FileReader(eFile));
//            String temp = null;
//            while ((temp = reader.readLine()) != null) {
//                EdgeLabel[] line[] = temp.split(",");
//                for (int i = 0; i < line.length; i++){
//                    System.out.print(line[i] + " ");
//                }
//                dg.addEdge(new Edge(Long.valueOf(line[0]),
//                        dg.getVertexById(Long.valueOf(line[1])),
//                        dg.getVertexById(Long.valueOf(line[2])), line[3]));
//                System.out.println();
//            }
//            reader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return dg;
//    }
//
//    //Load from .gexf file
//    public static Digraph parseGEXF(String fileName, Digraph dg){
//        File inputFile = new File(fileName);
//        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//
//        try {
//            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//            Document doc = dBuilder.parse(inputFile);
//            doc.getDocumentElement().normalize();
//            NodeList nList = doc.getElementsByTagName("node");
//            NodeList eList = doc.getElementsByTagName("edge");
//            System.out.println("There are " + nList.getLength() + " of vertex.");
//            System.out.println("There are " + eList.getLength() + " of edge.\n");
//
//            //Parse Vertices and add them to the graph object
//            for (int i = 0; i < nList.getLength(); i++) {
//                Node nNode = nList.item(i);
//                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
//                    Element eElement = (Element) nNode;
//                    Long id = Long.valueOf( eElement.getAttribute("id"));
//                    VertexLabel label = eElement.getAttribute("label");
//                    String name = eElement.getElementsByTagName("attvalue").item(0).getAttributes().item(1).getTextContent();
//                    System.out.println("Vertex: " + id + " " + label + " " + name);
//                    dg.addVertexToMap(new Vertex(id, label, name));
//                }
//            }
//
//            System.out.println();
//
//            //Parse Edges and add them to the graph object
//            for (int i = 0; i < eList.getLength(); i++) {
//                Node eNode = eList.item(i);
//                if (eNode.getNodeType() == Node.ELEMENT_NODE) {
//                    Element eElement = (Element) eNode;
//                    Long id = Long.valueOf(eElement.getAttribute("id"));
//                    Vertex from = dg.getVertexById(Long.valueOf(eElement.getAttribute("source")));
//                    Vertex to = dg.getVertexById(Long.valueOf(eElement.getAttribute("target")));
//                    EdgeLabel label = eElement.getElementsByTagName("attvalue").item(0).getAttributes().item(1).getTextContent();
//                    System.out.println("Edge: " + id + " " + from + " " + to + " " + label);
//                    dg.addEdge(new Edge(id, from, to, label));
//                }
//            }
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//        return dg;
//    }
}
