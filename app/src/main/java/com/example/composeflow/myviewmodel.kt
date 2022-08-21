package com.example.composeflow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class myviewmodel: ViewModel()
{
    val countdowntimerflow= flow<Int> {
        val coutdownfrom=10
        var counter=coutdownfrom
        emit(coutdownfrom)
        while (counter>0){
            delay(1000)
            counter--
            emit(counter)
        }
    }
    init {
        collectınviewmodel()
    }
private fun collectınviewmodel(){
    viewModelScope.launch {
       /* countdowntimer.filter(){
            it %3==0
        }
            .map {
                it+it
            }
            .collect{
                println("Counter is:${it}")
            }*/

    }

}

    //livedate
    private val livedate=MutableLiveData<String>("kotlinlivedate")
    val liveDate : LiveData<String> = livedate
    fun changcelivedatevalue()
    { livedate.value="live date" }

    //gözlemlenebilir livedate ya benziyor
    private val stateflow = MutableStateFlow("kotlinstateflow")
    val stateFlow =stateflow.asStateFlow()
    fun changcestateflowvalue()
    { stateflow.value="stat flow" }

    //gözlemlenebilir livedate ya benziyor
    private val sharedFlow= MutableSharedFlow<String>()
    val SharedFlow= sharedFlow.asSharedFlow()
    fun changeshareflowvalue()
    { viewModelScope.launch {
      sharedFlow.emit("Shared flow") }
    }


}