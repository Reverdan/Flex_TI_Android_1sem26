package com.example.numeroprimo.modelo;

public class Validacao extends AbsPropriedades
{
    public Validacao(String numero)
    {
        this.numero = numero;
        Validar();
    }

    private void Validar()
    {
        this.mensagem = "";
        try
        {
            this.num = Integer.valueOf(this.numero);
        }
        catch (NumberFormatException e)
        {
            this.mensagem = "Número inválido";
        }
    }
}
