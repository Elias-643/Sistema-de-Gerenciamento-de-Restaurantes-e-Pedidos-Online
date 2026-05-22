import java.util.ArrayList;
import java.util.Scanner;

// Cadastro do Cliente
class Cliente {
    String nomeCliente;
    int idadeCliente;
}

// Classe que representa um Prato
class Prato {
    String nome;
    double preco;
    String descricao;
    String observacao;

    public Prato(String nome, double preco, String descricao, String observacao) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.observacao = observacao;
    }

    public Prato(String nome, double preco, String descricao) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return nome + " - R$ " + String.format("%.2f", preco) + "\nDescrição: " + descricao;
    }
}

// Classe Restaurante
class Restaurante {
    String nome;
    String cnpj;
    ArrayList<Prato> cardapio;

    public Restaurante(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.cardapio = new ArrayList<>();
    }

    public void adicionarPrato(String nome, double preco, String descricao, String observacao) {
        cardapio.add(new Prato(nome, preco, descricao, observacao));
    }

    public void adicionarPrato(String nome, double preco, String descricao) {
        cardapio.add(new Prato(nome, preco, descricao));
    }

    public void exibirCardapio() {
        System.out.println("\n--- Cardápio: " + nome + " ---\n");
        for (int i = 0; i < cardapio.size(); i++) {
            System.out.println((i + 1) + ". " + cardapio.get(i));
            System.out.println();
        }
        // Opção 0 exibida no final do cardápio para o usuário saber que pode voltar
        System.out.println("0. Voltar para a seleção de restaurantes\n");
    }
}

public class Pedido {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" ");
        System.out.println("Olá, seja bem-vindo!");
        System.out.println(" ");

        // Solicitar nome do cliente (String)
        System.out.print("Digite seu nome: ");
        String nomeCliente = scanner.nextLine();

        // Solicitar idade do cliente (Inteiro)
        System.out.print("Digite sua idade: ");
        int idadeCliente = scanner.nextInt();

        scanner.nextLine(); // limpa o ENTER --> O Scanner espera o cliente digitar a resposta (CPF) //

        String CPF = "";

        System.out.print("Deseja informar seu CPF? (sim/não): ");
        String resposta = scanner.nextLine();

        if (resposta.equalsIgnoreCase("sim")) {
            System.out.print("Digite seu CPF (sem pontuação): ");
            CPF = scanner.nextLine();
            // Remove pontos e traços caso o usuário os tenha digitado mesmo assim
            CPF = CPF.replaceAll("[.-]", "");
        }

        ArrayList<Restaurante> restaurantes = new ArrayList<>();

        // ========================== RESTAURANTE 1 ==========================
        Restaurante r1 = new Restaurante("Sabor Caseiro", "15246307984201");
        r1.adicionarPrato("Feijoada", 35.0, "Feijão preto com carnes, arroz, farofa e couve.");
        r1.adicionarPrato("Arroz + Carne", 25.0, "Arroz branco acompanhado de carne grelhada.");
        r1.adicionarPrato("Macarronada", 28.0, "Macarrão ao molho de tomate com queijo ralado.");
        r1.adicionarPrato("Frango Assado", 30.0, "Frango assado temperado com ervas especiais.");
        r1.adicionarPrato("Strogonoff de Carne", 32.0, "Carne ao molho cremoso com arroz e batata palha.");
        r1.adicionarPrato("Strogonoff de Frango", 29.0, "Frango ao molho cremoso acompanhado de arroz.");
        r1.adicionarPrato("Peixe Frito", 40.0, "Filé de peixe crocante servido com salada.");
        r1.adicionarPrato("Purê com Carne", 27.0, "Purê de batata cremoso com carne acebolada.");
        r1.adicionarPrato("Bife Acebolado", 31.0, "Bife grelhado com cebolas caramelizadas.");
        r1.adicionarPrato("Escondidinho", 33.0, "Purê recheado com carne seca e queijo gratinado.");

        // ========================== RESTAURANTE 2 ==========================
        Restaurante r2 = new Restaurante("King Sushi", "16429874023568");
        r2.adicionarPrato("Temaki", 25.0, "Cone de alga recheado com salmão e cream cheese.");
        r2.adicionarPrato("Combinado", 80.0, "Seleção variada de sushi e sashimi.");
        r2.adicionarPrato("Hot Roll", 35.0, "Sushi empanado e frito recheado com salmão.");
        r2.adicionarPrato("Sashimi", 45.0, "Fatias frescas de peixe cru selecionado.");
        r2.adicionarPrato("Uramaki", 32.0, "Sushi enrolado com arroz por fora.");
        r2.adicionarPrato("Yakissoba", 40.0, "Macarrão oriental com legumes e carne.");
        r2.adicionarPrato("Hossomaki", 28.0, "Sushi fino recheado com peixe e arroz.");
        r2.adicionarPrato("Nigiri", 30.0, "Bolinho de arroz coberto com peixe fresco.");
        r2.adicionarPrato("Barca Sushi", 120.0, "Grande seleção de peças servidas em barca.");
        r2.adicionarPrato("Guioza", 22.0, "Pastel japonês recheado com carne suína.");

        // ========================== RESTAURANTE 3 ==========================
        Restaurante r3 = new Restaurante("Sanduba", "14562389745847");
        r3.adicionarPrato("Hambúrguer", 20.0, "Hambúrguer artesanal com queijo e salada.");
        r3.adicionarPrato("Batata Frita", 15.0, "Porção de batatas fritas crocantes.");
        r3.adicionarPrato("X-Burguer", 22.0, "Pão, carne, queijo e molho especial.");
        r3.adicionarPrato("X-Salada", 24.0, "Hambúrguer com queijo, alface e tomate.");
        r3.adicionarPrato("X-Bacon", 28.0, "Hambúrguer artesanal com bacon crocante.");
        r3.adicionarPrato("Cachorro Quente", 18.0, "Pão, salsicha, molho e batata palha.");
        r3.adicionarPrato("Misto Quente", 12.0, "Sanduíche de queijo e presunto tostado.");
        r3.adicionarPrato("Onion Rings", 16.0, "Anéis de cebola empanados e fritos.");
        r3.adicionarPrato("Combo Família", 60.0, "Lanches e batatas para compartilhar.");
        r3.adicionarPrato("Refrigerante 2L", 14.0, "Refrigerante gelado de dois litros.");

        // ========================== RESTAURANTE 4 ==========================
        Restaurante r4 = new Restaurante("Bob's", "10245013650142");
        r4.adicionarPrato("Milk Shake de Morango", 20.0, "Milk shake cremoso sabor morango.");
        r4.adicionarPrato("Sorvete de Chocolate com Baunilha", 10.0, "Sorvete misto de chocolate e baunilha.");
        r4.adicionarPrato("Milk Shake de Ovomaltine", 24.0, "Milk shake especial com Ovomaltine.");
        r4.adicionarPrato("Big Bob", 32.0, "Hambúrguer especial com molho da casa.");
        r4.adicionarPrato("Bob's Burger", 25.0, "Hambúrguer clássico com queijo e salada.");
        r4.adicionarPrato("Batata Média", 14.0, "Porção média de batata frita.");
        r4.adicionarPrato("Combo Bob's", 38.0, "Hambúrguer, batata e refrigerante.");
        r4.adicionarPrato("Cascão de Chocolate", 9.0, "Sorvete no cascão coberto com chocolate.");
        r4.adicionarPrato("Sundae de Morango", 11.0, "Sorvete com calda de morango.");
        r4.adicionarPrato("Refrigerante Lata", 7.0, "Refrigerante gelado em lata.");

        // ========================== RESTAURANTE 5 ==========================
        Restaurante r5 = new Restaurante("Happy Food", "10245010258142");
        r5.adicionarPrato("Pizza de Calabresa", 50.0, "Pizza recheada com calabresa e cebola.");
        r5.adicionarPrato("Pizza de Frango", 50.0, "Pizza de frango desfiado com queijo.");
        r5.adicionarPrato("Pizza de Bacon", 50.0, "Pizza coberta com bacon crocante.");
        r5.adicionarPrato("Pizza de Quatro Queijos", 50.0, "Mistura especial de quatro queijos.");
        r5.adicionarPrato("Pizza de Marguerita", 50.0, "Pizza tradicional com tomate e manjericão.");
        r5.adicionarPrato("Pizza Portuguesa", 55.0, "Pizza com presunto, ovos e cebola.");
        r5.adicionarPrato("Pizza de Camarão", 65.0, "Pizza especial recheada com camarões.");
        r5.adicionarPrato("Pizza de Atum", 58.0, "Pizza sabor atum com cebola.");
        r5.adicionarPrato("Pizza de Chocolate", 45.0, "Pizza doce coberta com chocolate.");
        r5.adicionarPrato("Pizza de Carne de Sol", 70.0, "Pizza nordestina com carne de sol e queijo.");

        // ========================== RESTAURANTE 6 ==========================
        Restaurante r6 = new Restaurante("Tomatto's", "30216458794510");
        r6.adicionarPrato("Lasanha de Frango", 30.0, "Lasanha recheada com frango ao molho.");
        r6.adicionarPrato("Lasanha de Carne", 30.0, "Lasanha tradicional de carne moída.");
        r6.adicionarPrato("Pastel de Queijo", 15.0, "Pastel crocante recheado com queijo.");
        r6.adicionarPrato("Pastel de Queijo com Presunto", 17.0, "Pastel recheado com queijo e presunto.");
        r6.adicionarPrato("Fricassê de Frango", 20.0, "Frango desfiado ao creme de milho.");
        r6.adicionarPrato("Macarrão ao Molho Branco", 35.0, "Macarrão ao molho branco cremoso.");
        r6.adicionarPrato("Nhoque", 28.0, "Nhoque de batata ao molho especial.");
        r6.adicionarPrato("Panqueca de Carne", 26.0, "Panqueca recheada com carne moída.");
        r6.adicionarPrato("Rondelli", 40.0, "Massa recheada ao molho gratinado.");
        r6.adicionarPrato("Espaguete à Bolonhesa", 32.0, "Espaguete com molho bolonhesa tradicional.");

        restaurantes.add(r1);
        restaurantes.add(r2);
        restaurantes.add(r3);
        restaurantes.add(r4);
        restaurantes.add(r5);
        restaurantes.add(r6);

        // Variáveis do pedido
        ArrayList<String> pedido = new ArrayList<>();
        ArrayList<String> observacoes = new ArrayList<>();
        ArrayList<Double> precosPedidos = new ArrayList<>();
        ArrayList<Integer> quantidades = new ArrayList<>();
        String continuar = "";
        double total = 0;

        do {
            System.out.println("\nEscolha um restaurante:");
            for (int i = 0; i < restaurantes.size(); i++) {
                System.out.println((i + 1) + ". " + restaurantes.get(i).nome);
            }

            int escolhaRestaurante = scanner.nextInt() - 1;

            scanner.nextLine();

            if (escolhaRestaurante >= 0 && escolhaRestaurante < restaurantes.size()) {
                Restaurante escolhido = restaurantes.get(escolhaRestaurante);
                escolhido.exibirCardapio();

                System.out.print("Escolha o número do prato (ou 0 para voltar): ");
                int escolhaPrato = scanner.nextInt() - 1;

                scanner.nextLine();

                if (escolhaPrato == -1) {
                    System.out.println("\nVoltando para a seleção de restaurantes...");
                    System.out.print("Deseja continuar comprando? (sim/não): ");
                    continuar = scanner.nextLine();
                    continue;
                }

                if (escolhaPrato >= 0 && escolhaPrato < escolhido.cardapio.size()) {
                    Prato prato = escolhido.cardapio.get(escolhaPrato);

                    int quantidade = 0;
                    while (quantidade < 1) {
                        System.out.print("Quantas unidades deseja? ");
                        quantidade = scanner.nextInt();

                        scanner.nextLine();

                        if (quantidade < 1) {
                            System.out.println("Quantidade inválida. Digite pelo menos 1.");
                        }
                    }

                    System.out.print("Deseja adicionar uma observação ao pedido? (sim/nao) ");
                    String obsDigitada = scanner.nextLine();

                    if (obsDigitada.trim().isEmpty() || obsDigitada.equalsIgnoreCase("nao")) {
                        obsDigitada = "Nenhuma";
                    } else if (obsDigitada.equalsIgnoreCase("sim")) {
                        System.out.print("Digite a observação (Ex.: sem cebola): ");
                        obsDigitada = scanner.nextLine();                        
                    }

                    double subtotal = prato.preco * quantidade;

                    pedido.add(prato.nome);
                    observacoes.add(obsDigitada);
                    precosPedidos.add(prato.preco);
                    quantidades.add(quantidade);
                    total += subtotal;

                    System.out.println("\n--- Item adicionado! ---");
                    System.out.println("Prato: " + prato.nome);
                    System.out.println("Quantidade: " + quantidade);
                    System.out.printf("Subtotal: R$ %.2f%n", subtotal);
                    System.out.println("Obs: " + obsDigitada);

                } else {
                    System.out.println("Prato inválido.");
                }

            } else {
                System.out.println("Restaurante inválido.");
            }

            System.out.print("\nDeseja fazer mais pedidos? (sim/não): ");
            continuar = scanner.nextLine();

        } while (continuar.equalsIgnoreCase("sim"));

        System.out.println(" ");
        String avaliacao = "";
        // Pergunta sobre avalição do cliente
        System.out.print("Quer deixar sua avaliação? (sim/não): ");
        String respostaavaliacao = scanner.nextLine();

        // Se responder sim
        if (respostaavaliacao.equalsIgnoreCase("sim")) {

            System.out.print("Digite um comentário sobre a sua avaliação (sem acentuação): ");
            avaliacao = scanner.nextLine();
        }

        // Se responder "não", cancela tudo e encerra sem exibir nenhum dado.
        System.out.println(" ");
        System.out.print("Deseja efetuar seu pedido? (sim/não): ");
        String confirmacao = scanner.nextLine();

        if (!confirmacao.equalsIgnoreCase("sim")) {
            System.out.println("\nPedido cancelado. Nenhuma compra foi realizada.");
            System.out.println("Obrigado pela visita, " + nomeCliente + "!");
            scanner.close();
            return; // encerra o programa sem imprimir o resumo
        }

        // ========================== RESUMO FINAL ==========================
        System.out.println(" ");
        System.out.println("\n========== DADOS DO CLIENTE ===========");
        System.out.println("Nome: " + nomeCliente);
        System.out.println("Idade: " + idadeCliente);

        if (!CPF.isEmpty()) {
            System.out.println("CPF: " + CPF);
        } else {
            System.out.println("CPF: Não informado");
        }

        if (!avaliacao.isEmpty()) {
            System.out.println("Avaliação: " + avaliacao);
        } else {
            System.out.println("Avaliação: Não informado");
        }

        System.out.println("\n========================================");
        System.out.println("           RESUMO DO PEDIDO");
        System.out.println("========================================");

        for (int i = 0; i < pedido.size(); i++) {
            int qtd = quantidades.get(i);
            double preco = precosPedidos.get(i);

            System.out.println("Item " + (i + 1) + ": " + pedido.get(i));
            System.out.printf("Valor unitário: R$ %.2f%n", preco);
            System.out.println("Quantidade: " + qtd);
            System.out.printf("Subtotal: R$ %.2f%n", preco * qtd);
            System.out.println("Observação: " + observacoes.get(i));
            System.out.println("----------------------------------------");
        }

        System.out.printf("VALOR TOTAL: R$ %.2f%n", total);
        System.out.println("========================================");
        System.out.println("Obrigado pela preferência!");
        System.out.println(" ");

        scanner.close();
    }
}