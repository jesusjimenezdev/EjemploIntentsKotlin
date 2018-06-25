package jesus.com.ejemplointentskotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import jesus.com.ejemplointentskotlin.clases.Persona
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val bundle = intent.extras
        if(bundle != null && bundle.getString("saludo") != null) {
            val saludo = bundle.getString("saludo")
            textViewSaludo.text = saludo
        } else {
            Toast.makeText(this, "Esta vacio", Toast.LENGTH_LONG).show()
        }

        val persona = intent.getParcelableExtra<Persona>("persona")
        textViewObjeto.text = "Nombre: ${persona.nombre}, Apellido: ${persona.apellido}, Edad: ${persona.edad}"
    }
}
