package ir.ariyana.arianabooks.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.ariyana.arianabooks.repository.MainRepository
import ir.ariyana.arianabooks.repository.model.BooksOverviewResponse
import ir.ariyana.arianabooks.utils.Resource
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
): ViewModel() {

    private val _response = MutableLiveData<Resource<BooksOverviewResponse>>()

    val response : LiveData<Resource<BooksOverviewResponse>>
        get() = _response

    fun getBooksOverview() {
        _response.postValue(Resource.Loading())
        viewModelScope.launch {
            try {
                val res = mainRepository.getBooksOverview()
                if(res.isSuccessful) {
                    _response.postValue(Resource.Success(res.body()))
                }
                _response.postValue(Resource.Error(res.message()))
            }
            catch (e : Exception) {
                _response.postValue(Resource.Error("An exception occurred!"))
            }
        }
    }
}