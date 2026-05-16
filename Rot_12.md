# Rot_12
4. Atividade Prática (40 minutos)
Desafio Inicial
 Criar um aplicativo de perfil de usuário:
 Utilizar LinearLayout para organizar as informações básicas (nome, e-mail,
telefone).
 Usar RelativeLayout para posicionar uma foto de perfil ao lado das informações.
 Exibir um botão de “Editar Perfil” centralizado na parte inferior da tela.
Ampliação do Desafio
 Melhorar a interface com as seguintes funcionalidades:
 Usar ConstraintLayout para tornar o design mais flexível e responsivo para diferentes
tamanhos de tela.
 Adicionar campos de edição com EditText e um botão de salvar que atualize as
informações exibidas na tela.
 Implementar um recurso que mostre um alerta (AlertDialog) ao salvar as alterações
com sucesso.
5. Encerramento e Orientações Finais (20 minutos)
 Discussão sobre as principais dificuldades encontradas na criação dos layouts.
 Dicas sobre boas práticas de design responsivo e acessibilidade.
 Orientação sobre a entrega do relatório final.
6. Orientações para o Relatório Final
Cada aluno deve produzir um relatório curto (1 a 2 páginas) contendo:
 Resumo Teórico: Explicação sobre os conceitos de LinearLayout, RelativeLayout e
ConstraintLayout, destacando suas principais diferenças e usos.
 Código-Fonte Comentado: Explicação detalhada do código desenvolvido,
destacando a estrutura dos layouts e suas propriedades

---

# Resolução - Relatório Final

## Resumo Teórico: LinearLayout, RelativeLayout e ConstraintLayout
No Android, `LinearLayout` organiza elementos em sequência na vertical ou horizontal. É simples de usar e útil para estruturas lineares.

`RelativeLayout` posiciona elementos em relação a outros componentes ou às bordas do pai, permitindo layouts mais flexíveis do que o `LinearLayout`.

`ConstraintLayout` é a opção mais poderosa e responsiva, pois permite criar relações de posicionamento entre componentes usando restrições (`constraints`). Ele facilita a adaptação a diferentes tamanhos de tela.

## Código-Fonte Comentado
### Exemplo com LinearLayout
```xml
<LinearLayout
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <TextView
        android:text="Nome"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" />

    <EditText
        android:id="@+id/edtNome"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />

    <TextView
        android:text="E-mail"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" />

    <EditText
        android:id="@+id/edtEmail"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />
</LinearLayout>
```

### Exemplo com RelativeLayout
```xml
<RelativeLayout
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="16dp">

    <ImageView
        android:id="@+id/imgPerfil"
        android:layout_width="100dp"
        android:layout_height="100dp"
        android:src="@drawable/ic_profile" />

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_toRightOf="@id/imgPerfil"
        android:orientation="vertical"
        android:paddingStart="16dp">

        <TextView
            android:text="Nome"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content" />

        <TextView
            android:text="E-mail"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content" />
    </LinearLayout>
</RelativeLayout>
```

### Exemplo com ConstraintLayout
```xml
<androidx.constraintlayout.widget.ConstraintLayout
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="16dp">

    <ImageView
        android:id="@+id/imgPerfil"
        android:layout_width="100dp"
        android:layout_height="100dp"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintStart_toStartOf="parent" />

    <TextView
        android:id="txtNome"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        app:layout_constraintTop_toTopOf="imgPerfil"
        app:layout_constraintStart_toEndOf="imgPerfil"
        app:layout_constraintEnd_toEndOf="parent"
        android:text="Nome: João" />

    <Button
        android:id="btnEditar"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Editar Perfil"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent" />
</androidx.constraintlayout.widget.ConstraintLayout>
```

## Conclusão
O relatório mostra como cada tipo de layout atende a necessidades diferentes: `LinearLayout` para estruturas simples, `RelativeLayout` para posicionamento relativo e `ConstraintLayout` para designs responsivos e adaptáveis a diferentes dispositivos.
