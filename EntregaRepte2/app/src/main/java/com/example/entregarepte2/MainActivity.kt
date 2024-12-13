package com.example.repte2local.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class LaunchViewModel : ViewModel() {
    private val _selectedImage = MutableStateFlow<Int?>(null)
    val selectedImage: StateFlow<Int?> = _selectedImage

    private val _userName = MutableStateFlow("")
    val userName: StateFlow<String> = _userName

    fun selectImage(imageResId: Int) {
        _selectedImage.value = imageResId
    }

    fun setUserName(name: String) {
        _userName.value = name
    }
}