#### Tools used to upload the Android Mapping file to Flurry 

The Flurry only provide the gradle integration to upload the mapping during the release build.

So I build the tool to support mannually upload the mapping file, it refer 
-  https://github.com/flurry/upload-clients/issues/15
-  https://developer.yahoo.com/flurry/docs/api/code/apptoken/


##### How to use
Before upload the mapping file, you need prepare your flurry.config`

```
API_KEY=XXXXXXXX
TOKEN=XXXXXXXXXXXXXXX
TIMEOUT=60000
```

###### How to build
```
cd bin
./build.sh

```

###### How to upload 
```
cd bin
./upload.sh flurry.config mapping.txt uuid
```
```
/upload.sh flurry.config mapping-1807.txt asdfa24 
Usage: ./upload.sh flurry.config mapping.txt uuid
Upload Android Mapping file ./upload.sh flurry.config mapping-1807.txt asdfa24
FlurryMappingUploadTool: mappingFile: mapping-1807.txt flurryConfig: flurry.config uuid:asdfa24
FlurryMappingUploadTool: upload mapping: mapping-1807.txt uuid: asdfa24 API_KEY:XXXXXXX TOKEN:XXXXXXX
[main] INFO com.flurry.proguard.UploadMapping - Found project xxxxx for api key XXXXXXX 
[main] INFO com.flurry.proguard.UploadMapping - Created upload with ID: XXXXXX 
[main] INFO com.flurry.proguard.UploadMapping - ProGuard mapping uploaded to Flurry
```

