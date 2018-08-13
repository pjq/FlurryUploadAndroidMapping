#!/bin/bash
echo "Usage: $0 flurry.config mapping.txt uuid"
echo "Upload Android Mapping file $0 $1 $2 $3"
java -jar FlurryUpload-1.0-SNAPSHOT.jar $1 $2 $3
