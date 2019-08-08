package com.graph2nl;

import org.junit.Test;

public class ReadFromFileTest {
    @Test
    public void readFromCSV1() {
        Digraph dg;
        dg = ReadFromFile.ReadFromCSV("C:\\Users\\lmcn\\Documents\\GitHub\\Graph2NL\\src\\test.v",
                "C:\\Users\\lmcn\\Documents\\GitHub\\Graph2NL\\src\\test.e");
        //System.out.println(dg.toString());
        dg.toEnglish();
    }

    @Test
    public void readFromCSV2() {
        Digraph dg;
        dg = ReadFromFile.ReadFromCSV("C:\\Users\\lmcn\\Documents\\GitHub\\Graph2NL\\src\\testCN.v",
                "C:\\Users\\lmcn\\Documents\\GitHub\\Graph2NL\\src\\testCN.e");
        //System.out.println(dg.toString());
        dg.toChinese();
    }
}
