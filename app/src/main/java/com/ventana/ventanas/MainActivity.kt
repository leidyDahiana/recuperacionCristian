package com.ventana.ventanas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    var campoNombre: EditText ?=null
    var campoApellido: EditText ?=null
    var campoEdad: EditText ?=null
    var campoTelefono: EditText ?=null
    var campoProducto: EditText ?=null
    var vUnidad: EditText ?= null
    var cantProducto: EditText ?= null
    var descuento: Double = 0.0
    var tipo: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        campoNombre = findViewById(R.id.nombre)
        campoApellido = findViewById(R.id.apellido)
        campoEdad = findViewById(R.id.edad)
        campoTelefono = findViewById(R.id.telefono)
        campoProducto = findViewById(R.id.producto)
        vUnidad = findViewById(R.id.valorUnidad)
        cantProducto = findViewById(R.id.cantidadProducto)


        val miBoton1: Button = findViewById(R.id.pago)
        miBoton1.setOnClickListener { onClick(1) }

        val miBoton2: Button = findViewById(R.id.datos)
        miBoton2.setOnClickListener { onClick(2) }

        val miBoton3: Button = findViewById(R.id.limpiar)
        miBoton3.setOnClickListener { onClick(3) }


    }



    private fun onClick(boton: Int) {
        when (boton) {
            1->{
                var valorUnidad: Double= vUnidad?.text.toString().toDouble()
                var cantidadProducto: Double= cantProducto?.text.toString().toDouble()
                var totalDesc: Double = 0.0
                var totalReal = valorUnidad * cantidadProducto


                getRadioButton()

                totalDesc = totalReal - (totalReal * descuento)


                    val intent = Intent(this,SegundaVentana::class.java)
                    val miBundleNom:Bundle=Bundle()
                    miBundleNom.putString("Nombre",campoNombre!!.text.toString())
                    intent.putExtras(miBundleNom)

                    val miBundleTipo:Bundle=Bundle()
                    miBundleTipo.putString("Tipo",tipo)
                    intent.putExtras(miBundleTipo)

                    val bundleTotal:Bundle=Bundle()
                bundleTotal.putString("Descuento",totalDesc.toString())
                    intent.putExtras(bundleTotal)
                    startActivity(intent)

                    val bundleTotalReal:Bundle=Bundle()
                bundleTotalReal.putString("PrecioReal",totalReal.toString())
                    intent.putExtras(bundleTotalReal)
                    startActivity(intent)
                }

            2->{
                if(campoNombre?.text.toString().isEmpty() || campoApellido?.text.toString().isEmpty() || campoEdad?.text.toString().isEmpty() || campoTelefono?.text.toString().isEmpty()){
                    Toast.makeText(this, "Debe llenar todos los campos", Toast.LENGTH_SHORT).show()
                    return
                }else{
                getRadioButton()

                val intent = Intent(this,Datos_de_usuario::class.java)
                val miBundleNom:Bundle=Bundle()
                miBundleNom.putString("Nombre",campoNombre!!.text.toString())
                intent.putExtras(miBundleNom)

                val miBundleApe:Bundle=Bundle()
                miBundleApe.putString("Apellido",campoApellido!!.text.toString())
                intent.putExtras(miBundleApe)

                val miBundleEdad:Bundle=Bundle()
                miBundleEdad.putString("Edad",campoEdad!!.text.toString())
                intent.putExtras(miBundleEdad)

                val miBundleTel:Bundle=Bundle()
                miBundleTel.putString("Telefono",campoTelefono!!.text.toString())
                intent.putExtras(miBundleTel)

                val miBundleTipo:Bundle=Bundle()
                miBundleTipo.putString("Tipo",tipo)
                intent.putExtras(miBundleTipo)

                startActivity(intent)}

            }

            3-> {
                var rbtn1: RadioButton = findViewById(R.id.a)
                var rbtn2: RadioButton = findViewById(R.id.b)
                var rbtn3: RadioButton = findViewById(R.id.c)

                if (rbtn1.isChecked) {
                    rbtn1.isChecked = false
                } else if (rbtn2.isChecked) {
                    rbtn2.isChecked = false
                } else if (rbtn3.isChecked) {
                    rbtn3.isChecked = false
                }

                campoNombre?.setText("")
                campoApellido?.setText("")
                campoEdad?.setText("")
                campoTelefono?.setText("")
                campoProducto?.setText("")
                vUnidad?.setText("")
                cantProducto?.setText("")
                }
            }
        }

    private fun getRadioButton(){
        val radioGroup: RadioGroup = findViewById(R.id.tipo)
        var selectId = radioGroup.checkedRadioButtonId

        when (selectId) {
            R.id.a -> {
                descuento = 0.4
                tipo = "A"

            }
            R.id.b -> {
                descuento = 0.2
                tipo = "B"

            }
            R.id.c -> {
                descuento = 0.1
                tipo = "C"

            }else -> {
                descuento = 0.0
                tipo = "No seleccionado"

            }
        }
    }
    }



