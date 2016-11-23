package dk.cphbusiness.masterdetailtemplate

import android.content.Context
import android.content.Intent
import android.hardware.*
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.async
import org.jetbrains.anko.uiThread
import java.net.URL

fun String.times(count: Int) : String {
    var result = this;
    for (i in 2..count) {
        result += this
        }
    return result
    }

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

class MainActivity : AppCompatActivity(), SensorEventListener{

    val max = floatArrayOf(0.0f,0.0f,0.0f)

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sm = getSystemService(Context.SENSOR_SERVICE) as SensorManager;
        ///*
        val accelerometer = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL)
        headerText.text = "acceleration";
        //*/
        /*
        val gyroscope = sm.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        sm.registerListener(this, gyroscope, SensorManager.SENSOR_DELAY_NORMAL)
        headerText.text = "Gyroscope";
        */
    }
    override fun onSensorChanged(sensorEvent: SensorEvent) {

        text.text = """
                |X: ${sensorEvent.values[0]}
                |Y: ${sensorEvent.values[1]}
                |Z: ${sensorEvent.values[2]}
                """.trimMargin()

        for (index in sensorEvent.values.indices){
            if(sensorEvent.values[index]>max[index]){
                max[index]=sensorEvent.values[index]
            }
        }

        maxText.text = """
                |X: ${max[0]}
                |Y: ${max[1]}
                |Z: ${max[2]}
                """.trimMargin()
    }

    override fun onAccuracyChanged(sensor: Sensor, i: Int) {

    }







    }
