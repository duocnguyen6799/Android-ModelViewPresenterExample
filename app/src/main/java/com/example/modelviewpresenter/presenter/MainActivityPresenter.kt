package com.example.modelviewpresenter.presenter

import com.example.modelviewpresenter.model.User

class MainActivityPresenter {
    var user = User()
    var view:View?=null
    constructor(view:View){
        this.view = view
    }
    fun updateUsername(username:String){
        user.username = username
        view?.updateInfoUser(user.toString())
    }
    fun updateFullname(fullname:String){
        user.fullname = fullname
        view?.updateInfoUser(user.toString())
    }
    public interface View{
        fun updateInfoUser(info:String)
    }
}