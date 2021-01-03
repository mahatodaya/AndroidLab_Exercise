package lab06

import java.io.Serializable

class Person:Serializable {
    var Name: String
    var Address: String
    var Mobile : String
    var Gender: String
    constructor(name: String, address: String, mobile: String, gender: String){
        this.Name = name
        this.Address = address
        this.Mobile = mobile
        this.Gender = gender
    }

    override fun toString(): String {
        return Name
    }
}