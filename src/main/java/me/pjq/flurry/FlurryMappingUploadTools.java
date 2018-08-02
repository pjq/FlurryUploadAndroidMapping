package me.pjq.flurry;

import com.flurry.proguard.AndroidUploadType;
import com.flurry.proguard.UploadMapping;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.Properties;
import java.util.UUID;

public class FlurryMappingUploadTools {
    public static String API_KEY = null;
    public static String TOKEN = null;
    public static int TIMEOUT = 60000;
    public static final String DEFAUL_FILE = "mapping.txt";
    public static final String FLURRY_CONFIG = "flurry.config";

    public static void main(String[] args) {

        String file = null;
        if (null == args || 0 == args.length) {
            log("Don't set the mapping file, so will use the default file: " + DEFAUL_FILE);
            file = DEFAUL_FILE;
        } else {
            file = args[0];
        }

        //Load the properties
        try {
            Properties properties = loadProperties();
            API_KEY = properties.getProperty("API_KEY");
            TOKEN = properties.getProperty("TOKEN");
            TIMEOUT = Integer.valueOf(properties.getProperty("TIMEOUT", "60000"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Upload the mapping
        try {
            uploadMapping(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static final void log(String message) {
        System.out.println(message);
    }

    private static final void uploadMapping(String file) throws IOException {
        log("upload mapping: " + file);
        String uuid = UUID.randomUUID().toString();
        UploadMapping.uploadFiles(API_KEY, uuid,
                Collections.singletonList(file),
                TOKEN, TIMEOUT, AndroidUploadType.ANDROID_JAVA);
    }

    private static final Properties loadProperties() throws IOException {
        Properties appProps = new Properties();
        appProps.load(new FileInputStream(FLURRY_CONFIG));

        return appProps;
    }
}
