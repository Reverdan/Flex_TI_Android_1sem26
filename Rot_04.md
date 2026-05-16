# Rot_04
4. Atividade Prática (40 minutos)
Desafio Inicial
 Criar um aplicativo que permita ao usuário inserir um número e, ao pressionar um
botão, exiba a tabuada desse número (de 1 a 10) usando um laço for.
Ampliação do Desafio
 Adicionar as seguintes funcionalidades:
 Usar um laço while para exibir apenas os números pares da tabuada.
 Criar um botão que, ao ser pressionado, inicie um contador usando um laço
do-while, que será interrompido por outro botão de parada.
 Personalizar o layout do app para exibir as informações de maneira clara e organizada.
5. Encerramento e Orientações Finais (20 minutos)
 Discussão das dificuldades enfrentadas pelos alunos durante o desenvolvimento do
aplicativo.
 Dicas de boas práticas para o uso eficiente de laços de repetição.
ƒ Dicas de boas práticas para o uso eficiente de laços de repetição.
ƒ Orientação sobre a entrega do relatório final e revisão de conceitos que serão úteis
em futuras aulas.
6. Orientações para o Relatório Final
Cada aluno deve produzir um relatório curto (1 a 2 páginas) contendo:
ƒ Resumo Teórico: Explicação conceitual dos laços de repetição (for, while, do-while).
ƒ Código-Fonte Comentado: Explicação detalhada do código, destacando o
funcionamento de cada estrutura de repetição utilizada.

---

# Resolução - Relatório Final

## Resumo Teórico: Laços de Repetição
Os laços de repetição (ou *loops*) são estruturas fundamentais na programação que permitem executar o mesmo bloco de código diversas vezes até que uma condição específica seja atingida.
- **`for`**: Utilizado quando sabemos antecipadamente a quantidade exata de vezes que o laço deve ser executado. Ele concentra a inicialização da variável, a condição de parada e o incremento na mesma linha, tornando a sintaxe enxuta e ideal para contagens conhecidas (como iterar de 1 a 10 na tabuada).
- **`while`**: Utilizado quando não sabemos o número exato de repetições, mas dependemos que uma condição seja verdadeira. O bloco de código só entra no laço se a condição inicial for `true`.
- **`do-while`**: A principal diferença deste para o `while` é que o `do-while` **sempre executa o bloco de código pelo menos uma vez** antes de checar a condição de parada. É muito usado em lógicas onde a primeira execução é obrigatória antes de testar a repetição.

## Código-Fonte Comentado
Como não havia um código-base prévio para este roteiro, desenvolvemos a lógica central em Java do zero para resolver o desafio proposto, contemplando as três formas de laço de repetição.

### 1. Tabuada Completa (Uso do `for`)
Este método calcula a tabuada (do 1 ao 10) para o número inserido pelo usuário.

```java
public String gerarTabuada(int numero) {
    StringBuilder resultado = new StringBuilder();
    
    // O laço 'for' inicializa o multiplicador 'i' em 1,
    // verifica a condição (menor ou igual a 10), e aplica o incremento (i++) a cada volta.
    for (int i = 1; i <= 10; i++) {
        int produto = numero * i;
        resultado.append(numero).append(" x ").append(i).append(" = ").append(produto).append("\n");
    }
    
    return resultado.toString();
}
```

### 2. Tabuada de Resultados Pares (Uso do `while`)
Aqui utilizamos o laço `while` junto a uma condicional (`%`) para filtrar apenas os resultados que geram produtos pares (conforme exigido na ampliação).

```java
public String gerarTabuadaPares(int numero) {
    StringBuilder resultado = new StringBuilder();
    int i = 1; // A inicialização do contador precisa ser externa ao laço
    
    // O 'while' continua repetindo enquanto a condição for verdadeira
    while (i <= 10) {
        int produto = numero * i;
        
        // Estrutura condicional para incluir no resultado apenas os pares
        if (produto % 2 == 0) {
            resultado.append(numero).append(" x ").append(i).append(" = ").append(produto).append("\n");
        }
        
        i++; // O incremento deve ser feito manualmente no corpo do 'while'
    }
    
    return resultado.toString();
}
```

### 3. Contador com Botão de Parada (Uso do `do-while`)
Para o controle do contador pelos botões do aplicativo, utilizamos uma variável global (`rodandoContador`). O `do-while` garante que a contagem gire ao menos uma vez e continue apenas se a flag não for desativada pelo botão de parada.

```java
// Variável de controle global alterada pelas ações dos botões Iniciar/Parar na Interface
private boolean rodandoContador = false;
private int contador = 0;

// Método engatilhado pelo botão "Iniciar"
public void iniciarContador() {
    rodandoContador = true;
    
    // O 'do-while' executa o bloco obrigatoriamente a primeira vez
    do {
        contador++;
        System.out.println("Contador atual: " + contador);
        
        // (Em um app Android real, seria necessário usar Threads de Background
        // com um 'Thread.sleep()' para não travar a tela principal com este loop infinito).
        
    } while (rodandoContador == true); // Repete enquanto o botão de parada não for clicado
}

// Método engatilhado pelo botão "Parar"
public void pararContador() {
    // Ao clicar em parar, alteramos a flag para quebrar a condição do laço 'do-while'
    rodandoContador = false; 
}

### 4. Organização do Layout e Boas Práticas
Para um aplicativo mais claro e organizado, recomenda-se:
- Usar um campo `EditText` para entrada do número da tabuada.
- Exibir os resultados em um `TextView` ou `RecyclerView` para facilitar a leitura.
- Separar os botões de ação: um para gerar a tabuada completa, outro para tabuada dos pares e um terceiro para iniciar/parar o contador.
- Manter labels e instruções visíveis para o usuário saber quais botões correspondem a cada função.

### Discussão das Dificuldades Enfrentadas
- Compreender a diferença entre `for`, `while` e `do-while` pode ser confuso no início, especialmente porque todos realizam repetições.
- Ao usar `while`, é preciso lembrar de inicializar o contador antes do laço e incrementá-lo dentro do corpo, caso contrário o programa entra em loop infinito.
- O `do-while` exige atenção porque ele executa o bloco pelo menos uma vez, o que é útil para contadores iniciados antes de uma condição ser verificada.
- Em uma aplicação real, o contador contínuo precisa de cuidado para não travar a interface, exigindo o uso de threads ou tarefas assíncronas.

### Conclusão
Este relatório conclui a resolução de `Rot_04.md` apresentando as três estruturas de repetição pedidas no desafio: `for` para a tabuada completa, `while` para filtrar resultados pares e `do-while` para o contador controlado por botões.
A explicação detalhada do código mostra como cada laço de repetição funciona e como aplicar boas práticas de organização para deixar o app mais claro e funcional.
```