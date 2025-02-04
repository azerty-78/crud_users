package com.kobe.crudusers.data.repository

import android.util.Log
import androidx.core.util.remove
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestoreException
import com.kobe.crudusers.Util.Result
import com.kobe.crudusers.data.datasource.UserData
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import kotlin.io.path.exists

class RepUserData
constructor(
    private val userDataRef: CollectionReference
){


    //getUserdata
    fun getUserDataById(userId: String) = callbackFlow {
        val documentRef = userDataRef.document(userId)

        val subscription = documentRef.addSnapshotListener{ snapshot, error ->
            //gestion des erreurs firestore
            if (error != null) {
                if (error is FirebaseFirestoreException) {
                    Log.e("RepUserData", "Firestore error: ${error.message}")
                    trySend(Result.Error(e = error))
                } else {
                    Log.e("RepUserData", "Unknown error: ${error.message}")
                    trySend(Result.Error(e = error))
                }
                return@addSnapshotListener
            }

            //l'utilisateur existe et n'est pas null
            if(snapshot != null && snapshot.exists()) {
                val userData = snapshot.toObject(UserData::class.java)
                if (userData != null) {
                    trySend(Result.Success(data = userData))
                } else {
                    trySend(Result.Error(e = Exception("Failed to convert document to UserData")))
                }
            }
        }
        awaitClose { subscription.remove() }
    }

    //addUser
    fun addUserData(userData: UserData) = flow {
        emit(Result.Loading)

        try{
            userDataRef.document(userData.userId).set(userData).await()
            emit(Result.Success(true))

        }catch (e: Exception){
            if (e is FirebaseFirestoreException) {
                Log.e("RepUserData", "Erreur Firestore: ${e.message}")
                emit(Result.Error(e = e))
            } else {
                Log.e("RepUserData", "Erreur inconnue: ${e.message}")
                emit(Result.Error(e = e))
            }
        }
    }.catch { error ->
        Log.e("RepUserData", "Erreur inattendue: ${error.message}")
        emit(Result.Error(e = error))
    }

    //update User
    fun deleteUserData(userId: String) = flow {
        emit(Result.Loading)

        try {
            userDataRef.document(userId).delete().await()
            emit(Result.Success(true))

        }catch (e: Exception){
            if (e is FirebaseFirestoreException) {
                Log.e("RepUserData", "Erreur Firestore: ${e.message}")
                emit(Result.Error(e = e))
            } else {
                Log.e("RepUserData", "Erreur inconnue: ${e.message}")
                emit(Result.Error(e = e))
            }
        }
    }.catch { error ->
        Log.e("RepUserData", "Erreur inattendue: ${error.message}")
        emit(Result.Error(e = error))
    }

    //updateUser
    fun updateUserData(userData: UserData) = flow {
        emit(Result.Loading)

        try{
            val updates = mapOf(
                "name" to userData.name,
                "profession" to userData.profession,
                "age" to userData.age,
            )
            userDataRef.document(userData.userId!!).update(updates).await()

            emit(Result.Success(true))

        }catch (e: Exception){
            if (e is FirebaseFirestoreException) {
                Log.e("RepUserData", "Erreur Firestore: ${e.message}")
                emit(Result.Error(e = e))
            } else {
                Log.e("RepUserData", "Erreur inconnue: ${e.message}")
                emit(Result.Error(e = e))
            }
        }
    }.catch { error ->
        Log.e("RepUserData", "Erreur inattendue: ${error.message}")
        emit(Result.Error(e = error))
    }

}