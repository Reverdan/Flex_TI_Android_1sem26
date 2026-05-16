# Rot_03
4. Atividade Prática (40 minutos)
Desafio Inicial
ƒ Criar um aplicativo de verificar a aprovação:
ƒ Função que recebe duas notas como parâmetros e retorna se aprovado ou não.
ƒ Exibição de uma mensagem indicando se o aluno foi aprovado (média >= 7) ou
reprovado (média < 7).
Ampliação do Desafio
ƒ Adicionar novas funcionalidades ao aplicativo:
ƒ Alterar a função para poder receber dois valores, inclusive nulo.
ƒ Em caso de duas notas iguais, possibilitar a passagem de apenas um parâmetro.
ƒ Caso a nota passada seja nula, considerar o valor 5.
5. Encerramento e Orientações Finais (20 minutos)
ƒ Discussão sobre as dificuldades encontradas na implementação das funções.
ƒ Dicas para escrever funções eficientes e evitar a duplicação de código.
ƒ Orientação para a entrega do relatório final.
6. Orientações para o Relatório Final
Cada aluno deve produzir um relatório curto (1 a 2 páginas) contendo:
ƒ Resumo Teórico: Explicação clara dos conceitos de função, parâmetros e valores de
retorno.
ƒ Código-Fonte Comentado: Explicação detalhada do código desenvolvido, com foco
nas funções criadas e sua chamada no aplicativo.

---

# Resolução - Relatório Final

## Resumo Teórico
Na programação, a organização e o reaproveitamento de código são fundamentais. Para isso, utilizamos:
- **Funções (ou Métodos)**: São blocos de código isolados que realizam uma tarefa específica. Uma função permite que a mesma lógica seja reutilizada em várias partes do aplicativo sem precisarmos reescrever o código inteiro, ajudando a evitar a duplicação e facilitando a manutenção.
- **Parâmetros**: São as "portas de entrada" de uma função. Eles funcionam como variáveis locais através das quais passamos informações e dados externos para que a função possa trabalhar. Por exemplo, ao calcular uma média, as duas notas são repassadas ao sistema através dos parâmetros.
- **Valores de Retorno**: Representam a "porta de saída" da função. Após processar os dados recebidos, a função pode devolver um resultado útil ao trecho de código que a invocou (utilizando a palavra-chave `return`). Uma função pode retornar texto, números, objetos ou até mesmo não retornar nada (tipo `void`).

## Código-Fonte Comentado
Abaixo está a implementação da classe que resolve o desafio proposto em Java, contemplando as ampliações de tratamento de valores nulos e passagem de apenas um parâmetro (utilizando um conceito da orientação a objetos chamado **Sobrecarga de Métodos**).

### Lógica de Aprovação (`VerificadorAprovacao.java`)

```java
public class VerificadorAprovacao {

    // Função Principal: Recebe duas notas (A classe 'Double' permite receber valores nulos)
    // O tipo de retorno esperado da função é uma 'String' (texto)
    public String verificarAprovacao(Double nota1, Double nota2) {
        
        // Tratamento do desafio ampliado: Caso a nota seja nula, consideramos o valor 5.0
        if (nota1 == null) {
            nota1 = 5.0;
        }
        if (nota2 == null) {
            nota2 = 5.0;
        }
        
        // Chama uma função auxiliar repassando as notas já tratadas e retorna o resultado dela
        return calcularResultado(nota1, nota2);
    }

    // Função 2 (Sobrecarga): Permite a passagem de apenas um parâmetro em caso de notas iguais.
    // Perceba que tem o mesmo nome da função acima, mas recebe uma quantidade diferente de parâmetros.
    public String verificarAprovacao(Double notaUnica) {
        
        // Tratamento do desafio: Caso seja nula, converte para 5.0 logo de início
        if (notaUnica == null) {
            notaUnica = 5.0;
        }
        
        // Reaproveita a Função Principal, passando a mesma nota duas vezes para evitar repetição de código
        return verificarAprovacao(notaUnica, notaUnica);
    }

    // Função Auxiliar Privada: Realiza a lógica matemática de aprovação
    // Usamos tipos primitivos (double) nos parâmetros pois os métodos acima já eliminaram os valores nulos
    private String calcularResultado(double n1, double n2) {
        // Cálculo da média aritmética
        double media = (n1 + n2) / 2.0;
        
        // Estrutura de decisão para verificar se o aluno está aprovado
        if (media >= 7.0) {
            return "Aprovado (Média: " + media + ")"; // Valor de retorno de sucesso
        } else {
            return "Reprovado (Média: " + media + ")"; // Valor de retorno de falha
        }
    }
}
```

### Análise e Construção de Funções Eficientes
Neste código, aplicamos as boas práticas para evitar **duplicação de código** e garantir eficiência. 

A função de `verificarAprovacao` foi desmembrada. A função com um parâmetro (sobrecarga) resolve a requisição de "notas iguais" direcionando a execução para a função de dois parâmetros. Essa delegação significa que, se precisarmos alterar o critério das notas nulas no futuro, só precisaremos mexer em um lugar.

Além disso, isolamos a matemática do cálculo e os `returns` de texto em uma terceira função `calcularResultado()`. Assim, as lógicas de tratamento de valores nulos e de regras de negócio (cálculo da média e situação final do aluno) não se misturam em uma função enorme e ilegível, mantendo o código modular e de fácil expansão.
