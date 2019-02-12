package com.prestacukes.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class OlympicQuarterly { private static Properties IOCproperties;

    static {
        try {
            String path = "ioc.properties";

            FileInputStream stream = new FileInputStream( path);

            IOCproperties = new Properties();
            IOCproperties.load(stream);

            stream.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getIOCproperties(String key) { return getIOCproperties ( key ); }
}
