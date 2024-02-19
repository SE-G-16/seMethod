# seMethod
## Group 16

##### This is a group project using a Java Development environment to query a database

###### [*Emmanuel Ikechukwu Benson*](https://github.com/Emmaben)
###### [*Ananya Akula Akula*](https://github.com/Okehusingit)
###### [*Diya Sharma*](https://github.com/Diya2715)
###### [*Neil Mckenna*](https://github.com/neil-mckenna)



* Master Build Status ![GitHub Workflow Status (branch)](https://img.shields.io/github/actions/workflow/status/SE-G-16/seMethod/mysql_test.yml?branch=master)
* Develop Branch Status ![GitHub Workflow Status (branch)](https://img.shields.io/github/actions/workflow/status/SE-G-16/seMethod/mysql_test.yml?branch=develop)
* Release Branch Status ![GitHub Workflow Status (branch)](https://img.shields.io/github/actions/workflow/status/SE-G-16/seMethod/mysql_test.yml?branch=release)
* Mysql/feature Branch Status ![GitHub Workflow Status (branch)](https://img.shields.io/github/actions/workflow/status/SE-G-16/seMethod/mysql_test.yml?branch=mysql/feature)

* License [![LICENSE](https://img.shields.io/github/license/SE-G-16/seMethod.svg?style=flat-square)](https://github.com/SE-G-16/seMethod/blob/master/LICENSE)

* Release [![Releases](https://img.shields.io/github/release/SE-G-16/seMethod/all.svg?style=flat-square)](https://github.com/SE-G-16/seMethod/releases)


---
## Some helpful commands when debugging or configuring docker files

---
#### if you can't get local server to communicate with app , use this command in the terminal
#### mongo here is the name of docker container
docker run -p 27017:27017 -d mongo

---
#### when docker compose is not updating to the changes due to the cache, overwrite with this 
docker-compose up --build
docker-compose build --no-cache
