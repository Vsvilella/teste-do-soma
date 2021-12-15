package model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class DAO {

	/** Modo de conexão **/

	// Parâmetros de conexão
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/nvoip?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "hIDROGENIO001";
	
	JavaBeansLogs jbl = new JavaBeansLogs();

	// Metodo de conexão
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println("Falha na conexão");
			return null;
		}

	}

	public void testeConexao() {
		try {
			Connection con = conectar();
			System.out.println(con);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/** CRUD CREATE **/

	public void inserirUsuario(JavaBeans usuario) {
		String create = "insert into usuario (nome,numero) values (?,?);";
		try {
			// Abrir conexão ao banco
			Connection con = conectar();
			// Preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(create);
			// Substituir os parâmetros (?) pelo conteudo das variáveis JavaBeans
			pst.setString(1, usuario.getNome());
			pst.setString(2, usuario.getFone());
			// Executar a query
			pst.executeUpdate();
			// Encerrar a conexão com o banco
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void logInserirUsuario(JavaBeansLogs log) {
		String create = "insert into logs (tipo,acao) values (?,?);";
		try {
			// Abrir conexão ao banco
			Connection con = conectar();
			// Preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(create);
			// Substituir os parâmetros (?) pelo conteudo das variáveis JavaBeans
			pst.setString(1, log.getTipo());
			pst.setString(2, log.getAcao());
			// Executar a query
			pst.executeUpdate();
			// Encerrar a conexão com o banco
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// ** CRUD READ**/
	public ArrayList<JavaBeans> listarContatos() {
		// Criando um objeto para acessar a clase JavaBeans
		ArrayList<JavaBeans> usuarios = new ArrayList<>();
		String read = "select * from usuario order by nome";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				String id = rs.getString(1);
				String nome = rs.getString(2);
				String fone = rs.getString(3);
				

				usuarios.add(new JavaBeans(id, nome, fone));
			}
			
			con.close();
			return usuarios;
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	/** CRUD DELETE**/
	public void deletarUsuario(JavaBeans usuario) {
		String delete = "delete from usuario where id=?;";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1,usuario.getId());
			pst.executeUpdate();
			con.close();
			} catch (Exception e) {
			System.out.println(e);
		}
	}
	 
}