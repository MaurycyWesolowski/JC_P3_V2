package com.example.jc_p3_v2.viewmodels

import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class SendDataViewModel : ViewModel() {
    private val firestore = FirebaseFirestore.getInstance()

    // WYSYŁANIE DANYCH DO FIREBASE
    suspend fun sendData(data: Map<String, Any>): Boolean {
        return try {
            firestore.collection("users")
                .add(data)
                .await()
            true
        } catch (e: Exception) {
            false
        }
    }
}