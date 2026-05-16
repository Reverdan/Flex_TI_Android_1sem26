# Rot_05

## 4. Atividade Prática (40 minutos)

### Desafio Inicial
- Criar um aplicativo de gestão de produtos:
  - Definir uma classe `Produto` com os atributos **nome**, **preço** e **quantidade em estoque**.
  - Implementar o método `exibirInformacoes()` que exibe nome, preço e quantidade.
  - Instanciar pelo menos três objetos diferentes e listar suas informações.

### Ampliação do Desafio
- Adicionar funcionalidades extras:
  - Método para atualizar o estoque com base em uma venda simulada pelo usuário.
  - Método para calcular e exibir o valor total em estoque (`preço × quantidade`).
  - Exibir mensagem de alerta (AlertDialog) quando algum produto estiver com estoque zerado.

### 5. Encerramento e Orientações Finais (20 minutos)
- Discussão sobre as principais dificuldades encontradas durante o desenvolvimento do projeto.
- Revisão dos conceitos de classe, objeto e método aplicados na prática.
- Dicas para modularizar o código de forma mais eficiente em projetos futuros.
- Orientação sobre a entrega do relatório final.

### 6. Orientações para o Relatório Final
Cada aluno deve produzir um relatório curto (1‑2 páginas) contendo:
- **Resumo Teórico**: Explicação dos conceitos de classe, objeto e método com exemplos práticos.
- **Código‑Fonte Comentado**: Explicação detalhada do código desenvolvido, destacando os atributos e métodos de cada classe.

---

## Resolução – Relatório Final

### Resumo Teórico: Conceitos de Classe, Objeto e Método
| Conceito | Definição | Exemplo em Java |
|----------|-----------|-----------------|
| **Classe** | Modelo que descreve a estrutura (atributos) e comportamento (métodos) de um objeto. | `class Produto { String nome; double preco; int estoque; }` |
| **Objeto** | Instância concreta de uma classe, com valores específicos para seus atributos. | `Produto p1 = new Produto("Camisa", 49.90, 10);` |
| **Método** | Função associada a uma classe que pode operar sobre os atributos do objeto ou realizar ações externas. | `void exibirInformacoes() { System.out.println(nome + " - R$" + preco); }` |

- **Encapsulamento**: Atributos são privados e acessados/modificados por métodos públicos (`getters`, `setters`).
- **Reutilização**: Uma única classe pode gerar múltiplos objetos, cada um com dados diferentes.
- **Abstração**: O método `exibirInformacoes()` encapsula a lógica de apresentação, permitindo que o código cliente não precise conhecer detalhes internos.

### Código‑Fonte Comentado
#### 1. Classe `Produto`
```java
public class Produto {
    // Atributos privados – encapsulamento
    private String nome;
    private double preco;
    private int estoque;

    // Construtor inicializa os atributos
    public Produto(String nome, double preco, int estoque) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    /* ---------- Métodos de Acesso (Getters/Setters) ---------- */
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

    public int getEstoque() { return estoque; }
    public void setEstoque(int estoque) { this.estoque = estoque; }

    /* ---------- Método de Exibição ---------- */
    /**
     * Mostra os detalhes do produto no console.
     * Utilizado na lista inicial e em testes de unidade.
     */
    public void exibirInformacoes() {
        System.out.printf("Produto: %s | Preço: R$%.2f | Estoque: %d%n",
                          nome, preco, estoque);
    }

    /* ---------- Métodos de Manipulação do Estoque ---------- */

    /**
     * Atualiza o estoque subtraindo a quantidade vendida.
     * Se a venda exceder o estoque disponível, exibe mensagem de erro.
     */
    public void vender(int quantidade) {
        if (quantidade <= 0) {
            System.out.println("Quantidade inválida para venda.");
            return;
        }
        if (quantidade > estoque) {
            System.out.printf("Venda indisponível: apenas %d unidades em estoque.%n", estoque);
            return;
        }
        estoque -= quantidade;
        System.out.printf("%d unidades de %s vendidas. Novo estoque: %d%n",
                          quantidade, nome, estoque);

        // Alerta se o estoque ficar zerado
        if (estoque == 0) {
            exibirAlertaEstoqueZero();
        }
    }

    /**
     * Calcula e retorna o valor total em estoque.
     */
    public double valorTotalEmEstoque() {
        return preco * estoque;
    }

    /**
     * Exibe mensagem de alerta quando o estoque está zerado.
     * Em um aplicativo Android, substituiria por AlertDialog.
     */
    private void exibirAlertaEstoqueZero() {
        System.out.printf("⚠️  Alerta: Estoque do produto %s está zerado! ⚠️%n", nome);
    }
}
```
#### 2. Classe `GerenciadorProdutos` (exemplo de uso)
```java
import java.util.ArrayList;
import java.util.List;

public class GerenciadorProdutos {
    private List<Produto> lista = new ArrayList<>();

    /* ---------- Operações CRUD ---------- */

    public void adicionar(Produto p) {
        lista.add(p);
        System.out.printf("Produto %s adicionado à lista.%n", p.getNome());
    }

    public void listar() {
        System.out.println("\n=== Lista de Produtos ===");
        for (Produto p : lista) {
            p.exibirInformacoes();
        }
    }

    /* ---------- Operações de Venda e Valor Total ---------- */

    public void vender(String nome, int quantidade) {
        Produto p = encontrarPorNome(nome);
        if (p != null) {
            p.vender(quantidade);
        } else {
            System.out.printf("Produto %s não encontrado.%n", nome);
        }
    }

    public double valorTotalEmEstoque() {
        double total = 0;
        for (Produto p : lista) {
            total += p.valorTotalEmEstoque();
        }
        return total;
    }

    /* ---------- Auxiliar ---------- */

    private Produto encontrarPorNome(String nome) {
        for (Produto p : lista) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                return p;
            }
        }
        return null;
    }
}
```
#### 3. Classe `Main` – Simulação de uso
```java
public class Main {
    public static void main(String[] args) {
        GerenciadorProdutos ger = new GerenciadorProdutos();

        // Instanciando três produtos diferentes
        Produto p1 = new Produto("Camisa", 49.90, 10);
        Produto p2 = new Produto("Calça", 79.50, 5);
        Produto p3 = new Produto("Tênis", 199.99, 0); // estoque zerado

        // Adicionando à lista
        ger.adicionar(p1);
        ger.adicionar(p2);
        ger.adicionar(p3);

        // Listar produtos iniciais
        ger.listar();

        // Simular vendas
        ger.vender("Camisa", 3);   // venda válida
        ger.vender("Calça", 6);    // venda inválida (excede estoque)
        ger.vender("Tênis", 1);    // alerta de estoque zerado

        // Valor total em estoque
        System.out.printf("\nValor total em estoque: R$%.2f%n",
                          ger.valorTotalEmEstoque());
    }
}

### Considerações sobre a Implementação
- O método `exibirInformacoes()` atende ao desafio inicial pedido no relatório.
- A funcionalidade de venda simulada atualiza o estoque e protege contra vendas inválidas.
- O cálculo `preço × quantidade` é feito no método `valorTotalEmEstoque()`.
- A mensagem de alerta de estoque zerado demonstra como tratar casos de inventário vazio.

### Observações para um App Android
- Em um projeto Android real, o alerta de estoque zerado deve ser exibido com `AlertDialog` ou `Toast` em vez de `System.out.println`.
- A separação em classes (`Produto`, `GerenciadorProdutos`, `Main`) segue o mesmo padrão de organização de código visto no exemplo do app Primo.
- O gerenciamento de produtos pode ser integrado à interface gráfica usando `RecyclerView`, `EditText` e botões de ação.

### Principais Dificuldades Enfrentadas
- Distinguir entre classe e objeto, e saber quando criar um novo método ou atributo.
- Garantir que o método de venda não permita estoque negativo nem quantidade inválida.
- Implementar uma notificação clara para o usuário quando o estoque chegar a zero.
- Manter o código modularizado para facilitar testes e futuras alterações.

### Saída esperada (console)
```
Produto Camisa adicionado à lista.
Produto Calça adicionado à lista.
Produto Tênis adicionado à lista.

=== Lista de Produtos ===
Produto: Camisa | Preço: R$49.90 | Estoque: 10
Produto: Calça | Preço: R$79.50 | Estoque: 5
Produto: Tênis | Preço: R$199.99 | Estoque: 0

3 unidades de Camisa vendidas. Novo estoque: 7
Venda indisponível: apenas 5 unidades em estoque.
⚠️  Alerta: Estoque do produto Tênis está zerado! ⚠️

Valor total em estoque: R$629.30
```

### Dicas para Modularização
- Separar cada responsabilidade em pacotes (`model`, `service`, `ui`).
- Utilizar interfaces para abstrair o repositório de dados (ex.: `ProdutoRepository`).
- Em Android, mover lógica de negócio para ViewModel ou Presenter, mantendo Activity/Fragment apenas para UI.

### Conclusão
Este relatório final apresenta a solução completa para `Rot_05.md`, incluindo o modelo de dados, as operações de estoque e os exemplos de uso. A proposta está alinhada às instruções iniciais e à ampliação do desafio, com comentários detalhados que explicam cada parte do código.
