package com.kobe.crudusers.data.datasource


data class UserData(
    val userId: String,
    val name: String,
    val profession: String,
    val age: Int = 0
)
//){
//    // No-argument constructor (required by Firestore)
//    constructor() : this(null, null, null, null)
//}
