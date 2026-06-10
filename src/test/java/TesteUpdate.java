import com.agenda.modelo.Contato;
import com.agenda.modelo.ContatoDAO;
import com.agenda.modelo.Endereco;

public class TesteUpdate {
    public static void main(String[] args) {
        Contato contato = new Contato();
        contato.setId(1);
        contato.setNome("Juca Pereira");
        contato.setEmail("pereira.juca@email.com");

        Endereco e = new Endereco();
        //e.setId(2);
        e.setLogradouro("Praça dos Brigadeiros Amargos, 350");
        e.setCidade("Mesquita");
        e.setContato(contato);
        contato.adicionarEndereco(e);

        ContatoDAO dao = new ContatoDAO();
        dao.editar(contato);
    }
}
