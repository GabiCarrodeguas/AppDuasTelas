package app.unisanta.appduastelas

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import app.unisanta.appduastelas.model.produto
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
            val edtNomeP = findViewById<EditText>(R.id.edt_nome_produto)
            val edtPrecoP = findViewById<EditText>(R.id.edt_preco)
            val btnCadastrar = findViewById<Button>(R.id.btn_cadastrar)
            val fabMostra = findViewById<FloatingActionButton>(R.id.fab_mostra)
            var prod = produto("",0.0)

            btnCadastrar.setOnClickListener{

                val nome = edtNomeP.text.toString()
                val preco = edtPrecoP.text.toString().toDouble()
                prod = produto(nome,preco)
                var builder = AlertDialog.Builder(this)
                builder.setTitle("Sucesso")
                builder.setMessage("Cadastro OK")
                val dialog = builder.create()
                dialog.show()
                edtNomeP.text.clear()
                edtPrecoP.text.clear()

            }
            fabMostra.setOnClickListener{
                val intent = Intent( this,ProdutoActivity::class.java)
                intent.putExtra("produto",prod.toString())
                startActivity(intent)
            }
        }

    }
