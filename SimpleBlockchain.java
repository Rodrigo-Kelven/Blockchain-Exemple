import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

class Block {
    private String hash;
    private String previousHash;
    private String data;
    private long timeStamp;
    private int nonce;

    public Block(String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash();
    }

    public String calculateHash() {
        String input = previousHash + Long.toString(timeStamp) + Integer.toString(nonce) + data;
        return applySha256(input);
    }

    public void mineBlock(int prefix) {
        String prefixString = new String(new char[prefix]).replace('\0', '0');
        while (!hash.substring(0, prefix).equals(prefixString)) {
            nonce++;
            hash = calculateHash();
        }
        System.out.println("Bloco minerado: " + hash);
    }

    public String getHash() {
        return hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public static String applySha256(String input) {
        try {
            java.security.MessageDigest digest = java.security.MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(input.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

public class SimpleBlockchain {
    public static List<Block> blockchain = new ArrayList<>();
    public static int prefix = 4; // dificuldade da mineração (número de zeros no início do hash)

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Cria o bloco gênesis
        Block genesisBlock = new Block("Bloco Gênesis", "0");
        genesisBlock.mineBlock(prefix);
        blockchain.add(genesisBlock);

        System.out.println("Blockchain iniciada com o bloco gênesis.");
        System.out.println("Digite dados para novos blocos ou 'sair' para encerrar.");

        while (true) {
            System.out.print("Novo bloco dados: ");
            String dados = scanner.nextLine();

            if (dados.equalsIgnoreCase("sair")) {
                System.out.println("Encerrando programa...");
                break;
            }

            Block novoBloco = new Block(dados, blockchain.get(blockchain.size() - 1).getHash());
            novoBloco.mineBlock(prefix);
            blockchain.add(novoBloco);

            System.out.println("Blockchain válida? " + isChainValid());
            System.out.println("Número total de blocos: " + blockchain.size());
            System.out.println("-----------------------------------------");
        }

        scanner.close();
    }

    public static boolean isChainValid() {
        String prefixString = new String(new char[prefix]).replace('\0', '0');
        for (int i = 1; i < blockchain.size(); i++) {
            Block currentBlock = blockchain.get(i);
            Block previousBlock = blockchain.get(i - 1);

            if (!currentBlock.getHash().equals(currentBlock.calculateHash())) {
                System.out.println("Hash do bloco #" + i + " inválido.");
                return false;
            }

            if (!currentBlock.getPreviousHash().equals(previousBlock.getHash())) {
                System.out.println("Hash anterior do bloco #" + i + " inválido.");
                return false;
            }

            if (!currentBlock.getHash().substring(0, prefix).equals(prefixString)) {
                System.out.println("Bloco #" + i + " não está minerado corretamente.");
                return false;
            }
        }
        return true;
    }
}
