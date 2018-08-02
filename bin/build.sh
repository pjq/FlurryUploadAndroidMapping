#!/bin/bash
echo "Build the FlurryUpload-1.0-SNAPSHOT.jar"
pwd
cd ..
./gradlew fatJar 
echo "cp build/libs/FlurryUpload-1.0-SNAPSHOT.jar bin/"
cp build/libs/FlurryUpload-1.0-SNAPSHOT.jar bin/
