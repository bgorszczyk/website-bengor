[![Build Status](https://travis-ci.com/bgorszczyk/website-bengor.svg?branch=prod)](https://travis-ci.com/bgorszczyk/website-bengor)

# Bengor Website

## Getting Started


### Dependencies
This project run thanks to Maven. All the dependencies can be found on the pom.xml file.
Please note that the projet use a PostgreSQL database, currently hosted on Heroku. Make sur to check the datebase configuration on DataSourceConfig.java (from com.bengor.website.websitebengor.configuration package).

### Running the app
To get the server starded, you will need to build the package with the following command :
...\website-bengor>mvn package

Then you can launch the server with the command 
java -jar target\website-bengor-0.0.1-SNAPSHOT.jar
Make sure to use the proper .jar file name if you used a different maven command to build. 

## Auto-Deployment
There is an automatic deployment configured on the prod branch. Every time this branch is updated, his content is builded and hosted on heroku on the following link :
https://bengor-heroku.herokuapp.com/