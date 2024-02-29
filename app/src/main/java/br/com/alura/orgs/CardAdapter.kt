package br.com.alura.orgs

// CardAdapter.kt
class CardAdapter(
    private val dataList: List<CardData>,
    private val onItemClick: (CardData) -> Unit
) : RecyclerView.Adapter<CardAdapter.CardViewHolder>() {

    private var selectedItemPosition = RecyclerView.NO_POSITION

    inner class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val radioButton: RadioButton = itemView.findViewById(R.id.radioButton)
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val textView1: TextView = itemView.findViewById(R.id.textView1)
        val textView2: TextView = itemView.findViewById(R.id.textView2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val item = dataList[position]

        holder.radioButton.isChecked = position == selectedItemPosition

        holder.imageView.setImageResource(item.imageResource)
        holder.textView1.text = item.text1
        holder.textView2.text = item.text2

        holder.itemView.setOnClickListener {
            onItemClicked(position, item)
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    private fun onItemClicked(position: Int, item: CardData) {
        if (selectedItemPosition != position) {
            // Desmarca o item anteriormente selecionado
            notifyItemChanged(selectedItemPosition)
            // Marca o item atual como selecionado
            selectedItemPosition = position
            notifyItemChanged(position)

            // Lógica para enviar os dados para a próxima Activity
            onItemClick(item)
        }
    }
}


