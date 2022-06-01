package sena.yamboro.db

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import sena.yamboro.db.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var vinculo : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vinculo= ActivityMainBinding.inflate(layoutInflater)
        setContentView(vinculo.root)
        vinculo.insertar.setOnClickListener(this)
        vinculo.a.setOnClickListener(this)
        vinculo.e.setOnClickListener(this)
        vinculo.l.setOnClickListener(this)

       /* vinculo.floatingActionButton.setOnClickListener{
            val nom = vinculo.nombre.text.toString()
            val ape = vinculo.nombre2.text.toString()
            val room = Room.databaseBuilder(this,BDprueva::class.java,"usuario").build()
            //Toast.makeText(this, "$nom $ape", Toast.LENGTH_SHORT).show()
        }*/
    }

    override fun onClick(v: View?) {

        when(v?.id){
            R.id.insertar -> {
                var nom: String? = null
                var apellido: String? = null
                if (TextUtils.isEmpty(vinculo.nombre.text.toString())){
                    vinculo.nombre.error = "ingrese un nombre"
                    vinculo.nombre.requestFocus()
                }else{
                    nom = vinculo.nombre.text.toString()
                }
                if (TextUtils.isEmpty(vinculo.nombre2.text.toString())){
                    vinculo.nombre2.error = "ingrese un apellido"
                    vinculo.nombre2.requestFocus()
                }else{
                    apellido = vinculo.nombre2.text.toString()
                }

                val usuarioinfo= usuario(null,nom,apellido)
                GlobalScope.launch {
                    BDprueva.getInstancia(this@MainActivity).usuarioDao().insertAll(usuarioinfo)
                }

            }
            R.id.a ->{
                mostrarinfo("bien", "bien")
            }
        }
    }
    private fun mostrarinfo(titulo: String, mensaje: String){
        val alerta= AlertDialog.Builder(this@MainActivity)
        alerta.setTitle(titulo)
        alerta.setMessage(mensaje)
        alerta.setCancelable(true)
        alerta.show()
    }
}