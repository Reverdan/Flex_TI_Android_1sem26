# Rot_06
4. Atividade Prática (40 minutos)
Desafio Inicial
 Criar um aplicativo que leia dois campos na tela e um botão:
 Ao clicar no botão, realize a soma dos valores dos dois campos.
Ampliação do Desafio
 Adicionar funcionalidades extras ao aplicativo:
 Criar os botões de subtração, multiplicação, divisão e resto.
5. Encerramento e Orientações Finais (20 minutos)
 Discussão sobre as principais dificuldades encontradas durante a implementação.
 Orientação sobre a entrega do relatório final
6. Orientações para o Relatório Final
Cada aluno deve produzir um relatório curto (1 a 2 páginas) contendo:
 Resumo Teórico: Explicação do uso do JetPack Compose e Widgets.
 Código-Fonte Comentado: Explicação do código desenvolvido, destacando os
métodos de ciclo de vida implementados.

---

# Resolução - Relatório Final

## Resumo Teórico: JetPack Compose e Widgets
JetPack Compose é a ferramenta moderna de criação de interface do Android que permite construir UI de forma declarativa usando funções Kotlin. Em Compose, cada elemento visual é um componente chamado `Composable`, que descreve como a tela deve aparecer com base no estado atual.

Os widgets básicos usados para este projeto incluem:
- `TextField`: campo de entrada de texto para números.
- `Button`: botão que dispara ações como somar, subtrair, multiplicar, dividir e resto.
- `Text`: texto para exibir o resultado e instruções.
- `Column` e `Row`: contêineres que organizam elementos vertical e horizontalmente.

O ciclo de vida da Activity permanece importante mesmo com Compose. No `onCreate()`, definimos o layout com `setContent {}` e inicializamos os componentes que exibem a interface.

## Código-Fonte Comentado
### Exemplo de Activity com Compose
```kotlin
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculadoraBasicaApp()
        }
    }
}
```

### Função composable principal
```kotlin
@Composable
fun CalculadoraBasicaApp() {
    var valor1 by remember { mutableStateOf("") }
    var valor2 by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(text = "Calculadora Simples", style = MaterialTheme.typography.h5)

        TextField(
            value = valor1,
            onValueChange = { valor1 = it },
            label = { Text("Número 1") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        TextField(
            value = valor2,
            onValueChange = { valor2 = it },
            label = { Text("Número 2") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = { resultado = realizarOperacao(valor1, valor2, "soma") }) {
                Text("Somar")
            }
            Button(onClick = { resultado = realizarOperacao(valor1, valor2, "subtracao") }) {
                Text("Subtrair")
            }
        }

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = { resultado = realizarOperacao(valor1, valor2, "multiplicacao") }) {
                Text("Multiplicar")
            }
            Button(onClick = { resultado = realizarOperacao(valor1, valor2, "divisao") }) {
                Text("Dividir")
            }
        }

        Button(onClick = { resultado = realizarOperacao(valor1, valor2, "resto") }) {
            Text("Resto")
        }

        Text(text = "Resultado: $resultado", style = MaterialTheme.typography.body1)
    }
}
```

### Função auxiliar para operações
```kotlin
private fun realizarOperacao(
    valor1: String,
    valor2: String,
    operacao: String
): String {
    val numero1 = valor1.toDoubleOrNull()
    val numero2 = valor2.toDoubleOrNull()

    if (numero1 == null || numero2 == null) {
        return "Digite números válidos"
    }

    if ((operacao == "divisao" || operacao == "resto") && numero2 == 0.0) {
        return "Divisão por zero não é permitida"
    }

    val resultado = when (operacao) {
        "soma" -> numero1 + numero2
        "subtracao" -> numero1 - numero2
        "multiplicacao" -> numero1 * numero2
        "divisao" -> numero1 / numero2
        "resto" -> numero1 % numero2
        else -> 0.0
    }

    return resultado.toString()
}
```

## Conclusão
Este relatório apresenta um aplicativo simples com dois campos de entrada e um conjunto de botões para realizar operações aritméticas. A solução utiliza JetPack Compose para construir a interface declarativamente e destaca a importância de validar os valores antes de executar cálculos.
