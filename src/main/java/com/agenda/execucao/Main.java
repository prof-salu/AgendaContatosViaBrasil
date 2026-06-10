package com.agenda.execucao;

import com.agenda.modelo.Contato;
import com.agenda.modelo.ContatoDAO;
import com.agenda.modelo.Endereco;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int opcao = 0;

        do{
            System.out.println("Escolha uma opção: ");
            System.out.println("1- Listar contatos");
            System.out.println("2- Gravar novo contato");
            System.out.println("3- Alterar contato");
            System.out.println("4- Apagar contato");
            System.out.println("5- Encerrar agenda");
            System.out.println();
            System.out.print("Opção desejada: ");
            opcao = Integer.parseInt(entrada.nextLine());

            switch(opcao){
                case 1 -> {
                    System.out.println("***Listar contatos***");
                    ContatoDAO dao = new ContatoDAO();
                    List<Contato> lista = dao.buscarTodos();

                    if(lista.isEmpty()){
                        System.out.println("Nenhum contato cadastrado.");
                    }else{
                        for(Contato contato : lista){
                            System.out.println(contato);
                        }
                    }
                    System.out.println();
                }case 2 -> {
                    ContatoDAO dao = new ContatoDAO();
                    System.out.println("Novo contato");
                    System.out.print("Informe o nome: ");
                    String nome = entrada.nextLine();
                    System.out.print("Informe o e-mail: ");
                    String email = entrada.nextLine();
                    System.out.print("Informe o logradouro: ");
                    String logradouro = entrada.nextLine();
                    System.out.print("Informe a cidade: ");
                    String cidade = entrada.nextLine();
                    Contato c = new Contato();
                    c.setNome(nome);
                    c.setEmail(email);
                    Endereco e = new Endereco();
                    e.setLogradouro(logradouro);
                    e.setCidade(cidade);
                    e.setContato(c);
                    c.adicionarEndereco(e);

                    dao.gravar(c);
                }case 3 -> {
                    System.out.println("***Editar contato***");
                    ContatoDAO dao = new ContatoDAO();
                    System.out.print("Informe o ID:");
                    int id = Integer.parseInt(entrada.nextLine());
                    System.out.print("Informe o nome: ");
                    String nome = entrada.nextLine();
                    System.out.print("Informe o e-mail: ");
                    String email = entrada.nextLine();
                    System.out.print("Informe o logradouro: ");
                    String logradouro = entrada.nextLine();
                    System.out.print("Informe a cidade: ");
                    String cidade = entrada.nextLine();
                    Contato c = new Contato();
                    c.setNome(nome);
                    c.setEmail(email);
                    c.setId(id);
                    Endereco e = new Endereco();
                    e.setLogradouro(logradouro);
                    e.setCidade(cidade);
                    e.setContato(c);
                    c.adicionarEndereco(e);
                    dao.editar(c);
                }case 4 -> {
                    System.out.println("***Apagar contato***");
                    ContatoDAO dao = new ContatoDAO();
                    System.out.print("Informe o id: ");
                    int id = Integer.parseInt(entrada.nextLine());

                    dao.apagar(id);
                }case 5 -> {
                    System.out.println("Encerrando a aplicação");
                    entrada.close();
                }
            }
        }while(opcao != 5);
    }
}
