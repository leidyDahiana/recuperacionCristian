package com.ventana.ventanas

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class SegundaVentana : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Intent.FLAG_ACTIVITY_CLEAR_TOP
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda_ventana)

        val nombre=findViewById<TextView>(R.id.Nombre)
        val tipo=findViewById<TextView>(R.id.Tipo)
        val precioCompraDescuento=findViewById<TextView>(R.id.PrecioCompraDescuento)
        val precioCompraReal=findViewById<TextView>(R.id.PrecioCompraReal)

        var miBundleNom: Bundle?=this.intent.extras
        var miBundleTipo: Bundle?=this.intent.extras
        var bundleTotal: Bundle?=this.intent.extras
        var bundleTotalReal: Bundle?=this.intent.extras

        if (miBundleNom != null){
            nombre.text="Nombre: ${miBundleNom.getString("Nombre")} "
            if (miBundleTipo != null){
                tipo.text="Tipo: ${miBundleTipo.getString("Tipo")}"
                if (bundleTotal != null){
                    precioCompraDescuento.text="Descuento: ${bundleTotal.getString("Descuento")}"
                    if (bundleTotalReal != null){
                        precioCompraReal.text="Precio real: ${bundleTotalReal.getString("PrecioReal")}"
                    }
                }

            }
        }

        val botonSalir: Button = findViewById(R.id.botonSalir1)
        botonSalir.setOnClickListener { onclick() }
    }
    private fun onclick(){
        finish()
    }
}