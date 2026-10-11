package lab2;

/**
 * Representação da rotina de descanso do aluno.
 *
 * @author Pedro Augusto Alexandrino Santos
 */
public class Descanso {

    /**
     * Horas que foram descansadas.
     */
    private int horasDescanso;

    /**
     * Numero de semanas no total
     */
    private int numerosDeSemana;

    /**
     * Quantidade mínima de horas de descanso por semana para o aluno estar descansado.
     */
    private static final int MIN_DESCANSO = 26;

    /**
     * Constrói a representação do descanso do aluno.
     *
     */
    public Descanso() {
        this.horasDescanso = 0;
        this.numerosDeSemana = 1;
    }

    /**
     * Define o valor de horas de descanso do aluno.
     *
     * @param valor O valor que será definido como horas de descanso do aluno.
     */
    public void defineHorasDescanso(int valor) {
        this.horasDescanso = valor;
    }

    /**
     * Define o número de semanas com base no valor passado.
     *
     * @param valor O número de semanas a ser definido.
     */
    public void defineNumeroSemanas(int valor) {
        this.numerosDeSemana = valor;
    }

    /**
     * Retorna descansado ou cansado com base no nas horas descansadas relativas ao esperado por semana.
     *
     * @return Retorna "descansado" se a meta de desencaso for atingida, retorna "cansado" caso contrário.
     */
    public String getStatusGeral() {
        if (this.horasDescanso >= MIN_DESCANSO * this.numerosDeSemana) {
            return "descansado";
        }
        return "cansado";
    }

}