//Bibliotecas importantes (ou utilize somente import java.sql.*)
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException; 

/*Além dessas importações, adicione o driver JDBC do MySQL 
em Bibliotecas -> (botao direito) -> Adicionar Biblioteca -> Driver JDBC do MySQL -> Add biblioteca
https://ibb.co/Ss1C6L3
https://ibb.co/QJgNpZf
*/
public class JDBC {
    //tela para criar uma SQL Connection -> clicar no botão +
    //https://ibb.co/5sWsFbH
    
    private static String url = ("jdbc:mysql://localhost:3306/Escola");
    //padrão com localhost (hostname = 127.0.0.1) da url:
    //jdbc:mysql://localhost:item1/nomeBdUtilizado (da imagem a cima)
    private static String username = ("root");
    //será usado assim como a url pelo DriverManager pra ter acesso ao bd
    //Varia dependendo do item 2, padrão: root
    private static String password = ("");
    //Pode ser setada clicando no botão 'Store in vault' (item3)
    //padrão: vazio
    
    public static Connection getConnection(){ //método que tenta a conexão
        //já que o método e os atributos são estáticos nao precisamos instanciar um objeto
        //bastar usar o objeto JDBC (sem necessidade de new JDBC()) 
        Connection connection = null;
        
        try{
            // carrega o driver importado para o MySql 
            Class.forName("com.mysql.jdbc.Driver");

            //cria a conexao com o db a partir da url, username e password; requiridos anteriormente
            connection = DriverManager.getConnection(url, username, password); 
                       
        }catch (ClassNotFoundException | SQLException ex){ //tratamento de tentativa falha
            ex.printStackTrace();            
        }      
        return connection; 
        //Usaremos muito o método JDBC.getConnection(); na classe de controle para estabelecer conexão
    }


}
//Conexao com SQLite (site oficial): http://www.sqlitetutorial.net/sqlite-java/sqlite-jdbc-driver/
