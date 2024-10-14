import br.fatec.lp2.Person;
import br.fatec.lp2.PersonDAO;
import br.fatec.lp2.Email;
import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays; // Importa a classe Arrays para trabalhar com arrays

    public class PersonTest {

        private PersonDAO personDAO = new PersonDAO();

        // Teste para nome inválido (menos de 2 partes)
        @Test
        public void testValidaNomeComposto() {
            Person person = new Person(2, "Tiao", 2, Arrays.asList(new Email(2, "tiao@gmail.com")));
            Assert.assertEquals("O nome deve ser composto por pelo menos 2 partes e apenas letras.", personDAO.isValidToInclude(person).get(0));
        }

        // Teste para nome válido
        public void testValidacaoNome() {
            Person person = new Person(1, "Tião Troperio", 62, Arrays.asList(new Email(1, "tiao@email.com")));
            Assert.assertTrue(personDAO.isValidToInclude(person).isEmpty());
        }



        // Teste Nome com números
        @Test
        public void testValidacaoNomeMaisNumeros() {
            Person person = new Person(2, "Tiao8", 25, Arrays.asList(new Email(2, "tiao@gmail.com")));
            Assert.assertEquals("O nome deve ser composto por pelo menos 2 partes e apenas letras.", personDAO.isValidToInclude(person).get(0));
        }

        // Teste sem nome
        @Test
        public void testValidacaoSemNome() {
            Person person = new Person(2, null, 5, Arrays.asList(new Email(2, "tiao@gmail.com")));
            Assert.assertEquals("O nome deve ser composto por pelo menos 2 partes e apenas letras.", personDAO.isValidToInclude(person).get(0));
        }

        // Teste nome vazio
        @Test
        public void testValidacaoSemNomeDois() {
            Person person = new Person(2, "", 23, Arrays.asList(new Email(2, "tiao@gmail.com")));
            Assert.assertEquals("O nome deve ser composto por pelo menos 2 partes e apenas letras.", personDAO.isValidToInclude(person).get(0));
        }

        // Teste para idade inválida (menor que 1)
        @Test
        public void testValidacaoIdadeBaixa() {
            Person person = new Person(3, "Tiao Silva", 0, Arrays.asList(new Email(3, "tiao@gmail.com")));
            Assert.assertEquals("A idade deve estar no intervalo [1, 200].", personDAO.isValidToInclude(person).get(0));
        }

        // Teste para idade inválida (maior que 200)
        @Test
        public void testValidacaoIdadeMaior() {
            Person person = new Person(4, "Tiao Silva", 601, Arrays.asList(new Email(4, "tiao@gmail.com")));
            Assert.assertEquals("A idade deve estar no intervalo [1, 200].", personDAO.isValidToInclude(person).get(0));
        }

        // Teste para email inválido
        @Test
        public void testValidacaoEmialInvalido() {
            Person person = new Person(5, "Joao Pacifico", 30, Arrays.asList(new Email(5, "tiao.gmail.com.br"))); // Email inválido
            Assert.assertEquals("O nome do Email deve estar no formato \"___@___.\", com cada parte contendo pelo menos um caractere.", personDAO.isValidToInclude(person).get(0));
        }


        // Teste sem emails
        @Test
        public void testValidacaoSemEmail() {
            Person person = new Person(6, "Joao Eduardo", 40, null); // Sem email
            // Verifica se há erro para uma pessoa sem emails
            Assert.assertEquals("O objeto Person deve ter pelo menos um objeto da classe Email associado.", personDAO.isValidToInclude(person).get(0));
        }

        // Teste email vazio
        @Test
        public void testValidacaoEmailvazio() {
            Person person = new Person(5, "Tiao Souza", 25, Arrays.asList(new Email(5, ""))); // Email vazio
            Assert.assertEquals("O nome do Email deve estar no formato \"___@___.\", com cada parte contendo pelo menos um caractere.", personDAO.isValidToInclude(person).get(0));
        }
    }
