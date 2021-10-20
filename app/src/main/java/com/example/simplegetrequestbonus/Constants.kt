package com.example.simplegetrequestbonus


object Constants {
     val url =  "https://dojo-recipes.herokuapp.com/"
    val apiInterface = APIClient().getClient()?.create(APIInterface::class.java)

}
data class Items(val name:String){}