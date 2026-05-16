# Rot_13
4. Atividade Prática (40 minutos)
Desafio Inicial
 Criar um aplicativo de calculadora simples:
 Campos de texto para inserir dois números.
 Quatro botões: Somar, Subtrair, Multiplicar, Dividir.
 Exibição do resultado em uma TextView.
 Implementação de tratamento de exceções para evitar erros (ex.: divisão por
zero).
Ampliação do Desafio
 Adicionar funcionalidades extras ao aplicativo:
 Limitar a entrada dos campos de texto a apenas números usando a propriedade
inputType=“number”.
 Utilizar RelativeLayout ou ConstraintLayout para criar um design mais organizado
e adaptável.
 Implementar uma função que registre e exiba o histórico de operações em uma
lista (ListView ou RecyclerView)
5. Encerramento e Orientações Finais (20 minutos)
 Discussão sobre as principais dificuldades encontradas na implementação dos
widgets e eventos.
 Dicas para melhorar a usabilidade da interface e as boas práticas no design de layouts.
 Orientação sobre a entrega do relatório final.
6. Orientações para o Relatório Final
Cada aluno deve produzir um relatório curto (1 a 2 páginas) contendo:
 Resumo Teórico: Explicação sobre os conceitos de widgets, layouts e manipulação
de eventos.
 Código-Fonte Comentado: Explicação detalhada do código desenvolvido, com foco
na lógica de interação entre os componentes

---

# Resolução - Relatório Final

## Resumo Teórico: Widgets, Layouts e Eventos
Widgets são elementos de interface como `EditText`, `Button` e `TextView`. Layouts definem a organização desses widgets na tela, e a manipulação de eventos consiste em responder a cliques e entrada do usuário.

Neste caso, a calculadora usa dois campos de texto para entrada de números e botões para cada operação. A proteção contra divisão por zero e o uso de `inputType="number"` aumentam a robustez do aplicativo.

## Código-Fonte Comentado
### Exemplo em XML de layout com `inputType`
```xml
<EditText
    android:id="@+id/edtNumero1"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:inputType="numberDecimal"
    android:hint="Número 1" />

<EditText
    android:id="@+id/edtNumero2"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:inputType="numberDecimal"
    android:hint="Número 2" />

<Button
    android:id="@+id/btnSomar"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Somar" />
```

### Exemplo em Kotlin para tratar operações e histórico
```kotlin
val edtNumero1: EditText = findViewById(R.id.edtNumero1)
val edtNumero2: EditText = findViewById(R.id.edtNumero2)
val txtResultado: TextView = findViewById(R.id.txtResultado)
val lstHistorico: ListView = findViewById(R.id.lstHistorico)

val historico = mutableListOf<String>()
val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, historico)
lstHistorico.adapter = adapter

btnSomar.setOnClickListener {
    val n1 = edtNumero1.text.toString().toDoubleOrNull()
    val n2 = edtNumero2.text.toString().toDoubleOrNull()
    if (n1 == null || n2 == null) {
        txtResultado.text = "Digite números válidos"
        return@setOnClickListener
    }
    val resultado = n1 + n2
    txtResultado.text = resultado.toString()
    historico.add("$n1 + $n2 = $resultado")
    adapter.notifyDataSetChanged()
}

btnDividir.setOnClickListener {
    val n1 = edtNumero1.text.toString().toDoubleOrNull()
    val n2 = edtNumero2.text.toString().toDoubleOrNull()
    if (n1 == null || n2 == null) {
        txtResultado.text = "Digite números válidos"
        return@setOnClickListener
    }
    if (n2 == 0.0) {
        txtResultado.text = "Divisão por zero inválida"
        return@setOnClickListener
    }
    val resultado = n1 / n2
    txtResultado.text = resultado.toString()
    historico.add("$n1 / $n2 = $resultado")
    adapter.notifyDataSetChanged()
}
```

## Conclusão
Este relatório demonstra a aplicação de widgets e eventos para criar uma calculadora simples, com tratamento de erros e histórico de operações. O uso de `inputType` e exceções evita entradas inválidas e melhora a usabilidade.
