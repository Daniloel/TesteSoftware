package br.fatec.lp2;


import java.util.ArrayList;
import java.util.List;


public class PersonDAO {
    private List<Person> persons = new ArrayList<>();

    //Salvar uma pessoa
//    public void save(Person person) {
//        persons.add(person);
//        System.out.println("Pessoa salva: " + person.getName());
//
//    }

    // Método para verificar se a pessoa é válida para inclusão
    public List<String> isValidToInclude(Person person) {
        List<String> validacao = new ArrayList<>(); // Lista para armazenar erros de validação

        // Validação do nome
        if (person.getName() == null || person.getName().trim().isEmpty() || !isValidName(person.getName())) {
            validacao.add("O nome deve ser composto por pelo menos 2 partes e apenas letras.");
        }

        // Validação da idade
        if (person.getAge() < 1 || person.getAge() > 200) {
            validacao.add("A idade deve estar no intervalo [1, 200].");
        }

        // Validação dos emails
        if (person.getEmails() == null || person.getEmails().isEmpty()) {
            validacao.add("O objeto Person deve ter pelo menos um objeto da classe Email associado.");
        } else {
            // Verifica cada email na lista
            for (Email email : person.getEmails()) {
                if (!isValidEmail(email.getName())) {
                    validacao.add("O nome do Email deve estar no formato \"___@___.\", com cada parte contendo pelo menos um caractere.");
                }
            }
        }
        return validacao;
    }

    // Método para validar se o nome tem pelo menos duas partes e é composto apenas por letras
    private boolean isValidName(String name) {
        String[] parts = name.trim().split("\\s+"); // Divide o nome em partes
        if (parts.length < 2) {
            return false;
        }
        // Verifica se cada parte do nome contém apenas letras
        for (String part : parts) {
            if (!part.matches("[A-Za-z]+")) {
                return false; // Se alguma parte não for apenas letras, retorna falso
            }
        }
        return true;
    }

    // Método para validar o formato do email
    private boolean isValidEmail(String email) {
        return email.matches(".+@.+\\..+");
    }
}

