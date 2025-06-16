import java.util.ArrayList;
import java.util.List;

public class SimpleBlockchain {
    public static List<Block> blockchain = new ArrayList<>();
    public static int prefix = 4; // dificuldade da mineração (número de zeros no início do hash)

    public static void main(String[] args) {
        // Cria o bloco gênesis
        Block genesisBlock = new Block("Bloco Gênesis", "0");
        genesisBlock.mineBlock(prefix);
        blockchain.add(genesisBlock);

        System.out.println("Blockchain iniciada com o bloco gênesis.");
        System.out.println("Novos blocos serão criados a cada 3 segundos...");

        while (true) {
            try {
                Thread.sleep(3000); // espera 3 segundos
            } catch (InterruptedException e) {
                System.err.println("Thread interrompida: " + e.getMessage());
                break;
            }

            String nomeGerado = GeradorNomes.proximoNome();
            Block novoBloco = new Block(nomeGerado, blockchain.get(blockchain.size() - 1).getHash());
            System.out.println("Criando bloco com nome: " + nomeGerado);
            novoBloco.mineBlock(prefix);
            blockchain.add(novoBloco);

            System.out.println("Blockchain válida? " + isChainValid());
            System.out.println("Número total de blocos: " + blockchain.size());
            System.out.println("-----------------------------------------");
        }
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
