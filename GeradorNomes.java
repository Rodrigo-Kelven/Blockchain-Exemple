public class GeradorNomes {
    private static final String[] nomesAleatorios = {
        "Kelven", "RaelDeles", "TiagoDorgas", "WesleyMustafa", "SauloGay", "JuanMicrofone", "PedroPastor", "NicolasGordoImensoGay", "YuriMestre", "ElisRenanLindo", "MarianoCurtidas", "LuizCabuloso",
    };

    private static final String[] lista1024Nomes = new String[1024];

    static {
        for (int i = 0; i < lista1024Nomes.length; i++) {
            lista1024Nomes[i] = nomesAleatorios[i % nomesAleatorios.length];
        }
    }

    private static int indiceAtual = 0;

    // Retorna o próximo nome da lista ciclicamente
    public static String proximoNome() {
        String nome = lista1024Nomes[indiceAtual];
        indiceAtual = (indiceAtual + 1) % lista1024Nomes.length;
        return nome;
    }
}
