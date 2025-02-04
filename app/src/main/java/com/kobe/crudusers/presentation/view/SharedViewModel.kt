package com.kobe.crudusers.presentation.view

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject
import com.kobe.crudusers.data.datasource.UserData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SharedViewModel(
    //
) : ViewModel() {

    fun saveData(
        userData: UserData,
        context: Context,
    ) = CoroutineScope(Dispatchers.IO).launch{
        val firestoreRef = Firebase.firestore
            .collection("user")
            .document(userData.userId)

        try{
            firestoreRef.set(userData)
                .addOnSuccessListener {
                    Toast.makeText(context, "Success !!!", Toast.LENGTH_SHORT).show()
                }
        }catch (e: Exception){
            Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
        }
    }

    fun getData(
        userId: String,
        context: Context,
        data: (UserData)->Unit
    ) = CoroutineScope(Dispatchers.IO).launch{
        val firestoreRef = Firebase.firestore
            .collection("user")
            .document(userId)

        try{
            firestoreRef.get()
                .addOnSuccessListener {user->
                    if(user.exists()){
                        val userData = user.toObject<UserData>()!!
                        data(userData)
                    }else{
                        Toast.makeText(context, "No User Data Found !!!", Toast.LENGTH_SHORT).show()
                    }
                }
        }catch (e: Exception){
            Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
        }
    }

    fun deleteData(
        userId: String,
        context: Context,
        navController: NavController
    ) = CoroutineScope(Dispatchers.IO).launch{

        val firestoreRef = Firebase.firestore
            .collection("user")
            .document(userId)

        try{
            firestoreRef.delete()
                .addOnSuccessListener {
                    Toast.makeText(context, "No User Data Found !!!", Toast.LENGTH_SHORT).show()
                    navController.popBackStack()
                }
        }catch (e: Exception){
            Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
        }
    }


}