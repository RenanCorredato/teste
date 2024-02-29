import br.com.alura.orgs.CardAdapter
import br.com.alura.orgs.R

// MainActivity.kt
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val dataList = listOf(
            CardData(R.drawable.image1, "Texto 1 - Cartão 1", "Texto 2 - Cartão 1"),
            CardData(R.drawable.image2, "Texto 1 - Cartão 2", "Texto 2 - Cartão 2"),
            // Adicione mais dados conforme necessário
        )

        val adapter = CardAdapter(dataList) { selectedItem ->
            // Lógica para enviar os dados para a próxima Activity
            val intent = Intent(this@MainActivity, DetalhesActivity::class.java)
            intent.putExtra("IMAGE_RESOURCE", selectedItem.imageResource)
            intent.putExtra("TEXT_1", selectedItem.text1)
            intent.putExtra("TEXT_2", selectedItem.text2)
            startActivity(intent)
        }

        recyclerView.adapter = adapter
    }
}