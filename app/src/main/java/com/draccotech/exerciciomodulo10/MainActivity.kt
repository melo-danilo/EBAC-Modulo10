package com.draccotech.exerciciomodulo10

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputBinding
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.draccotech.exerciciomodulo10.adapter.ContactAdapter
import com.draccotech.exerciciomodulo10.databinding.ActivityMainBinding
import com.draccotech.exerciciomodulo10.models.ContactInfo
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), ContactAdapter.ContacAdapterListener {

    private lateinit var binding: ActivityMainBinding
    private var listContacts: MutableList<ContactInfo> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        createMockData()
        orderMockData()
        setupView()

    }

    fun setupView(){
        val listView = binding.recyclerContacts
        listView.layoutManager = LinearLayoutManager(binding.root.context)
        listView.adapter = ContactAdapter(listContacts, this)
    }

    private fun createMockData(){
        listContacts.addAll(
            listOf<ContactInfo>(
                ContactInfo("Ana Paula", "(11) 98765-4321"),
                ContactInfo("Bruno Silva", "(21) 99876-5432"),
                ContactInfo("Carlos Eduardo", "(19) 98765-4321"),
                ContactInfo("Daniela Santos", "(31) 99876-5432"),
                ContactInfo("Eduardo Lima", "(22) 98765-4321"),
                ContactInfo("Fernanda Oliveira", "(61) 99876-5432"),
                ContactInfo("Gabriela Castro", "(85) 98765-4321"),
                ContactInfo("Henrique Souza", "(41) 99876-5432"),
                ContactInfo("Isabela Pereira", "(27) 98765-4321"),
                ContactInfo("João Santos", "(51) 99876-5432"),
                ContactInfo("Karina Costa", "(12) 98765-4321"),
                ContactInfo("Leandro Almeida", "(32) 99876-5432"),
                ContactInfo("Marina Lima", "(24) 98765-4321"),
                ContactInfo("Nathalia Oliveira", "(62) 99876-5432"),
                ContactInfo("Otávio Carvalho", "(86) 98765-4321"),
                ContactInfo("Patricia Silva", "(42) 99876-5432"),
                ContactInfo("Rafaela Oliveira", "(28) 98765-4321"),
                ContactInfo("Samuel Santos", "(53) 99876-5432"),
                ContactInfo("Thais Castro", "(14) 98765-4321"),
                ContactInfo("Victor Souza", "(37) 99876-5432"),
                ContactInfo("Larissa Oliveira", "(71) 98765-4321"),
                ContactInfo("Marcos Santos", "(48) 99876-5432"),
                ContactInfo("Natalia Pereira", "(47) 98765-4321"),
                ContactInfo("Otavio Castro", "(83) 99876-5432"),
                ContactInfo("Paula Lima", "(88) 98765-4321"),
                ContactInfo("Ricardo Silva", "(68) 99876-5432"),
                ContactInfo("Sofia Souza", "(35) 98765-4321"),
                ContactInfo("Thiago Almeida", "(79) 99876-5432"),
                ContactInfo("Vitoria Costa", "(84) 98765-4321"),
                ContactInfo("Yasmin Santos", "(98) 99876-5432"),
                ContactInfo("Amanda Castro", "(62) 98765-4321"),
                ContactInfo("Bruna Oliveira", "(86) 99876-5432"),
                ContactInfo("Caio Pereira", "(21) 98765-4321"),
                ContactInfo("Daniel Silva", "(45) 99876-5432"),
                ContactInfo("Elaine Souza", "(31) 98765-4321"),
                ContactInfo("Fabio Almeida", "(42) 99876-5432"),
                ContactInfo("Gabriel Costa", "(51) 98765-4321"),
                ContactInfo("Helena Santos", "(28) 99876-5432"),
                ContactInfo("Igor Castro", "(54) 98765-4321"),
                ContactInfo("Jessica Lima", "(14) 99876-5432"),
                ContactInfo("Karol Pereira", "(79) 98765-4321"),
                ContactInfo("Lucas Silva", "(67) 99876-5432"),
                ContactInfo("Mariana Souza", "(21) 98765-4321"),
                ContactInfo("Natan Almeida", "(54) 99876-5432"),
                ContactInfo("Olivia Costa", "(48) 98765-4321"),
                ContactInfo("Pedro Santos", "(61) 99876-5432"),
                ContactInfo("Renata Castro", "(12) 98765-4321"),
                ContactInfo("Sabrina Oliveira", "(85) 99876-5432"),
                ContactInfo("Tulio Lima", "(22) 98765-4321"),
                ContactInfo("Valentina Pereira", "(71) 99876-5432"),
                ContactInfo("Aline Souza", "(11) 1234-5678"),
                ContactInfo("Bruno Castro", "(21) 2345-6789"),
                ContactInfo("Camila Lima", "(31) 3456-7890"),
                ContactInfo("David Santos", "(41) 4567-8901"),
                ContactInfo("Eduarda Oliveira", "(51) 5678-9012"),
                ContactInfo("Felipe Pereira", "(61) 6789-0123"),
                ContactInfo("Gabriela Costa", "(71) 7890-1234"),
                ContactInfo("Henrique Almeida", "(81) 8901-2345"),
                ContactInfo("Isabela Silva", "(91) 9012-3456"),
                ContactInfo("João Castro", "(12) 1234-5678"),
                ContactInfo("Karen Lima", "(22) 2345-6789"),
                ContactInfo("Leonardo Santos", "(32) 3456-7890"),
                ContactInfo("Maria Oliveira", "(42) 4567-8901"),
                ContactInfo("Nathalia Pereira", "(52) 5678-9012"),
                ContactInfo("Oscar Costa", "(62) 6789-0123"),
                ContactInfo("Priscila Almeida", "(72) 7890-1234"),
                ContactInfo("Quezia Silva", "(82) 8901-2345"),
                ContactInfo("Roberto Castro", "(92) 9012-3456"),
                ContactInfo("Sofia Lima", "(13) 1234-5678"),
                ContactInfo("Tomas Santos", "(23) 2345-6789"),
                ContactInfo("Ulisses Oliveira", "(33) 3456-7890"),
                ContactInfo("Victoria Pereira", "(43) 4567-8901"),
                ContactInfo("Wagner Costa", "(53) 5678-9012"),
                ContactInfo("Xavier Almeida", "(63) 6789-0123"),
                ContactInfo("Yago Silva", "(73) 7890-1234"),
                ContactInfo("Zuleide Castro", "(83) 8901-2345"),
                ContactInfo("Ana Souza", "(14) 9012-3456"),
                ContactInfo("Bernardo Lima", "(24) 1234-5678"),
                ContactInfo("Carla Santos", "(34) 2345-6789"),
                ContactInfo("Diego Oliveira", "(44) 3456-7890"),
                ContactInfo("Erica Pereira", "(54) 4567-8901"),
                ContactInfo("Fernando Costa", "(64) 5678-9012"),
                ContactInfo("Gustavo Almeida", "(74) 6789-0123"),
                ContactInfo("Heloisa Silva", "(84) 7890-1234"),
                ContactInfo("Isaac Castro", "(94) 8901-2345"),
                ContactInfo("Jéssica Souza", "(15) 9012-3456"),
                ContactInfo("Kaio Lima", "(25) 1234-5678"),
                ContactInfo("Luiz Santos", "(35) 2345-6789"),
                ContactInfo("Mariane Oliveira", "(45) 3456-7890")
            )
        )
    }

    private fun orderMockData(){
        listContacts = listContacts.sortedBy { it.name }.toMutableList()
        listContacts[0].first = true
        for(i in 0 until listContacts.size){
            if (i > 0){
                if(listContacts[i - 1].name[0] != listContacts[i].name[0]){
                    listContacts[i].first = true
                }
            }
        }

    }

    fun getCall(numero: String) {
        val uri = Uri.parse("tel:$numero")
        val intent = Intent(Intent.ACTION_DIAL, uri)
        startActivity(intent)
    }

    override fun onItemClicked(number: String) {
        getCall(number)
    }
}