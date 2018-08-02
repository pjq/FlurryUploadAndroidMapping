#### Tools used to upload the Android Mapping file to Flurry 

The Flurry only provide the gradle integration to upload the mapping during the release build.

So I build the tool to support mannually upload the mapping file, it refer 
-  https://github.com/flurry/upload-clients/issues/15
-  https://developer.yahoo.com/flurry/docs/api/code/apptoken/


##### How to use
Before upload the mapping file, you need update your `APK_KEY` and `TOKEN` in the file `bin/flurry.config`

```
API_KEY=XXXXXXXX
TOKEN=XXXXXXXXXXXXXXX
TIMEOUT=60000
```

```
cd bin
./build.sh

```

```
cd bin
./upload.sh mapping.txt

```

```
./upload.sh mapping.txt     
Upload Android Mapping file mapping.txt 
upload mapping: mapping.txt
[main] INFO com.flurry.proguard.UploadMapping - Found project 16580x for api key T6XAETCZD1PL62L4S3YX
[main] INFO com.flurry.proguard.UploadMapping - Created upload with ID: 20096
[main] INFO com.flurry.proguard.UploadMapping - ProGuard mapping uploaded to Flurry
[main] INFO com.flurry.proguard.UploadMapping - Upload completed successfully!

```

