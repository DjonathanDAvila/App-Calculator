package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.calculadora.databinding.ActivityMainBinding
import com.example.calculadora.viewModel.CalculatorViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: CalculatorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(CalculatorViewModel::class.java)
        setContentView(binding.root)

        // Eventos de clicks
        setpButtonListeners()

        // Observadores
        observe()

    }

    private fun setpButtonListeners() {
        binding.buttonUm.setOnClickListener { viewModel.onDigitButtonPressed("1") }
        binding.buttonDois.setOnClickListener { viewModel.onDigitButtonPressed("2") }
        binding.buttonTres.setOnClickListener { viewModel.onDigitButtonPressed("3") }
        binding.buttonMaisQuatro.setOnClickListener { viewModel.onDigitButtonPressed("4") }
        binding.buttonCinco.setOnClickListener { viewModel.onDigitButtonPressed("5") }
        binding.buttonSeis.setOnClickListener { viewModel.onDigitButtonPressed("6") }
        binding.buttonSete.setOnClickListener { viewModel.onDigitButtonPressed("7") }
        binding.buttonOito.setOnClickListener { viewModel.onDigitButtonPressed("8") }
        binding.buttonNove.setOnClickListener { viewModel.onDigitButtonPressed("9") }
        binding.buttonZero.setOnClickListener { viewModel.onDigitButtonPressed("0") }
        binding.buttonPonto.setOnClickListener { viewModel.onDigitButtonPressed(".") }
        binding.buttonAdicao.setOnClickListener { viewModel.onOperatorButtonPressed("+") }
        binding.buttonSubtracao.setOnClickListener { viewModel.onOperatorButtonPressed("-") }
        binding.buttonDivisao.setOnClickListener { viewModel.onOperatorButtonPressed("/") }
        binding.buttonMultiplicacao.setOnClickListener { viewModel.onOperatorButtonPressed("*") }
        binding.buttonC.setOnClickListener { viewModel.onClearCButtonPressed() }
        binding.buttonIgual.setOnClickListener { viewModel.onEqualsButtonPressed() }
        binding.buttonApagar.setOnClickListener { viewModel.onBackspace() }
        binding.buttonMaisMenos.setOnClickListener { viewModel.onMudarSinal() }

    }

    private fun observe() {
        viewModel.inputText.observe(this) {
            binding.textCarregamento.text = it
        }

        viewModel.outPutText.observe(this) {
            binding.editResultado.text = it
        }
    }
}



