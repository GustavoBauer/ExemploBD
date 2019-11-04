//classe de modelo Aluno com 3 atributos encapsulados
//os mesmos 3 atributos devem estar presentes na estrutura da tabela no BD
public class Aluno {
    
    private String matricula;
    private String nome;
    private String disciplina;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }
    
    
}
