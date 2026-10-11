package lab2;

/**
 * Representação de uma disciplina de um aluno.
 *
 * @author Pedro Augusto Alexandrino Santos
 */
public class Disciplina {

    /**
     * Nome da disciplina.
     */
    private String nome;

    /**
     * Quantidade total de horas de estudo nessa disciplina.
     */
    private int horasDeEstudo;

    /**
     * Array de double contendo as notas.
     */
    private double[] notas;

    /**
     * Quantidade máxima de notas na disciplina.
     */
    private final int MAX_NOTAS;

    /**
     * Array de inteiro contendo os pesos respectivos de cada nota.
     */
    private int[] pesos;

    /**
     * A soma dos pesos para calcular a média.
     */
    private int pesoTotal;

    /**
     * Constrói a disciplina a partir do nome da disciplina.
     * Inicializando o máximo de notas = 4, horas de estudo = 0, e os pesos = 1.
     *
     * @param nomeDisciplina nome da disciplina.
     */
    public Disciplina(String nomeDisciplina) {
        this.nome = nomeDisciplina;
        this.MAX_NOTAS = 4;
        this.horasDeEstudo = 0;
        this.notas = new double[MAX_NOTAS];
        this.pesos = new int[MAX_NOTAS];
        this.pesoTotal = MAX_NOTAS;

        // inicializa o array pesos com pesos 1 e o notas com notas = 0
        for (int i = 0; i < MAX_NOTAS; i++) {
            this.pesos[i] = 1;
            this.notas[i] = 0;
        }
    }

    /**
     * Constrói a disciplina a partir do nome da disciplina e o número de notas.
     * Inicializando horas de estudo = 0, e os pesos = 1.
     *
     * @param nomeDisciplina nome da disciplina.
     * @param numNotas       o número máximo de notas que serão recebidas.
     */
    public Disciplina(String nomeDisciplina, int numNotas) {
        this.nome = nomeDisciplina;
        this.MAX_NOTAS = numNotas;
        this.horasDeEstudo = 0;
        this.notas = new double[MAX_NOTAS];
        this.pesos = new int[MAX_NOTAS];
        this.pesoTotal = MAX_NOTAS;
        // inicializa o array com pesos 1
        for (int i = 0; i < MAX_NOTAS; i++) {
            this.pesos[i] = 1;
            this.notas[i] = 0;
        }
    }


    /**
     * Constrói a disciplina a partir do nome da disciplina e o número de notas.
     * Inicializando horas de estudo = 0.
     *
     * @param nomeDisciplina nome da disciplina.
     * @param numNotas       o número máximo de notas que serão recebidas.
     * @param pesos          uma array de inteiros representando os pesos de cada nota.
     */
    public Disciplina(String nomeDisciplina, int numNotas, int[] pesos) {
        this.nome = nomeDisciplina;
        this.horasDeEstudo = 0;
        this.MAX_NOTAS = numNotas;
        this.notas = new double[MAX_NOTAS];
        this.pesos = new int[pesos.length];

        for (int i = 0; i < pesos.length; i++) {
            this.pesoTotal += pesos[i];
            this.pesos[i] = pesos[i];
            this.notas[i] = 0;
        }
    }

    /**
     * Adiciona horas de estudo na disciplina
     *
     * @param horas horas de estudo que serão adicionadas.
     */
    public void cadastraHoras(int horas) {
        this.horasDeEstudo += horas;
    }

    /**
     * Define a nota de uma prova especifica
     *
     * @param nota      prova que deve ser adicionada a nota.
     * @param valorNota valor que deve ser adicionado à nota.
     */
    public void cadastraNota(int nota, double valorNota) {
        this.notas[nota - 1] = valorNota;
    }

    /**
     * Calcula e retorna a média
     *
     * @return A média em double.
     */
    private double calcMedia() {
        double media = 0;

        for (int i = 0; i < MAX_NOTAS; i++) {
            media += this.notas[i] * this.pesos[i];
        }

        return media / this.pesoTotal;
    }

    /**
     * Verifica se o aluno está aprovado na disciplina.
     *
     * @return Retorna true se a media for >= 7, false caso contrário.
     */
    public boolean aprovado() {
        return calcMedia() >= 7.0;
    }

    /**
     * Retorna a String que representa o desempenho do aluno na disciplina.
     * A representação segue o formato “NOME horasDeEstudo MEDIA [nota[1], nota[2], ..., nota[i]]".
     *
     * @return a representação em String de um resumo.
     */
    @Override
    public String toString() {
        //PROGRAMACAO 2 4 7.0 [5.0, 6.0, 7.0, 10.0]
        String out = this.nome;
        out += " " + this.horasDeEstudo + " " + calcMedia();
        out += " [";

        for (int i = 0; i < MAX_NOTAS; i++) {
            if (i != 0) {
                out += ", ";
            }
            out += this.notas[i];
        }

        out += "]";
        return out;
    }

}