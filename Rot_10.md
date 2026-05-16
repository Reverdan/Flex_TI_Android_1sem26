# Rot_10
4. Atividade Prática (40 minutos)
Desafio Inicial
 Criar um aplicativo que registre o tempo total em que o usuário interage com a
Activity:
 Iniciar a contagem de tempo em onResume().
 Pausar a contagem em onPause().
 Exibir o tempo total de interação ao destruir a Activity (no método onDestroy()).
Ampliação do Desafio
 Adicionar funcionalidades extras ao aplicativo:
 Salvar o tempo de interação usando SharedPreferences, mesmo que o aplicativo
seja fechado.
 Exibir um Toast personalizado em cada evento do ciclo de vida, informando o
estado atual da Activity.
 Criar uma nova tela (Activity) que receba o tempo total e exiba um resumo da
interação.
5. Encerramento e Orientações Finais (20 minutos)
 Discussão sobre as principais dificuldades encontradas durante a implementação.
 Dicas sobre como evitar vazamentos de memória e problemas comuns no ciclo de
vida das Activities.
 Orientação sobre a entrega do relatório final
6. Orientações para o Relatório Final
Cada aluno deve produzir um relatório curto (1 a 2 páginas) contendo:
 Resumo Teórico: Explicação detalhada das fases do ciclo de vida da Activity e suas
funções.
 Código-Fonte Comentado: Explicação do código desenvolvido, destacando os
métodos de ciclo de vida implementados

---

# Resolução - Relatório Final

## Resumo Teórico: Ciclo de Vida da Activity
O ciclo de vida de uma Activity define como o Android gerencia sua criação, exibição, pausa e destruição. Os métodos principais são:
- `onCreate()`: inicializa a Activity e define a interface.
- `onResume()`: chamada quando a Activity passa a interagir com o usuário.
- `onPause()`: chamada quando a Activity deixa de estar em primeiro plano.
- `onDestroy()`: chamada antes da Activity ser destruída, ideal para liberar recursos.

Neste projeto, o tempo de interação é medido entre `onResume()` e `onPause()`, e o resultado é exibido em `onDestroy()`.

## Código-Fonte Comentado
### Exemplo de Activity com contagem de tempo
```kotlin
class TempoActivity : AppCompatActivity() {
    private var tempoInicial: Long = 0
    private var tempoTotal: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tempo)
    }

    override fun onResume() {
        super.onResume()
        tempoInicial = System.currentTimeMillis()
        Toast.makeText(this, "Activity em primeiro plano", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        tempoTotal += System.currentTimeMillis() - tempoInicial
        Toast.makeText(this, "Activity em segundo plano", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        salvarTempoTotal(tempoTotal)
        Toast.makeText(this, "Activity destruída. Tempo total: ${tempoTotal / 1000}s", Toast.LENGTH_LONG).show()
        iniciarResumoActivity(tempoTotal)
    }

    private fun salvarTempoTotal(valor: Long) {
        val prefs = getSharedPreferences("tempo_prefs", Context.MODE_PRIVATE)
        prefs.edit().putLong("tempo_total", valor).apply()
    }

    private fun iniciarResumoActivity(tempo: Long) {
        val intent = Intent(this, ResumoTempoActivity::class.java)
        intent.putExtra("tempo_total", tempo)
        startActivity(intent)
    }
}
```

## Conclusão
Este relatório descreve a contagem de tempo de uso da Activity e mostra como salvar dados com `SharedPreferences` para manter o valor mesmo após o aplicativo ser fechado. A apresentação do resumo em outra tela e os `Toast` em cada evento do ciclo de vida ajudam a reforçar a interação com o usuário.
