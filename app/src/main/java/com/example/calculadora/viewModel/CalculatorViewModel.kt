package com.example.calculadora.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import net.objecthunter.exp4j.ExpressionBuilder

class CalculatorViewModel : ViewModel() {

    var result: String = ""

    private val input = MutableLiveData("")
    val inputText: LiveData<String> = input

    private val output = MutableLiveData("")
    val outPutText: LiveData<String> = output

    fun onDigitButtonPressed(digit: String) {
        input.value += digit
    }

    fun onOperatorButtonPressed(operator: String) {
        if (result == "") {
            result = input.value.toString()
            input.value += " $operator "
        } else {
            val expression = input.value.toString()

            val result = ExpressionBuilder(expression).build().evaluate()
            output.value = String.format("%.2f", result)
            input.value = "${output.value} $operator "
        }
    }

    fun onClearCButtonPressed() {
        input.value = ""
        output.value = ""
        result = ""
    }

    fun onBackspace() {
        input.value = input.value?.dropLast(1)
    }

    fun onMudarSinal() {
        if (result == "") {
            input.value = (input.value?.toDouble())?.times((-1.0)).toString()
        } else {
            input.value = (result?.toDouble())?.times((-1.0)).toString()
        }
    }

    fun onEqualsButtonPressed() {
        val expression = input.value.toString()

        result = String.format("%.2f",ExpressionBuilder(expression).build().evaluate())

        output.value = result
    }
}
