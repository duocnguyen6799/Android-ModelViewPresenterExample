package com.example.modelviewpresenter.model

class User {
    var username:String = ""
        get() = field
        set(value) {
            field = value
        }
    var fullname:String = ""
        get() = field
        set(value) {
            field = value
        }
    constructor(username: String, fullname: String) {
        this.username = username
        this.fullname = fullname
    }

    constructor()

    override fun toString(): String {
        return "Username: $username\nFullname: $fullname"
    }
}