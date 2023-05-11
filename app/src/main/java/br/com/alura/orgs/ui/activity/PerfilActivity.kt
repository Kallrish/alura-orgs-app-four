package br.com.alura.orgs.ui.activity

import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import br.com.alura.orgs.databinding.ActivityPerfilBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch

class PerfilActivity : UsuarioBaseActivity() {

    private val binding by lazy {
        ActivityPerfilBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        carregaInformacoesUsuario()
        configuraBotaoSair()
    }

    private fun carregaInformacoesUsuario() {
        lifecycleScope.launch {
            usuario
                .filterNotNull()
                .collect { usuarioLogado ->
                    binding.tvValorUsuarioCadastrado.text = usuarioLogado.id
                    binding.tvValorNomeUsuario.text = usuarioLogado.nome
                }
        }
    }

    private fun configuraBotaoSair() {
        binding.btnSairDoApp.setOnClickListener {
            lifecycleScope.launch {
                deslogaUsuario()
            }
        }
    }
}