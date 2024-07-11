import java.util.Scanner;

public class Menu {

    public void imprimeMenu() {
        int opcao = 0;
        Double valor = 0.0d;
        Cambio cambio = new Cambio();
        Scanner scanner = new Scanner(System.in);
        ConversorDeMoeda conversor = new ConversorDeMoeda();

        do {
            // https://www.exchangerate-api.com/docs/supported-currencies
            // Dolar Norte Americano - USD
            // Peso Argentino - ARS
            // Peso Colombiano - COP
            // Real Brasileiro - BRL
            System.out.println("Escolha uma das opções de conversão:\n");

            System.out.println("1. Converter Dolar ==> Real");
            System.out.println("2. Converter Real ==> Dolar ");
            System.out.println("3. Converter Dolar ==> Peso Argentino");
            System.out.println("4. Converter Peso Argentino ==> Dolar");
            System.out.println("5. Converter Dolar ==> Peso Colombiano");
            System.out.println("6. Converter Peso Colombiano ==> Dolar");
            System.out.println("7. Sair");
            System.out.println("");

            opcao = scanner.nextInt();
            if(opcao < 1 || opcao > 7) {
                System.out.println("Opção inválida!");
                break;
            }

            System.out.println("Informe o valor que deseja converter:");
            valor = scanner.nextDouble();
            cambio.setValorOrigem(valor);

            switch(opcao) {
                case 1:
                    cambio.setCodigoOrigem("USD");
                    cambio.setCodigoDestino("BRL");
                    break;
                case 2:
                    cambio.setCodigoOrigem("BRL");
                    cambio.setCodigoDestino("USD");
                    break;
                case 3:
                    cambio.setCodigoOrigem("USD");
                    cambio.setCodigoDestino("ARS");
                    break;
                case 4:
                    cambio.setCodigoOrigem("ARS");
                    cambio.setCodigoDestino("USD");
                    break;
                case 5:
                    cambio.setCodigoOrigem("USD");
                    cambio.setCodigoDestino("COP");
                    break;
                case 6:
                    cambio.setCodigoOrigem("COP");
                    cambio.setCodigoDestino("USD");
                    break;
                default:
                    System.out.println("Saindo...");
                    break;
            }
            cambio = conversor.converteMoeda(cambio);
            imprimeRetorno(cambio);
        } while (opcao < 7);
    }

    public void imprimeRetorno(Cambio cambio) {
        System.out.println(
                String.format("Com a taxa de câmbio em %s 1.00 = %s %.2f.\nO valor %s %.2f equivale a %s %.2f.",
                        cambio.getCodigoOrigem(),
                        cambio.getCodigoDestino(),
                        cambio.getCotacao(),
                        cambio.getCodigoOrigem(),
                        cambio.getValorOrigem(),
                        cambio.getCodigoDestino(),
                        cambio.getValorDestino()
                ));
    }
}
