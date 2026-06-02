import com.agenda.modelo.Contato;
import com.agenda.modelo.ContatoDAO;
import com.agenda.modelo.Endereco;

public class TesteInsert {
    public static void main(String[] args) {
        Contato c1 = new Contato();
        c1.setNome("Gisele");
        c1.setEmail("gigi@email.com");

        Endereco e1 = new Endereco();
        e1.setLogradouro("Rua ABC, 123");
        e1.setCidade("RJ");
        e1.setContato(c1);

        c1.adicionarEndereco(e1);

        ContatoDAO dao = new ContatoDAO();
        dao.gravar(c1);
    }
}
