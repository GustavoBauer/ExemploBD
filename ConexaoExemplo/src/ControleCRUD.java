//Bibliotecas importantes
import java.sql.Connection;
import java.sql.PreparedStatement; //usado para "setar"; CUD do CRUD
import java.sql.ResultSet; //usado para "getar"; R do CRUD
import java.sql.SQLException;

public class ControleCRUD implements InterfaceCRUD{

    @Override
    public void adicionar(Aluno a) { //recebe como argumento um objeto Aluno para ser inserido definitivamente no bd
        try(Connection connection = JDBC.getConnection()){ //estabelecendo conexao usando try catch para tratar de erros
            String query=("INSERT INTO Aluno VALUES (?, ?, ?)"); 
            //cada ? será preenchido em ordem com o uso do ps.set
            PreparedStatement ps = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            //instanciando o objeto (só não me lembro ao certo do porque desse RETURN_GENERATED_KEYS ;-;)
            
            int index = 1; //index para variar o ?; a cada incrementada, um novo atributo
            /*Estrutura do ps.set
            ps.setString(index++, 'atributoString')
            ps.setIng(index++,'atributoInt')
            ps.setDouble(index++,'atributoDouble')
            
            Funcão: o ps.set insere os dados na ordem do index (variando o ?) e
                    o segundo argumento é onde está guardado o conteudo propriamente dito que será inserido no bd                     
            */
            ps.setString(index++,a.getMatricula());           
            ps.setString(index++,a.getNome());
            ps.setString(index++,a.getDisciplina());
            ps.executeUpdate(); //modifica oficialmente no bd 

        }catch(SQLException ex){ //tratamento de exceção
            ex.printStackTrace();
        }      
    }
    
    @Override
    public Aluno buscar(String matricula) {
        Aluno a = null; //objeto que será retornado
        try(Connection connection = JDBC.getConnection()) {          
            
            String query = ("SELECT * FROM Aluno WHERE Matricula = ?" ); 

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, matricula);

            ResultSet rs = ps.executeQuery(); //a query é executada, porem o rs guarda o conteudo das rows                                                         
            
            while(rs.next()){ //So executa se tiver conteudo gravado em rs
                a = new Aluno(); //objeto é instanciado somente nesse estagio
                a.setMatricula(rs.getString("matricula")); //seta o atributo do objeto com os dados do rs
                //entre "" é o nome da coluna que está sendo utilizada               
                a.setNome(rs.getString("nome"));
                a.setDisciplina(rs.getString("disciplina"));                 
            }               
        }catch(SQLException ex) {            
            ex.printStackTrace();  
        }                 
        return a; //retorna o objeto
    }

    @Override
    public void atualizar(Aluno a) {
        try(Connection connection = JDBC.getConnection()){
            String query=("UPDATE ALUNO" + " SET NOME= ?, DISCIPLINA = ? "+" WHERE MATRICULA = ?");
            PreparedStatement ps = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            
            int index = 1;
            ps.setString(index++,a.getNome());
            ps.setString(index++,a.getDisciplina());
            ps.setString(index++,a.getMatricula());
            ps.executeUpdate();

            }catch(SQLException ex){
                ex.printStackTrace();
            }
        
    }

    @Override
    public void deletar(String matricula) {
        try(Connection connection = JDBC.getConnection()){
            String query=("DELETE FROM ALUNO" +" WHERE MATRICULA = ?");
            PreparedStatement ps = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1, matricula); //apenas um ?, podemos colocar o numero direto da ordem dos ?           
            ps.executeUpdate();

        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
}
