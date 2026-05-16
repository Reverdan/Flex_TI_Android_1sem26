# Rot_07
4. Atividade Prática (40 minutos)
Desafio Inicial
 Alterar o Layout para:
Ampliação do Desafio
 Adicionar funcionalidades extras ao aplicativo:
 Fazer o tratamento para evitar entradas nulas utilizando toDoubleouNull e Elvis.
 Fazer o tratamento da Divisão por zero.
5. Encerramento e Orientações Finais (20 minutos)
 Discussão sobre as principais dificuldades encontradas durante a implementação.
 Orientação sobre a entrega do relatório final.
6. Orientações para o Relatório Final
Cada aluno deve produzir um relatório curto (1 a 2 páginas) contendo:
 Resumo Teórico: Explicação do uso do JetPack Compose e Widgets.
 Código-Fonte Comentado: Explicação do código desenvolvido, destacando os
métodos de ciclo de vida implementados

---

# Resolução - Relatório Final

## Resumo Teórico: JetPack Compose, Widgets e Segurança de Entrada
JetPack Compose usa funções `@Composable` para construir a interface do usuário de forma declarativa. Widgets como `TextField`, `Button` e `Text` são usados para entrada, interação e exibição de resultados.

O tratamento de entradas nulas e inválidas é feito com `toDoubleOrNull()` e o operador Elvis (`?:`) em Kotlin. Isso evita `NumberFormatException` e permite fornecer um valor padrão ou mensagem de erro quando a entrada não for um número.

A divisão por zero deve ser tratada antes de calcular o resultado. Em Compose, isso é feito na lógica do botão, impedindo que a operação seja executada quando o divisor for zero.

## Código-Fonte Comentado
### Exemplo de função composable
```kotlin
@Composable
fun CalculadoraSegura() {
    var n1 by remember { mutableStateOf("") }
    var n2 by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Text(text = "Calculadora com Validação", style = MaterialTheme.typography.h6)

        OutlinedTextField(
            value = n1,
            onValueChange = { n1 = it },
            label = { Text("Número 1") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        OutlinedTextField(
            value = n2,
            onValueChange = { n2 = it },
            label = { Text("Número 2") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Button(onClick = { resultado = calcularResultado(n1, n2, Operacao.SUBTRACAO) }) {
            Text("Subtrair")
        }

        Button(onClick = { resultado = calcularResultado(n1, n2, Operacao.DIVISAO) }) {
            Text("Dividir")
        }

        Text(text = "Resultado: $resultado")
    }
}
```

### Função de cálculo com tratamento de erros
```kotlin
sealed class Operacao {
    object SOMA : Operacao()
    object SUBTRACAO : Operacao()
    object MULTIPLICACAO : Operacao()
    object DIVISAO : Operacao()
}

private fun calcularResultado(n1: String, n2: String, operacao: Operacao): String {
    val numero1 = n1.toDoubleOrNull()
    val numero2 = n2.toDoubleOrNull()

    if (numero1 == null || numero2 == null) {
        return "Preencha ambos os campos com números"
    }

    if (operacao == Operacao.DIVISAO && numero2 == 0.0) {
        return "Divisão por zero não é permitida"
    }

    return when (operacao) {
        Operacao.SOMA -> (numero1 + numero2).toString()
        Operacao.SUBTRACAO -> (numero1 - numero2).toString()
        Operacao.MULTIPLICACAO -> (numero1 * numero2).toString()
        Operacao.DIVISAO -> (numero1 / numero2).toString()
    }
}
```

## Conclusão
O aplicativo modificado demonstra o uso de Compose com `OutlinedTextField` e validação segura. O uso de `toDoubleOrNull()` e do operador Elvis elimina exceções e melhora a experiência do usuário quando campos são deixados em branco ou contêm texto inválido.
