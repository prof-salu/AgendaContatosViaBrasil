import com.agenda.modelo.ContatoDAO;

public class TesteDelete {
    public static void main(String[] args) {
        ContatoDAO dao = new ContatoDAO();
        //Apaga o contato de ID 2 caso exista no banco de dados
        dao.apagar(2);
    }
}
