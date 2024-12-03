package com.example.jc_p3_v2.viewmodels

import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.tasks.await

class ReadDataViewModel : ViewModel() {
    private val firestore = FirebaseFirestore.getInstance()

    private val _dataList = MutableStateFlow<List<String>>(emptyList())
    val dataList: StateFlow<List<String>> = _dataList

    //POBIERANIE DANYCH Z FIREBASE
    suspend fun fetchData() {
        try {
            val querySnapshot = firestore.collection("users")
                .get()
                .await()

            val data = querySnapshot.documents.mapNotNull {
                it.getString("text")
            }

            _dataList.value = data
        } catch (e: Exception) {
            // Obsługa błędów
        }
    }
}