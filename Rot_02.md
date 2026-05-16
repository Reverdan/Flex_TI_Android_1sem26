Atividade Prática (40 minutos) Desafio Inicial
ƒ Criar uma lista com nomes de pessoas:
ƒ Inclusão de nomes na lista.
ƒ Remoção de nomes da lista.
5. Ampliação do Desafio
ƒ Alterar as informações para conter um conjunto nome, idade.
5. Encerramento e Orientações Finais (20 minutos)
ƒ Discussão sobre as dificuldades enfrentadas durante a atividade prática.
ƒ Orientação sobre a entrega do relatório final.
6. Orientações para o Relatório Final
Cada aluno deve produzir um relatório curto (1 a 2 páginas) contendo:
ƒ Resumo Teórico: Definir e explicar os conceitos de variáveis, operadores e estruturas
condicionais.
ƒ Código-Fonte Comentado: Explicação de cada parte do código desenvolvido,
destacando o uso das estruturas condicionais.

---

# Resolução - Relatório Final

## Resumo Teórico
Para a construção de algoritmos e aplicativos estruturados, apoiamo-nos em conceitos essenciais da programação (como visto na fundamentação do projeto "Primo" abordado em aula):
- **Variáveis**: São espaços reservados na memória para armazenar dados temporários. Elas precisam de um tipo bem definido (ex: `String nome` para textos ou `int idade` para números inteiros) e permitem que o programa "lembre" e manipule as informações fornecidas pelo usuário.
- **Operadores**: São símbolos que realizam ações ou verificações sobre as variáveis. Existem os **aritméticos** (como `+` ou `-`), os **relacionais** (como `==` para verificar igualdade, `>` para verificar se é maior) e os **lógicos** (como `&&` para exigir que duas condições sejam verdadeiras e `||` para caso uma ou outra seja verdadeira).
- **Estruturas Condicionais**: Representam as tomadas de decisão lógicas do sistema. Através de blocos `if` (se) e `else` (senão), o programa pode desviar o fluxo de execução para validar dados (como impedir a adição de idades negativas) ou tratar casos específicos, conferindo robustez ao código.

## Código-Fonte Comentado
Abaixo, apresentamos a implementação do gerenciamento de uma lista de pessoas (contemplando o desafio ampliado: nome e idade), baseando-se nos conceitos teóricos de variáveis, operadores e estruturas de decisão ensinados na disciplina.

### 1. Classe de Domínio (`Pessoa.java`)
Define a entidade Pessoa, utilizando **variáveis** para armazenar suas características.

```java
public class Pessoa {
    // Variáveis que armazenam as características do conjunto
    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() { return nome; }
    public int getIdade() { return idade; }
}
```

### 2. Lógica do Gerenciamento da Lista (`GerenciadorPessoas.java`)
Este arquivo ilustra o uso prático de **estruturas condicionais** e **operadores** na inclusão e remoção de nomes e idades da lista.

```java
import java.util.ArrayList;
import java.util.List;

public class GerenciadorPessoas {
    // Variável que guarda a lista de objetos do tipo Pessoa
    private List<Pessoa> listaPessoas = new ArrayList<>();
    // Variável para feedback visual ao usuário
    private String mensagem; 

    // Método para Inclusão na lista
    public void adicionarPessoa(String nome, int idade) {
        // Estrutura Condicional 1: Validação dos dados de entrada
        // O operador relacional '<=' impede que idades inválidas avancem.
        // O operador lógico '||' (OU) e o método trim() checam se o nome está vazio.
        if (nome == null || nome.trim().isEmpty() || idade <= 0) {
            mensagem = "Erro: Nome não pode ser vazio e a idade deve ser maior que 0!";
            return; // Encerra a execução precocemente, impedindo a inclusão inválida
        }

        // Se passou pela condição acima (dados válidos), adiciona a pessoa
        listaPessoas.add(new Pessoa(nome, idade));
        mensagem = "Pessoa adicionada com sucesso!";
    }

    // Método para Remoção da lista
    public void removerPessoa(String nomeBusca) {
        // Laço de repetição percorrendo todos os itens da lista
        for (int i = 0; i < listaPessoas.size(); i++) {
            
            // Estrutura Condicional 2: Verificação de Igualdade
            // O código checa se o nome atual da lista é igual ao nome buscado
            if (listaPessoas.get(i).getNome().equalsIgnoreCase(nomeBusca)) {
                listaPessoas.remove(i); // Remove a pessoa pelo índice
                mensagem = "Pessoa removida da lista!";
                return; // Encerra a execução pois a pessoa já foi encontrada e removida
            }
        }
        
        // Estrutura atingida apenas se o `if` acima nunca for satisfeito em nenhum item
        mensagem = "Pessoa não encontrada na lista para remoção.";
    }
}
```

### Análise do Uso das Estruturas Condicionais
No projeto desenvolvido acima, a lógica reflete os mesmos princípios aplicados e ensinados em aula: sem o uso dos blocos de decisão `if`, a aplicação aceitaria o cadastro de informações corrompidas (idades negativas ou nomes em branco) e tentaria remover elementos sem uma confirmação lógica, o que poderia causar quebras (*crashes*) da aplicação. As condicionais atuam, portanto, como a "regra de negócio" principal e a camada de segurança para a manipulação dos dados (inclusão/remoção) dentro das listas.
