# PingSweep-Java
Este programa de "ping sweep" foi desenvolvido em Java, utilizando conceitos como ArrayLists e objetos, além da implementação de classes. A utilização de ArrayLists permitiu uma estrutura dinâmica para armazenar e manipular os endereços IP da rede durante a varredura.

# Ping Sweep em Java

Este programa Java é um "ping sweep" desenvolvido para verificar a atividade dos hosts em uma rede. Ele percorre uma faixa de endereços IP e verifica quais hosts estão acessíveis na rede.

## Como usar

1. **Compilação:**
   - Certifique-se de ter o JDK (Java Development Kit) instalado em seu sistema.
   - Abra o terminal e navegue até o diretório onde o arquivo `PingSweep.java` está localizado.
   - Compile o programa digitando o seguinte comando:
     ```
     javac PingSweep.java
     ```

2. **Execução:**
   - Após a compilação, execute o programa digitando o seguinte comando:
     ```
     java PingSweep
     ```
   - O programa solicitará que você insira o endereço IP inicial. Insira o endereço IP que deseja iniciar a varredura.

3. **Resultado:**
   - O programa percorrerá os endereços IP na faixa especificada e exibirá quais estão acessíveis e quais estão inacessíveis.
   - Ao final, será exibida uma lista com os endereços IP acessíveis.

## Observações

- Certifique-se de fornecer um endereço IP válido para iniciar a varredura.
- O programa utiliza ICMP Echo Request para verificar a acessibilidade dos hosts, portanto, pode ser necessário permissões de administrador/root dependendo do sistema operacional.
- O tempo de resposta pode variar dependendo da rede e da quantidade de hosts na faixa especificada.

## Código

```java
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

public class PingSweep {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Solicitação do endereço IP
        System.out.println("Digite o endereço IP inicial:");
        String ip = input.next();

        // Lista para armazenar os endereços IP acessíveis
        ArrayList<String> ipAdressArray = new ArrayList<>();

        // Loop para percorrer os 255 endereços IP
        for (int i = 1; i <= 255; i++) {
            // Construção do endereço IP apagando a última letra
            String ipAddress = ip.substring(0, ip.length() - 1) + i;

            try {
                // Resolução do endereço IP
                InetAddress address = InetAddress.getByName(ipAddress);

                // Verificação da acessibilidade do endereço
                if (address.isReachable(5000)) {
                    System.out.println(address + " está acessível");
                    ipAdressArray.add(address + " está acessível");
                } else {
                    System.out.println(address + " está inacessível");
                }
            } catch (UnknownHostException | IOException e) {
                // Exceção em caso de erro na resolução do endereço
                throw new RuntimeException(e);
            }
        }

        // Exibição dos endereços IP acessíveis
        System.out.println("\nEndereços acessíveis:");
        for (String ipAddress : ipAdressArray) {
            System.out.println(ipAddress);
        }
    }
}
