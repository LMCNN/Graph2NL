package com.graph2nl;

import org.json.simple.parser.ParseException;
import org.junit.Test;

import java.io.IOException;

public class ReadFromFileTest {
//    @Test
//    public void readFromCSV1() {
//        Digraph dg = new Digraph();
//        ReadFromFile.ReadFromCSV("src/data.v", "src/data.e", dg);
//        dg.toEnglish();
//    }
//
//    @Test
//    public void readFromCSV2() {
//        Digraph dg = new Digraph();
//        ReadFromFile.ReadFromCSV("src/testCN.v", "src/testCN.e", dg);
//        dg.toChinese();
//    }
//
//    @Test
//    public void testParseGEXF(){
//        Digraph dg = new Digraph();
//        ReadFromFile.parseGEXF("src/data.gexf", dg);
//        dg.toEnglish();
//    }

    @Test
    public void testLoadConfig() throws IOException, ParseException {
        Digraph dg = new Digraph();
        ReadFromFile.loadConfig("src/config.json", dg);
        System.out.println(dg.toString());
    }
}
