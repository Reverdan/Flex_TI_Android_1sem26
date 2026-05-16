# Rot_14
4. Atividade Prática (40 minutos)
Desafio Inicial
 Criar um aplicativo de lista de tarefas (To-Do List):
 Exibir uma lista de tarefas utilizando um ArrayAdapter.
 Permitir a adição de novas tarefas com um campo de texto e um botão.
 Implementar um evento de clique que, ao clicar em uma tarefa, exiba uma
mensagem de “Tarefa concluída”.
Ampliação do Desafio
 Adicionar funcionalidades extras ao aplicativo:
 Implementar um Custom Adapter que permita exibir uma marcação visual de
tarefa concluída (ex.: texto riscado ou ícone de check).
 Adicionar um botão de remoção de tarefa ao lado de cada item da lista.
 Implementar um recurso de pesquisa (filtro) para buscar tarefas na lista
5. Encerramento e Orientações Finais (20 minutos)
 Discussão sobre as principais dificuldades encontradas na implementação de listagens
dinâmicas.
 Dicas sobre otimização de listas com muitos dados, usando RecyclerView em projetos
mais avançados.
 Orientação sobre a entrega do relatório final.
6. Orientações para o Relatório Final
Cada aluno deve produzir um relatório curto (1 a 2 páginas) contendo:
 Resumo Teórico: Explicação sobre os conceitos de ListView, Adapters e eventos de
interação.
 Código-Fonte Comentado: Explicação detalhada do código desenvolvido,
destacando a criação e personalização da lista.

---

# Resolução - Relatório Final

## Resumo Teórico: ListView, Adapters e Eventos de Interação
`ListView` é um widget que exibe uma lista de itens roláveis. O `Adapter` faz a ponte entre os dados e a interface, criando as visualizações necessárias para cada elemento.

Eventos de clique permitem reagir quando o usuário seleciona uma tarefa ou toca em um botão para remover um item. O uso de `Custom Adapter` permite aplicar um layout próprio a cada item, incluindo checkbox, texto riscado ou ícone de exclusão.

## Código-Fonte Comentado
### Exemplo de configuração de ListView com ArrayAdapter
```java
ArrayList<String> tarefas = new ArrayList<>();
ArrayAdapter<String> adapter = new ArrayAdapter<>(
    this,
    android.R.layout.simple_list_item_1,
    tarefas
);
listView.setAdapter(adapter);
```

### Adição de nova tarefa
```java
btnAdicionar.setOnClickListener(v -> {
    String tarefa = edtTarefa.getText().toString().trim();
    if (!tarefa.isEmpty()) {
        tarefas.add(tarefa);
        adapter.notifyDataSetChanged();
        edtTarefa.setText("");
    }
});
```

### Evento de clique para marcar tarefa concluída
```java
listView.setOnItemClickListener((parent, view, position, id) -> {
    String tarefa = tarefas.get(position);
    Toast.makeText(this, "Tarefa concluída: " + tarefa, Toast.LENGTH_SHORT).show();
});
```

### Remoção de tarefa com botão de item (Custom Adapter)
O `Custom Adapter` pode usar um layout com um `TextView` e um `ImageButton` de remoção. Ao clicar em remover, o item é excluído da lista e `notifyDataSetChanged()` é chamado.

### Pesquisa e filtro de tarefas
Um campo de busca pode filtrar a lista aplicando `adapter.getFilter().filter(textoBusca)` ou usando um `List<String>` auxiliar.

## Conclusão
O relatório explica como construir uma To-Do List com `ListView` e `Adapter`, incluindo itens clicáveis, remoção e filtros de pesquisa. A personalização do item permite exibir marcas visuais de tarefas concluídas e melhora a experiência do usuário.
