# offerings-api
An unofficial API for Bilkent University course offerings. Returns JSON array of courses. Gets the data as HTML from: https://stars.bilkent.edu.tr/homepage/plain_offerings.

An example response:
```json
[{
    "id": "CS 101-1",
    "instructor": "H. Altay Güvenir  ",
    "course": {
        "number": "101",
        "name": "Algorithms and Programming I",
        "section": "1",
        "department": "CS"
    },
    "quotas": {
        "total": "60",
        "available": "0"
    },
    "credits": {
        "ects": "7",
        "bilkent": "4"
    },
    "hours": {
        "lecture": "3",
        "lab": "4"
    },
    "schedule": "Mon 08:40-09:30 B-Z01[S] Mon 09:40-10:30 B-Z01 Tue 15:40-17:30 B-303[L] Wed 10:40-12:30 B-Z01"
}]
```


### Try it
https://offerings.herokuapp.com/cs

### Endpoints
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

### Contribution
Get in touch or open a pull request. Indeed, I've written the API in Java to welcome contributions.

### Licence
MIT License.

Copyright © 2015 Emrehan Tüzün, http://tuzun.co

http://opensource.org/licenses/MIT
