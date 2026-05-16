# Rot_09
4. Atividade Prática (40 minutos)
Desafio Inicial
 Carregar a atividade da aula anterior (Calculadora).
 Alterar para obter:
Ampliação do Desafio
 Fazer as seguintes alterações:
 Implementar o botão “C” vermelho para limpar os campos n1 e n2.
5. Encerramento e Orientações Finais (20 minutos)
 Discussão sobre as principais dificuldades encontradas durante a implementação.
 Orientação sobre a entrega do relatório final.
6. Orientações para o Relatório Final
Cada aluno deve produzir um relatório curto (1 a 2 páginas) contendo:
 Resumo Teórico: Explicação do uso do JetPack Compose e Arranjos.
 Código-Fonte Comentado: Explicação do código desenvolvido, destacando os
métodos de ciclo de vida implementados
---

# Resolução - Relatório Final

## Resumo Teórico: JetPack Compose e Arranjos
JetPack Compose usa componentes como `Column`, `Row` e `Box` para organizar widgets na tela. Os arranjos (`Arrangement`) e o alinhamento (`Alignment`) permitem controlar o espaçamento e a posição dos elementos.

Para esta atividade, é importante:
- usar um `Row` para colocar botões lado a lado;
- usar um `Column` para empilhar campos de texto e resultados;
- usar `Arrangement.spacedBy()` para criar espaçamento uniforme entre widgets.

O botão “C” vermelho é um componente que limpa os campos e o resultado, melhorando a usabilidade da calculadora.

## Código-Fonte Comentado
### Exemplo de layout com arranjos e botão de limpar
```kotlin
@Composable
fun CalculadoraComLimpar() {
    var n1 by remember { mutableStateOf("") }
    var n2 by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(text = "Calculadora Avançada", style = MaterialTheme.typography.h6)

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

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = { resultado = somar(n1, n2) }) {
                Text("Somar")
            }
            Button(onClick = { resultado = subtrair(n1, n2) }) {
                Text("Subtrair")
            }
            Button(onClick = { resultado = multiplicar(n1, n2) }) {
                Text("Multiplicar")
            }
            Button(onClick = { resultado = dividir(n1, n2) }) {
                Text("Dividir")
            }
        }

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = { resultado = resto(n1, n2) }) {
                Text("Resto")
            }
            Button(
                onClick = {
                    n1 = ""
                    n2 = ""
                    resultado = ""
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red)
            ) {
                Text("C", color = Color.White)
            }
        }

        Text(text = "Resultado: $resultado")
    }
}
```

## Conclusão
O relatório demonstra como usar arranjos para organizar uma calculadora mais completa. A introdução do botão “C” vermelho fornece uma forma intuitiva de limpar os dados enquanto mantém a interface consistente e fácil de usar.
