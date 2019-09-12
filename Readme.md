## Overview
This repository contains all the information,requirements,how to build the system for `Coding Assignment - Software Dynamics Internship`

### Requirements
The documentation for the requirements can be found [here](https://github.com/respasandin/CSCodingAsignment/tree/master/Requirements)

## Usage
```
$ gradle build
$ java -jar /build/libs/CodingAssignment-1.0-SNAPSHOT.jar "path/to/your/log_file.json"
```
Output:
```
Reading file...
Connecting to database...
Connected to database
Empty database
Data inserted in database
Database closed
Exit
```
### Tests
Test to get the file path
```
$ gradle testgetPath -Dpath="path/to/your/log_file.json"
```
Output:

```bash
Path/to/your/log_file 
```

Test to read the file
```
$ gradle testreadjson -Dpath="path/to/your/log_file.json"
```
Output json file for same ids within start timestamp,end timestamp,duration and alert :
```
scsmbstgra scsmbstgra 1491377495212 1491377495217 5 false
scsmbstgrb scsmbstgrb 1491377495213 1491377495216 3 false
scsmbstgrc scsmbstgrc 1491377495210 1491377495218 8 true
scsmbstgrd scsmbstgrd 1491377495210 1491377495214 4 false
scsmbstgre scsmbstgre 1492377495210 1492377495216 6 false
scsmbstgrf scsmbstgrf 1491377495212 1491377495217 5 false
scsmbstgrg scsmbstgrg 1491377495210 1491377495217 7 false
scsmbstgrh scsmbstgrh 1491377495210 1491377495216 6 false
scsmbstgri scsmbstgri 1491377495210 1491377495214 4 false
scsmbstgrj scsmbstgrj 1492377495210 1492377495216 6 false
```
