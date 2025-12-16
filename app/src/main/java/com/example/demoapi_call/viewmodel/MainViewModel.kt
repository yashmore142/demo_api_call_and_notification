package com.example.demoapicall_setup.main_screen.viewmodel

import Repository
import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.demoapicall_setup.main_screen.model.DemoResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.net.HttpURLConnection

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = Repository()

    private val _data = MutableLiveData<DemoResponse>()
    val data: LiveData<DemoResponse> = _data

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun getData() {
        viewModelScope.launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    repository.getData()
                }
                _data.value = response.body()
            } catch (e: Exception) {
                _error.value = e.message
                Log.e("http_error", e.message ?: "Unknown error")
            }
        }
    }
}
