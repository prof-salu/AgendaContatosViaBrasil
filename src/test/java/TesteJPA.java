import com.agenda.modelo.Contato;
import com.agenda.modelo.Endereco;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TesteJPA {
    public static void main(String[] args) {
        //DAO --> Data Acess Object
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("AgendaPU");

        EntityManager em = emf.createEntityManager();

        Contato c1 = new Contato();
        c1.setNome("Juca Pereira");
        c1.setEmail("juca.pereira@email.com");

        Endereco e1 = new Endereco();
        e1.setLogradouro("Rua Peruibe, 33");
        e1.setCidade("Mesquita");
        e1.setContato(c1);

        c1.adicionarEndereco(e1);

        em.getTransaction().begin();
        try{
            em.persist(c1);
            em.getTransaction().commit();
            System.out.println("Contato gravado com sucesso!!!");
        }catch(Exception e){
            em.getTransaction().rollback();
            System.out.println("Erro: " + e.getMessage());
        }finally {
            em.close();
            emf.close();
        }
    }
}
