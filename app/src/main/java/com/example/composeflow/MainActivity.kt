package com.example.composeflow
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.example.composeflow.ui.theme.ComposeflowTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeflowTheme {
              val viewModel:myviewmodel by viewModels()
              secondscreen(viewModel = viewModel)
            }
        }
    }

    @Composable
    fun firstsceern(viewModel: myviewmodel)
    {
        val counter= viewModel.countdowntimerflow.collectAsState(initial = 10)
        Surface(color=MaterialTheme.colors.background) {
            Box(modifier = Modifier.fillMaxSize())
            { Text(text = counter.value.toString()) }
        }
    }

    @Composable
    fun secondscreen(viewModel: myviewmodel)
    {
        val livedatevalue=viewModel.liveDate.observeAsState()
        val stateflowvalue=viewModel.stateFlow.collectAsState()
        val sharedflowvalue =viewModel.SharedFlow.collectAsState(initial = "")
        Surface(color=MaterialTheme.colors.background) {
            Box(modifier = Modifier.fillMaxSize()){
                Column(modifier = Modifier.align(Alignment.Center)) {
                    Text(text = livedatevalue.value ?:"")
                    Button(onClick = { viewModel.changcelivedatevalue() })
                    { Text(text = "live date button") }

                    Spacer(modifier = Modifier.padding(10.dp))
                    Text(text = stateflowvalue.value ?:"")
                    Button(onClick = { viewModel.changcestateflowvalue() }) {
                        Text(text = "State date button") }


                    Spacer(modifier = Modifier.padding(10.dp))
                    Text(text = sharedflowvalue.value ?:"")
                    Button(onClick = { viewModel.changeshareflowvalue() })
                    { Text(text = "Share date button") }
                }
            }
        }
    }

}

