import java.security.SecureRandom;
import java.util.Scanner;

/**
 * Classe que implementa um gerador de senhas seguras.
 * O usuário pode escolher o tamanho da senha e se deseja incluir caracteres especiais.
 */
public class PasswordGenerator {
    
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+<>?/";
    private static final SecureRandom random = new SecureRandom();

    /**
     * Método principal para interação com o usuário.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite o tamanho da senha: ");
        int length = scanner.nextInt();
        
        System.out.print("Incluir caracteres especiais? (true/false): ");
        boolean useSpecialChars = scanner.nextBoolean();
        
        String password = generatePassword(length, useSpecialChars);
        System.out.println("Senha gerada: " + password);
        
        scanner.close();
    }
    
    /**
     * Gera uma senha segura baseada nas preferências do usuário.
     * 
     * @param length O tamanho da senha desejada.
     * @param useSpecialChars Se deve incluir caracteres especiais.
     * @return Uma senha gerada aleatoriamente.
     */
    public static String generatePassword(int length, boolean useSpecialChars) {
        if (length < 4) {
            throw new IllegalArgumentException("A senha deve ter pelo menos 4 caracteres.");
        }
        
        String characterPool = UPPERCASE + LOWERCASE + DIGITS;
        if (useSpecialChars) {
            characterPool += SPECIAL_CHARACTERS;
        }
        
        StringBuilder password = new StringBuilder();
        
        // Garante que a senha tenha pelo menos um de cada tipo de caractere necessário
        password.append(UPPERCASE.charAt(random.nextInt(UPPERCASE.length())));
        password.append(LOWERCASE.charAt(random.nextInt(LOWERCASE.length())));
        password.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
        if (useSpecialChars) {
            password.append(SPECIAL_CHARACTERS.charAt(random.nextInt(SPECIAL_CHARACTERS.length())));
        }
        
        // Preenche o restante da senha com caracteres aleatórios
        for (int i = password.length(); i < length; i++) {
            password.append(characterPool.charAt(random.nextInt(characterPool.length())));
        }
        
        // Embaralha os caracteres para evitar previsibilidade
        return shuffleString(password.toString());
    }
    
    /**
     * Embaralha os caracteres de uma string para aumentar a aleatoriedade.
     * 
     * @param input A string a ser embaralhada.
     * @return Uma nova string com os caracteres em ordem aleatória.
     */
    private static String shuffleString(String input) {
        char[] characters = input.toCharArray();
        for (int i = characters.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            char temp = characters[i];
            characters[i] = characters[j];
            characters[j] = temp;
        }
        return new String(characters);
    }
}
