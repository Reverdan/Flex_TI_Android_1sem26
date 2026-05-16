# Rot_08
4. Atividade Prática (40 minutos)
Desafio Inicial
 Carregar a atividade da aula anterior (Calculadora).
 Alterar o componente TextField por OutlinedTextField.
 Alterar o layout para
Ampliação do Desafio
 Fazer as seguintes alterações:
 O fundo do aplicativo na cor Cyan.
 Título com letra amarela e fundo azul ocupando toda a largura.
 Botões e o resultado com sombra
5. Encerramento e Orientações Finais (20 minutos)
 Discussão sobre as principais dificuldades encontradas durante a implementação.
 Orientação sobre a entrega do relatório final.
6. Orientações para o Relatório Final
Cada aluno deve produzir um relatório curto (1 a 2 páginas) contendo:
 Resumo Teórico: Explicação do uso do JetPack Compose e Modifiers.
 Código-Fonte Comentado: Explicação do código desenvolvido, destacando os
métodos de ciclo de vida implementados

---

# Resolução - Relatório Final

## Resumo Teórico: JetPack Compose e Modifiers
JetPack Compose permite criar interface de usuário de forma declarativa usando Kotlin. Os `Modifiers` controlam a aparência e o comportamento dos componentes, como cor, tamanho, padding, sombra, alinhamento e preenchimento.

A atividade usa `OutlinedTextField` para campos mais visíveis e `Modifier.background(Color.Cyan)` para o fundo da tela. O título com texto amarelo sobre fundo azul e botões com sombra demonstra como o Compose facilita o estilo por meio de modificadores.

## Código-Fonte Comentado
### Exemplo de composable estilizado
```kotlin
@Composable
fun CalculadoraEstilizada() {
    var n1 by remember { mutableStateOf("") }
    var n2 by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Blue)
                .padding(14.dp)
        ) {
            Text(
                text = "Calculadora Estilizada",
                color = Color.Yellow,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        OutlinedTextField(
            value = n1,
            onValueChange = { n1 = it },
            label = { Text("Número 1") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = n2,
            onValueChange = { n2 = it },
            label = { Text("Número 2") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(
                onClick = { resultado = somar(n1, n2) },
                modifier = Modifier.shadow(4.dp)
            ) {
                Text("Somar")
            }
            Button(
                onClick = { resultado = subtrair(n1, n2) },
                modifier = Modifier.shadow(4.dp)
            ) {
                Text("Subtrair")
            }
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(8.dp)
                .padding(8.dp)
        ) {
            Text(
                text = "Resultado: $resultado",
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}
```

## Conclusão
Este relatório evidencia como uma pequena alteração no layout e no estilo pode melhorar bastante a legibilidade do aplicativo. O uso de `OutlinedTextField`, cores fortes e sombras torna a interface mais moderna e organizada.
