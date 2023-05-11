package br.com.alura.orgs.ui.activity

import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.ConcatAdapter
import br.com.alura.orgs.database.AppDatabase
import br.com.alura.orgs.databinding.ActivityListaProdutosBinding
import br.com.alura.orgs.extensions.vaiPara
import br.com.alura.orgs.model.Produto
import br.com.alura.orgs.ui.recyclerview.adapter.CabecalhoProdutosAdapter
import br.com.alura.orgs.ui.recyclerview.adapter.ListaProdutosAdapter
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch


class ListaTodosProdutosActivity : UsuarioBaseActivity() {

    private val adapter = ListaProdutosAdapter(context = this)
    private val binding by lazy {
        ActivityListaProdutosBinding.inflate(layoutInflater)
    }
    private val produtoDao by lazy {
        AppDatabase.instancia(this).produtoDao()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val recyclerview = binding.activityListaProdutosRecyclerView
        lifecycleScope.launch {
            produtoDao.buscaTodos()
                .map { produtos ->
                    produtos
                        .sortedBy {
                            it.usuarioId
                        }
                        .groupBy {
                            it.usuarioId
                        }.map { produtosUsuario ->
                            criaAdapterDeProdutoComCabecalho(produtosUsuario)
                        }.flatten()
                }
                .collect { adapter ->
                    recyclerview.adapter = ConcatAdapter(adapter)
                }
        }
    }

    private fun criaAdapterDeProdutoComCabecalho(produtosUsuario: Map.Entry<String?, List<Produto>>) =
        listOf(
            CabecalhoProdutosAdapter(this, listOf(produtosUsuario.key)),
            ListaProdutosAdapter(this, produtosUsuario.value) { produtoClicado ->
                vaiPara(DetalhesProdutoActivity::class.java) {
                    putExtra(CHAVE_PRODUTO_ID, produtoClicado.id)
                }
            }
        )

}