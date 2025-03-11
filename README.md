# Password Generator

Este é um simples gerador de senhas em Java que permite ao usuário escolher o tamanho da senha e se deseja incluir caracteres especiais.

## Como usar

1. Compile o código-fonte com:
   ```sh
   javac PasswordGenerator.java
   ```
2. Execute o programa com:
   ```sh
   java PasswordGenerator
   ```

## Funcionalidades

- Gera senhas seguras com letras maiúsculas, minúsculas, números e caracteres especiais (opcional).
- Utiliza `SecureRandom` para maior segurança.
- Evita padrões previsíveis ao embaralhar os caracteres gerados.

## Estrutura do Projeto

```
PasswordGenerator/
│── src/
│   └── PasswordGenerator.java
│── README.md
│── .gitignore
```

## Licença

Este projeto está sob a licença MIT.
