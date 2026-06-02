package com.agenda.modelo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;

import java.util.ArrayList;
import java.util.List;

public class ContatoDAO {
    //DAO --> Data Acess Object (Objeto de acesso ao dados)
    private EntityManager em;
    private EntityManagerFactory emf;

    public ContatoDAO(){
        //AgendaPU --> foi definido dentro do arquivo persistence.xml
        this.emf = Persistence.createEntityManagerFactory("AgendaPU");
        this.em = this.emf.createEntityManager();
    }

    public void gravar(Contato contato){
        try{
            em.getTransaction().begin();
            em.persist(contato);
            em.getTransaction().commit();
            System.out.println("Contato gravado com sucesso!");
        }catch(PersistenceException e){
            System.out.println("Falha ao gravar: " + e);
            em.getTransaction().rollback();
        }finally{
            em.close();//Fecha a conexao com EntityManager
        }
    }

    public List<Contato> buscarTodos(){
        List<Contato> lista =  em.createQuery("SELECT c FROM Contato c",
                Contato.class).getResultList();

        em.close();//Fecha a conexao com EntityManager

        return lista;
    }
}