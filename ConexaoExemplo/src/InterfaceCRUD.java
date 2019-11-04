
public interface InterfaceCRUD {
    public void adicionar(Aluno a); //CREATE
    public Aluno buscar(String matricula); //READ: busca singular, nesse caso 
    //Para busca total usar JTable ou Formulário Master(https://www.youtube.com/watch?v=pj9eTCQa2VA)
    public void atualizar(Aluno a); //UPDATE
    public void deletar(String matricula); //DELETE
}
