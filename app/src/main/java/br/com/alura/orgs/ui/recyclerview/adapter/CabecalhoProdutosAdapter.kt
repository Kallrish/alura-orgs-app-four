package br.com.alura.orgs.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.orgs.databinding.CabecalhoUsuarioBinding
import br.com.alura.orgs.databinding.ProdutoItemBinding
import br.com.alura.orgs.extensions.formataParaMoedaBrasileira
import br.com.alura.orgs.extensions.tentaCarregarImagem
import br.com.alura.orgs.model.Produto

class CabecalhoProdutosAdapter(
    private val context: Context,
    usuario: List<String?> = emptyList(),
) : RecyclerView.Adapter<CabecalhoProdutosAdapter.ViewHolder>() {

    private val usuarios = usuario.toMutableList()

    class ViewHolder(
        private val binding: CabecalhoUsuarioBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        private lateinit var produto: Produto

        fun vincula(usuario: String?) {
            binding.cabecalhoUsuarioId.text = usuario
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding = CabecalhoUsuarioBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val usuario = if(usuarios[position].isNullOrBlank())
            "Sem usuário"
        else usuarios[position]
        holder.vincula(usuario)
    }

    override fun getItemCount() = usuarios.size

}
