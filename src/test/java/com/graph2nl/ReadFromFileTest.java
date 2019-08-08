package com.graph2nl;

import org.junit.Test;

public class ReadFromFileTest {
    @Test
    public void readFromCSV() {
        Digraph dg;
        dg = ReadFromFile.ReadFromCSV("C:\\Users\\lmcn\\Documents\\GitHub\\Graph2NL\\src\\test.v",
                "C:\\Users\\lmcn\\Documents\\GitHub\\Graph2NL\\src\\test.e");
        //System.out.println(dg.toString());
        dg.toEnglish();
    }
}
