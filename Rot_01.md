# Rot_01

## Atividade Prática (40 minutos)

### Desafio Inicial
- Cada aluno deverá desenvolver um app básico que exiba:
  - O nome do aluno;
  - Um botão que, ao ser clicado, exiba uma mensagem personalizada (ex.: “Bem-vindo ao meu primeiro app!”).

### Ampliação do Desafio
- Personalizar o design usando diferentes layouts e cores.

## Encerramento e Orientações Finais (20 minutos)

- Discussão sobre as principais dificuldades enfrentadas pelos alunos durante a prática.
- Dicas para aprofundamento no desenvolvimento Android.
- Orientação sobre a entrega do relatório final.

## Orientações para o Relatório Final

Cada aluno deve produzir um relatório curto (1 a 2 páginas) contendo:
- Resumo teórico: Explicação sobre a evolução dos dispositivos móveis e o impacto atual.
- Código-fonte comentado: Explicação do funcionamento de cada trecho de código implementado no projeto.

---

# Resolução - Relatório Final

## Resumo Teórico: A Evolução dos Dispositivos Móveis
A evolução dos dispositivos móveis transformou radicalmente a forma como nos comunicamos e interagimos com o mundo. Inicialmente focados apenas em chamadas de voz e mensagens de texto, os aparelhos evoluíram para verdadeiros computadores de bolso (smartphones), impulsionados por sistemas operacionais robustos como o Android. Hoje, o impacto é imensurável: desde a facilitação do acesso à informação, educação e serviços financeiros, até a criação de novas economias baseadas em aplicativos (economia de plataforma). Essa onipresença conectada exige que os desenvolvedores criem soluções eficientes, acessíveis e focadas na experiência do usuário.

## Código-Fonte Comentado

### 1. Layout da Interface (`activity_main.xml`)
Este arquivo define o design do aplicativo. Ele utiliza um `LinearLayout` para organizar os elementos verticalmente, contendo um `TextView` para o nome do aluno e um `Button` personalizado com cores e layout específicos.

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout 
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:gravity="center"
    android:background="#F0F8FF"
    android:padding="16dp">

    <!-- Exibe o nome do aluno -->
    <TextView
        android:id="@+id/tvNome"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Aluno: Nome do Aluno Aqui"
        android:textSize="24sp"
        android:textStyle="bold"
        android:textColor="#333333" />

    <!-- Botão que exibirá a mensagem -->
    <Button
        android:id="@+id/btnMensagem"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="32dp"
        android:text="Clique Aqui"
        android:backgroundTint="#4CAF50"
        android:textColor="#FFFFFF" />

</LinearLayout>
```

### 2. Lógica do Aplicativo (`MainActivity.kt`)
Este arquivo contém a lógica em Kotlin para responder ao clique do botão e exibir a mensagem personalizada na tela através de um `Toast`.

```kotlin
package com.example.meuprimeiroapp

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Método chamado quando a tela (Activity) é criada
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Define o arquivo XML de layout que será exibido nesta tela
        setContentView(R.layout.activity_main)

        // Busca o botão na interface através do seu ID definido no XML
        val btnMensagem: Button = findViewById(R.id.btnMensagem)

        // Configura um ouvinte de clique para o botão
        btnMensagem.setOnClickListener {
            // Exibe uma mensagem flutuante (Toast) na tela quando o botão for clicado
            Toast.makeText(this, "Bem-vindo ao meu primeiro app!", Toast.LENGTH_SHORT).show()
        }
    }
}
```

### Principais Dificuldades Enfrentadas
Durante a prática, a principal dificuldade encontrada costuma ser o correto entendimento do fluxo de conexão entre a interface visual (XML) e a lógica de negócio (Kotlin). O conceito de instanciar elementos visuais através do `findViewById` e atribuir ouvintes de eventos (`setOnClickListener`) é fundamental, mas pode parecer um pouco abstrato inicialmente para quem está começando o desenvolvimento Android.

### Dicas para Aprofundamento
Para aprimorar os conhecimentos, recomenda-se explorar as documentações oficiais do Android Developers sobre:
- O Ciclo de Vida da Activity;
- Componentes de interface mais flexíveis usando o `ConstraintLayout`;
- Futuramente, a transição para o `Jetpack Compose`, que permite a criação de UIs de forma declarativa e mais enxuta.
