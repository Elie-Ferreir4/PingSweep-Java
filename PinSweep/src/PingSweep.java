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
            // Construção do endereço IP apagando a ultima letra
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
            } catch (UnknownHostException e) {
                // Exceção em caso de erro na resolução do endereço
                throw new RuntimeException(e);
            } catch (IOException e) {
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
