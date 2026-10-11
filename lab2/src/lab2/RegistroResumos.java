package lab2;

import java.util.Arrays;

/**
 * Representação do registro de resumos dos estudos realizados ao longo do período.
 *
 * @author Pedro Augusto Alexandrino Santos
 */
public class RegistroResumos {

    /**
     * Array contendo os resumos
     */
    private Resumo[] resumos;

    /**
     * Índice da próxima inserção
     */
    private int iResumos;

    /**
     * Constrói o registro de resumos a partir da quantidade maxima de resumos
     *
     * @param numeroDeResumos quantidade maxima de resumos.
     */
    public RegistroResumos(int numeroDeResumos) {
        this.resumos = new Resumo[numeroDeResumos];
        this.iResumos = 0;
    }

    /**
     * Adiciona um resumo novo ao array resumos a partir do tema e conteudo.
     *
     * @param tema     o tema do resumo que será adicionado.
     * @param conteudo o conteúdo do resumo que será adicionado.
     */
    public void adiciona(String tema, String conteudo) {
        if (!temResumo(tema)) {
            this.resumos[this.iResumos % this.resumos.length] = new Resumo(tema, conteudo);
            this.iResumos++;
        }
    }

    /**
     * Retorna as representações textuais dos resumos armazenados.
     *
     * @return Uma array de String contendo todas as representações em String dos resumos adicionados.
     */
    public String[] pegaResumos() {
        int len = this.conta();
        String[] out = new String[len];

        for (int i = 0; i < len; i++) {
            out[i] = this.resumos[i].toString();
        }

        return out;
    }

    /**
     * Retorna uma String contendo a quantidade de resumos e o tema de todos os resumos cadastrados.
     *
     * @return Uma String contendo quantidade e os temas dos resumos.
     */
    public String imprimeResumos() {
        int len = this.conta();
        String out = "";
        out += "- " + len + " resumo(s) cadastrado(s)\n";
        out += "- ";

        for (int i = 0; i < len; i++) {
            if (i != 0) {
                out += " | ";
            }
            out += this.resumos[i].getTema();
        }

        return out;
    }

    /**
     * Retorna a quantidade de resumos total.
     *
     * @return A quantidade de resumos armazenados.
     */
    public int conta() {
        return Math.min(this.iResumos, this.resumos.length);
    }

    /**
     * Verifica se já existe um resumo com o tema informado.
     *
     * @param tema tema que é verificado.
     * @return Retorna true se existir outro resumo, false se não existir.
     */
    public boolean temResumo(String tema) {
        int len = conta();

        for (int i = 0; i < len; i++) {
            if (this.resumos[i].getTema().equals(tema)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Returna uma array de String contendo a representação em String dos resumos que tem no seu conteudo
     * a chave de busca passada no parâmetro.
     *
     * @param chaveDeBusca palavra que é buscada.
     * @return Retorna uma array de String contendo a representação em String dos resumos com a chave de busca no seu conteúdo.
     */
    public String[] busca(String chaveDeBusca) {
        int len = conta();
        int idx = 0;
        String[] tempTemas = new String[len];

        for (int i = 0; i < len; i++) {
            String[] palavras = this.resumos[i].getConteudo().split(" ");

            for (String palavra : palavras) {
                if (palavra.equalsIgnoreCase(chaveDeBusca)) {
                    tempTemas[idx++] = this.resumos[i].toString();
                    break;
                }
            }
        }

        String[] out = Arrays.copyOf(tempTemas, idx);
        Arrays.sort(out);

        return out;
    }

}