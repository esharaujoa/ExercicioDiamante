import java.util.Scanner;

public class Main {
    public static double calcularTotal(double preco, int quantidade) {
        return preco * quantidade;
    }

    public static String pegarFormaPagamento(int formaPagamento) {
        switch (formaPagamento) {
            case 1:
                return "Dinheiro";
            case 2:
                return "Cartão";

            case 3:
                return "Pix";

            default:
                return "Não existe";
        }
    }

    public static double calcularDesconto(double total, int formaPagamento) {
        switch (formaPagamento) {
            case 1:
                return total * 0.9;

            case 2:
                return total;

            case 3:
                return total * 0.95;

            default:
                System.out.println("Pagamento inválido. TentE Novamente!");
                return total;

        }
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o código do produto (Entre 1 e 5): ");
        int codigoProduto = scanner.nextInt();

        String nomeProduto = "";
        double precoProduto = 0.0;

        switch (codigoProduto) {
            case 1:
                nomeProduto = "Hambúrguer";
                precoProduto = 18.00;
                break;

            case 2:
                nomeProduto = "Pizza";
                precoProduto = 25.00;
                break;

            case 3:
                nomeProduto = "Batata frita";
                precoProduto = 12.00;
                break;

            case 4:
                nomeProduto = "Refrigerante";
                precoProduto = 8.00;
                break;


            case 5:
                nomeProduto = "Milkshake";
                precoProduto = 15.00;
                break;

            default:
                System.out.println("Erro");
                return;
        }

        System.out.println("Insira a quantidade de produtos que você  deseja: ");
        int quantidade = scanner.nextInt();
        double total = calcularTotal(precoProduto, quantidade);

        System.out.println("Escolha a forma de pagamento (1- Dinheiro, 2- Cartão ou 3 -Pix): ");
        int formaPagamento = scanner.nextInt();

        double totalComDesconto = calcularDesconto(total, formaPagamento);
        double taxaEntrega = (totalComDesconto < 40) ? 8 : 0;

        double valorFinal = totalComDesconto + taxaEntrega;

        System.out.println("Resumo do pedido");

        System.out.println("Produto escolhido: " + nomeProduto);
        System.out.println("Quantidade: " + quantidade);
        System.out.println("Valor unitário do produto: " + precoProduto);
        System.out.printf("Valor total do pedido: R$ %.2f%n", total);
        System.out.println("Forma de pagamento escolhida: " + pegarFormaPagamento(formaPagamento));
        System.out.printf("Valor com desconto aplicado: R$ %.2f%n", totalComDesconto);
        System.out.printf("Taxa de entrega: R$ %.2f%n", taxaEntrega);
        System.out.printf("Valor final do pedido: R$ %.2f%n", valorFinal);
    }

}
