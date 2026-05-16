# Rot_11
4. Atividade Prática (40 minutos)
Desafio Inicial
 Criar um aplicativo de cadastro de usuário:
 Primeira tela: Permitir que o usuário insira nome, idade e e-mail.
 Segunda tela: Exibir as informações inseridas em um resumo formatado.
 Utilizar uma Intent explícita para enviar os dados preenchidos.
Ampliação do Desafio
 Adicionar funcionalidades extras ao aplicativo:
 Permitir a edição dos dados na segunda tela e enviá-los de volta para a primeira
tela usando startActivityForResult().
 Implementar uma Intent implícita para enviar um e-mail com as informações
inseridas, usando um aplicativo de e-mail do dispositivo.
 Adicionar validação de campos obrigatórios (ex.: nome e e-mail não podem estar
vazios).
5. Encerramento e Orientações Finais (20 minutos)
 Discussão sobre as principais dificuldades enfrentadas durante a implementação da
comunicação entre Activities.
 Dicas sobre quando utilizar Intents explícitas ou implícitas.
 Orientação sobre a entrega do relatório final.
6. Orientações para o Relatório Final
Cada aluno deve produzir um relatório curto (1 a 2 páginas) contendo:
 Resumo Teórico: Explicação dos conceitos de Intents, tipos de Intents e passagem
de dados entre Activities.
 Código-Fonte Comentado: Explicação detalhada do código desenvolvido, com foco
na lógica de envio e recebimento de dados.

---

# Resolução - Relatório Final

## Resumo Teórico: Intents e Comunicação entre Activities
No Android, `Intent` é o mecanismo usado para iniciar uma nova Activity e transportar dados entre telas. Existem dois tipos principais:
- `Intent explícita`: especifica diretamente a Activity de destino e é usada para comunicação interna no aplicativo.
- `Intent implícita`: declara uma ação genérica (como enviar um e-mail) e permite ao sistema escolher um app apropriado.

O método `startActivityForResult()` permite iniciar uma Activity para obter uma resposta de volta, o que é útil para edição de dados na segunda tela. O retorno é recebido em `onActivityResult()`.

## Código-Fonte Comentado
### Enviando dados com Intent explícita
```kotlin
val intent = Intent(this, ResumoActivity::class.java)
intent.putExtra("nome", nome)
intent.putExtra("idade", idade)
intent.putExtra("email", email)
startActivity(intent)
```

### Recebendo dados na segunda tela
```kotlin
val nome = intent.getStringExtra("nome") ?: ""
val idade = intent.getStringExtra("idade") ?: ""
val email = intent.getStringExtra("email") ?: ""
```

### Editando e devolvendo dados para a primeira tela
```kotlin
val returnIntent = Intent()
returnIntent.putExtra("nome", nomeAlterado)
returnIntent.putExtra("idade", idadeAlterada)
returnIntent.putExtra("email", emailAlterado)
setResult(RESULT_OK, returnIntent)
finish()
```

### Iniciando Activity para resultado e tratando retorno
```kotlin
startActivityForResult(intent, REQUEST_CODE)
```

```kotlin
override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)
    if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
        val nome = data?.getStringExtra("nome") ?: ""
        val idade = data?.getStringExtra("idade") ?: ""
        val email = data?.getStringExtra("email") ?: ""
        // Atualizar campos na tela principal
    }
}
```

### Intent implícita para enviar e-mail
```kotlin
val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
    data = Uri.parse("mailto:")
    putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
    putExtra(Intent.EXTRA_SUBJECT, "Dados de cadastro")
    putExtra(Intent.EXTRA_TEXT, "Nome: $nome\nIdade: $idade\nE-mail: $email")
}
startActivity(emailIntent)
```

## Conclusão
O relatório mostra como usar Intents explícitas para trocar dados entre telas e Intents implícitas para acionar recursos externos, como um app de e-mail. A validação de campos obrigatórios garante que nome e e-mail não sejam enviados em branco.
