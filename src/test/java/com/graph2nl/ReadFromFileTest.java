package com.graph2nl;

import org.junit.Test;

public class ReadFromFileTest {
//    @Test
//    public void readFromCSV1() {
//        Digraph dg;
//        dg = ReadFromFile.ReadFromCSV("src/test.v", "src/test.e");
//        //System.out.println(dg.toString());
//        dg.toEnglish();
//    }
//
    @Test
    public void readFromCSV2() {
        Digraph dg;
        dg = ReadFromFile.ReadFromCSV("src/testCN.v",
                "src/testCN.e");
        //System.out.println(dg.toString());
        dg.toChinese();
    }

//    @Test
//    public void testParseGEXF(){
//        Digraph dg = ReadFromFile.parseGEXF("src/data.gexf");
//        dg.toEnglish();
//    }
}
