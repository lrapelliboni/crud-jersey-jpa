# crud-jersey-jpa
crud challenge uses jersey rest, hibernate and jpa

Steps to deploy (Ubuntu or Debian Like)

This project uses MySQL 8, for install type in your bash:
 * $ wget -c https://dev.mysql.com/get/mysql-apt-config_0.8.10-1_all.deb 
 * $ sudo dpkg -i mysql-apt-config_0.8.10-1_all.deb 
 * $ sudo apt update
 * $ sudo apt-get install mysql-server

Create database in mysql shell:
* $ mysql -u[user] -p[password] 
* $ CREATE DATABASE desafiocrud
* $ exit

Change the persistence.xml file settings if necessary: 
* [persistence.xml](https://github.com/lrapelliboni/crudchallenge/blob/master/src/main/resources/META-INF/persistence.xml)

To generate WAR file to deploy, run this (the war file are found in /target folder):
* $ mvn install
* $ mvn clean package

If you only test the project, run this:
* $ mvn tomcat6:run

Run tests:
* $ mvn test -Dtest=br.com.desafiocrud.UserResourceTest

The main endpoint of application is:
http://[host]:[port]/[appname]/webapi/user/
