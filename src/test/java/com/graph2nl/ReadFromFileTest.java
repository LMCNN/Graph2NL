package com.graph2nl;

import org.json.simple.parser.ParseException;
import org.junit.Test;

import java.io.IOException;

public class ReadFromFileTest {
//    @Test
//    public void readFromCSV1() throws IOException, ParseException {
//        Digraph dg = new Digraph();
//        ReadFromFile.loadConfig("src/data/config.json", dg);
//        ReadFromFile.ReadFromCSV("src/data/data_1/test.v", "src/data/data_1/test.e", dg);
////        System.out.println(dg.toString());
//        dg.describe('e');
//    }
//
//    @Test
//    public void readFromCSV2() {
//        Digraph dg = new Digraph();
//        ReadFromFile.ReadFromCSV("src/data/data_cn_1/testCN.v", "src/data/data_cn_1/testCN.e", dg);
//        dg.describe('z');
//    }
//
    @Test
    public void testParseGEXF() throws IOException, ParseException {
        Digraph dg = new Digraph();
//        ReadFromFile.loadConfig("src/data/config.json", dg);
        ReadFromFile.parseGEXF("src/data/graph.gexf", dg);

//        dg.describe('e');
        System.out.println(dg.getJson());
    }

//    @Test
//    public void testLoadConfig() throws IOException, ParseException {
//        Digraph dg = new Digraph();
//        ReadFromFile.loadConfig("src/data/config.json", dg);
//        System.out.println(dg.toString());
//    }
}
