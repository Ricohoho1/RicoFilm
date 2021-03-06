package com.browsermob.core.har;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.codehaus.jackson.map.ObjectMapper;

public class HarParser {
    private static ObjectMapper mapper = new ObjectMapper();
 
    /**
     * Parse a JSON HAR
     * 
     * @param f a JSON file
     * @return the HarLog representation
     * @throws IOException if file not found
     */
  /*
    public static Har parseHarFromFile(File f) throws IOException {
        String har = FileUtils.readFileToString(f);
        return parseHAR(har);
    }
    */

    /**
     * Parse a JSON HAR
     * 
     * @param har a JSON String
     * @return the HarLog representation
     * @throws IOException if file not found
     */
    /*
    public static Har parseHAR(String har) throws IOException {
        Har value = mapper.readValue(har, Har.class);
        return value;
    }
    */
}
