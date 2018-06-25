package jesus.com.ejemplointentskotlin

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import jesus.com.ejemplointentskotlin.clases.Persona
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalcular.setOnClickListener {
            val anioNacimiento: Int = txtFecha.text.toString().toInt()
            val anioActual = Calendar.getInstance().get(Calendar.YEAR)
            val miEdad = anioActual - anioNacimiento
            lbEdad.text = "Tu edad es: $miEdad años"
        }

        btnSiguiente.setOnClickListener {
            startActivityNormal(this, SecondActivity::class.java)
        }

        btnParcelable.setOnClickListener {
            startActivityObject()
        }
    }

    fun startActivityNormal(activity: Activity, nextActivity: Class<*>) {
        val intent = Intent(activity, nextActivity)
        intent.putExtra("saludo", "Hola como estas")
        intent.putExtra("entero", 125)
        intent.putExtra("decimal", 55.4)
        intent.putExtra("logico", true)
        startActivity(intent)
        finish()
    }

    fun startActivityObject() {
        val intent = Intent(this, SecondActivity::class.java)
        val persona = Persona("Pedro", "Perez", 54)
        intent.putExtra("persona", persona)
        startActivity(intent)
    }
}
