package com.example.numeroprimo.modelo;

public class Primo extends AbsPropriedades
{
    public Primo(int num)
    {
        this.num = num;
        Verificar();
    }

    private void Verificar()
    {
        if (num <= 1)
        {
            this.mensagem = "Não é primo";
            return;
        }
        if (num == 2)
        {
            this.mensagem = "É primo";
        }
        for (int i = 2; i < num / 2 + 1; i++)
        {
            if (num % i == 0)
            {
                this.mensagem = "Não é primo";
                return;
            }
            else
            {
                this.mensagem = "É primo";
            }
        }
    }

}
