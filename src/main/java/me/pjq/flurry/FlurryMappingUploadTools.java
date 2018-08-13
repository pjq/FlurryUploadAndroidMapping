package me.pjq.flurry;

import com.flurry.proguard.AndroidUploadType;
import com.flurry.proguard.UploadMapping;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.Properties;

/**
 * Tools used to manually upload the mapping file to Flurry
 * Usage: java -jar FlurryUpload-1.0-SNAPSHOT.jar $1 $2 $3
 * Example: java -jar FlurryUpload-1.0-SNAPSHOT.jar flurry.config mapping.txt 190asdjfji
 */
public class FlurryMappingUploadTools {
    private static final String TAG = "FlurryMappingUploadTool";
    public static String API_KEY = null;
    public static String TOKEN = null;
    public static int TIMEOUT = 60000;

    public static void main(String[] args) {
        String mappingFile = null;
        String uuid = null;
        String flurryConfig = null;
        if (null == args || 0 == args.length) {
            log("Error no arguments provided:  java -jar FlurryUpload-1.0-SNAPSHOT.jar flurry.config mapping.txt youruuid");
            return;
        } else if (args.length == 3) {
            flurryConfig = args[0];
            mappingFile = args[1];
            uuid = args[2];
        }

        if (null == uuid) {
            log("Error: UUID is not provided");
            return;
        }

        if (null == mappingFile) {
            log("Error: mapping file is not provided");
            return;
        }

        if (null == flurryConfig) {
            log("Error: flurryConfig file is not provided");
            return;
        }
        log("mappingFile: " + mappingFile + " flurryConfig: " + flurryConfig + " uuid:" + uuid);

        //Load the properties
        try {
            Properties properties = loadProperties(flurryConfig);
            API_KEY = properties.getProperty("API_KEY");
            TOKEN = properties.getProperty("TOKEN");
            TIMEOUT = Integer.valueOf(properties.getProperty("TIMEOUT", "60000"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Upload the mapping
        try {
            uploadMapping(mappingFile, uuid);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static final void log(String message) {
        System.out.println(TAG + ": " + message);
    }

    private static final void uploadMapping(String file, String uuid) throws IOException {
        log("upload mapping: " + file + " uuid: " + uuid + " API_KEY:" + API_KEY + " TOKEN: " + TOKEN);
        UploadMapping.uploadFiles(API_KEY, uuid,
                Collections.singletonList(file),
                TOKEN, TIMEOUT, AndroidUploadType.ANDROID_JAVA);
    }

    private static final Properties loadProperties(String flurryConfig) throws IOException {
        Properties appProps = new Properties();
        appProps.load(new FileInputStream(flurryConfig));

        return appProps;
    }
}
