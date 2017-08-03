# offerings-api
An unofficial API for Bilkent University course offerings. Returns JSON array of courses. Gets the data as HTML from: https://stars.bilkent.edu.tr/homepage/plain_offerings.

![Heroku Status](http://heroku-badge.herokuapp.com/?app=offerings&root=cs&style=flat)
![Build Status](https://api.travis-ci.org/emrehan/offerings-api.png)
![Dependency Status](https://www.versioneye.com/user/projects/553502477f43bc60fe000002/badge.svg?style=flat)


An example response:
```json
{
    "CS 101-1": {
         "details": {
             "name": "Algorithms and Programming I",
             "instructor": "David Davenport   ",
             "department": "CS",
             "number": "101",
             "section": "1"
         },
        "hours": {
            "lecture": "3",
            "lab": "4",
            "schedule": "Mon08:40-10:30 B-Z08 Tue13:40-17:30 B-201[L] Wed10:40-11:30 B-Z08 Wed11:40-12:30 B-Z08[S]"
        },
        "quotas": {
            "total": "74",
            "available": "0"
        },
        "credits": {
            "ects": "7",
            "bilkent": "4"
        }
    }
}
```


### Try it
https://offerings.herokuapp.com/cs

### Endpoints
##### /
Returns all the courses.
* https://offerings.herokuapp.com/

ps. Use responsibly.

##### /:dept
Returns a JSON array of all courses offered in the current semester. 

* https://offerings.herokuapp.com/cs
* https://offerings.herokuapp.com/man

##### /:dept/:course
Returns a JSON array of all sections of the course offered in the current semester. 

* https://offerings.herokuapp.com/cs/101
* https://offerings.herokuapp.com/phys/102

##### /:dept/:course/:section
Returns a JSON array of the section of the course offered in the current semester. 

* https://offerings.herokuapp.com/cs/101/3
* https://offerings.herokuapp.com/math/101/1


### Deploy Instructions
* Pull
* Make changes
* Build and install the project: `mvn clean install`
* Try the application locally using Foreman: `foreman start web`
* Commit
* Push here
* Deploy on Heroku: `git push heroku master`


### Contribution
The API is written in Java to welcome contributions from Bilkent students.
Get in touch or open a pull request following [Aaron's git workflow](https://github.com/asmeurer/git-workflow).

#### Certification
Bilkent Stars certificate seems to be ending soon. (8/21/2017)
* To renew, read https://stackoverflow.com/questions/7744075/how-to-connect-via-https-using-jsoup


### Contributors
* Emrehan Tüzün, http://tuzun.co
* Selim Fırat Yılmaz, http://github.com/mrsfy


### Licence
MIT License.

Copyright © 2015 Emrehan Tüzün, http://tuzun.co

http://opensource.org/licenses/MIT
