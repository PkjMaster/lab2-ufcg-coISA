package lab2;

/**
 * Representação do registro de tempo online responsável do controle do tempo online usado.
 *
 * @author Pedro Augusto Alexandrino Santos
 */
public class RegistroTempoOnline {

    /**
     * O nome da disciplina.
     */
    private String nome;

    /**
     * O tempo investido na disciplina.
     */
    private int tempoInvestido;

    /**
     * O tempo esperado de estudo na disciplina.
     */
    private int tempoEsperado;

    /**
     * Constrói um registro a partir do nome da disciplina.
     * Inicia com tempo esperado de 120 e tempo investido 0.
     *
     * @param nomeDisciplina o nome da disciplina.
     */
    public RegistroTempoOnline(String nomeDisciplina) {
        this.nome = nomeDisciplina;
        this.tempoEsperado = 120;
        this.tempoInvestido = 0;
    }

    /**
     * Constrói um registro a partir do nome da disciplina e tempo online esperado.
     * Inicia com tempo esperado de 120 e tempo investido 0.
     *
     * @param nomeDisciplina      o nome da disciplina.
     * @param tempoOnlineEsperado o tempo online esperado.
     */
    public RegistroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado) {
        this.nome = nomeDisciplina;
        this.tempoEsperado = tempoOnlineEsperado;
        this.tempoInvestido = 0;
    }

    /**
     * Adiciona tempo online ao registro.
     *
     * @param tempo quantidade de horas para adicionar.
     */
    public void adicionaTempoOnline(int tempo) {
        this.tempoInvestido += tempo;
    }

    /**
     * Retorna se foi ou não atingida a meta.
     *
     * @return Retorna true se a meta for atingida, false se não atingir.
     */
    public boolean atingiuMetaTempoOnline() {
        return (this.tempoInvestido >= this.tempoEsperado);
    }

    /**
     * Retorna a representação textual do registro de tempo online da disciplina
     * A representação segue o formato “NOME_DISCIPLINA TEMPOINVESTIDO/TEMPOESPERADO”.
     *
     * @return a representação em String de um registro.
     */
    @Override
    public String toString() {
        return this.nome + " " + this.tempoInvestido + "/" + this.tempoEsperado;
    }

}