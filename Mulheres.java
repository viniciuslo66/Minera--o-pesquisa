public class Mulheres {
    private Integer id;
    private Integer trabalho;
    private Integer casada;
    private Integer idade;
    private Integer escolaridade;    
    
    public Mulheres() {
    }

    public Mulheres(int id, int trabalho, int casada, int idade, int escolaridade) {
        this.id = id;
        this.trabalho = trabalho;
        this.casada = casada;
        this.idade = idade;
        this.escolaridade = escolaridade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTrabalho() {
        return trabalho;
    }

    public void setTrabalho(int trabalho) {
        this.trabalho = trabalho;
    }

    public int getCasada() {
        return casada;
    }

    public void setCasada(int casada) {
        this.casada = casada;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(int escolaridade) {
        this.escolaridade = escolaridade;
    }

    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Mulheres other = (Mulheres) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Mulheres [casada=" + casada + ", escolaridade=" + escolaridade + ", id=" + id + ", idade=" + idade
                + ", trabalho=" + trabalho + "]";
    }
}
