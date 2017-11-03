package org.vsanyc.utils;

import org.json.JSONObject;
import org.json.XML;

import java.io.*;

public class JsonToXml {

    private static final String JSON_FILE = "json/client-printDocsRq.json";
    private static final String OUT = "target/client-printDocsRq.xml";

    public static void main(String[] args)  throws Exception {
        System.out.println("System");

        String jsonStr = getJson();

        System.out.println("Json:");
        System.out.println(jsonStr);

        JSONObject json = new JSONObject(jsonStr);
        String xml = XML.toString(json);

        System.out.println("result xml:");
        System.out.println(xml);

        saveXml(xml);


    }

    private static String getJson() throws Exception {
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        String filePath = cl.getResource(JSON_FILE).getFile();
        File file = new File(filePath);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        //new FileInputStream(file), "UTF8"));
                        new FileInputStream(file), "cp1251"));

        String str;
        StringBuilder sb = new StringBuilder();
        while ((str = in.readLine()) != null) {
            //System.out.println(str);
            sb.append(str);
        }
        in.close();
        return sb.toString();
    }

    private static void saveXml(String text) {
        try (Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(OUT), "cp1251"));) {
            out.write(text);
            out.close();
        } catch (IOException e) {
        }
    }
}
