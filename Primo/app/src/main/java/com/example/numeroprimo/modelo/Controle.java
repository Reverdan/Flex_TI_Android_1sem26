package com.example.numeroprimo.modelo;

public class Controle extends AbsPropriedades
{
    public Controle(String numero)
    {
        this.numero = numero;
        Executar();
    }

    private void Executar()
    {
        this.mensagem = "";
        Validacao validacao = new Validacao(this.numero);
        if (validacao.getMensagem().equals(""))
        {
            Primo primo = new Primo(validacao.getNum());
            this.mensagem = primo.getMensagem();
        }
        else
        {
            this.mensagem = validacao.getMensagem();
        }
    }
}
