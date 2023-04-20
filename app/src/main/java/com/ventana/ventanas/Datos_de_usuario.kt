package com.ventana.ventanas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Datos_de_usuario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Intent.FLAG_ACTIVITY_CLEAR_TOP
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datos_de_usuario)

        val nombre=findViewById<TextView>(R.id.nombreU)
        val apellido=findViewById<TextView>(R.id.apellidoU)
        val edad=findViewById<TextView>(R.id.edadU)
        val telefono=findViewById<TextView>(R.id.telefonoU)
        val tipo = findViewById<TextView>(R.id.tipoU)

        var miBundleNom: Bundle?=this.intent.extras
        var miBundleApe: Bundle?=this.intent.extras
        var miBundleEdad: Bundle?=this.intent.extras
        var miBundleTel: Bundle?=this.intent.extras
        var miBundleTipo: Bundle?=this.intent.extras

        if (miBundleNom != null){
            nombre.text="${miBundleNom.getString("Nombre")} "
            if (miBundleApe != null){
                apellido.text="${miBundleApe.getString("Apellido")}"
                if (miBundleEdad != null){
                    edad.text="${miBundleEdad.getString("Edad")}"
                    if (miBundleTel != null){
                        telefono.text="${miBundleTel.getString("Telefono")}"
                        if (miBundleTipo != null){
                            tipo.text="${miBundleTipo.getString("Tipo")}"
                        }
                    }
                }
            }
        }

        val btnSalir: Button = findViewById(R.id.button2)
        btnSalir.setOnClickListener { onclick() }

    }

    private fun onclick(){
        finish()
    }
}