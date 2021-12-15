package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO;
import model.JavaBeans;
import model.JavaBeansLogs;

@WebServlet(urlPatterns = { "/ControllerServlet", "/main", "/insercao", "/select", "/delete", })
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JavaBeans jb = new JavaBeans();
	JavaBeansLogs jbl = new JavaBeansLogs();

	public ControllerServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			contatos(request, response);
		} else if (action.equals("/insercao")) {
			novoContato(request, response);
		}else if (action.equals("/select")) {
			listarUsuarios(request, response);
		}else if (action.equals("/delete")) {
			removerUsuario(request, response);
		}else {
			response.sendRedirect("index.html");
		}
	}

	// Listar contatos
	protected void contatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Criando um objeto que irá receber os dados JavaBeans
		ArrayList<JavaBeans> lista = dao.listarContatos();
		//teste de recebimento da lista
		//for (int i = 0; i<lista.size(); i++) {
		//System.out.println(lista.get(i).getId());
		//System.out.println(lista.get(i).getNome());
		//System.out.println(lista.get(i).getFone());
		//}
		
		//Encaminhar a lista ao documento primeiraPagina.jsp
		request.setAttribute("contatos",lista);
		RequestDispatcher rd = request.getRequestDispatcher("primeiraPagina.jsp");
		rd.forward(request, response);
	}

	// novo contato
	protected void novoContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// teste do recebimento dos dados do formulario
		//System.out.println(request.getParameter("nome"));
		//System.out.println(request.getParameter("fone"));
		//Setar as variáveis JavaBeans
//		String telefone = "55" + request.getParameter("fone");
//		System.out.println(request.getParameter("telefone"));
		try {
		jb.setNome(request.getParameter("nome"));
//		jb.setFone(telefone);
		jb.setFone(request.getParameter("fone"));
		//Invocar o método inserirUsuario passando o objeti usario
		dao.inserirUsuario(jb);
		//redirecinonar para o documento primeiraPagina.jsp
		
		//LOG
		jbl.setTipo("user_insert_log");
		jbl.setAcao("usuario inserido");
		dao.logInserirUsuario(jbl);
		
		response.sendRedirect("main");
		} catch (IOException e) {
			jbl.setTipo("user_insert_errpr_log");
			jbl.setAcao(e.getMessage());
			dao.logInserirUsuario(jbl);
			
			response.sendError(500, "erro: " + e.getCause());
		}
	}
	
	//Editar Usuario
	protected void listarUsuarios(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Recebimento do id do contato que será editado	
		String id = request.getParameter("id");
		//System.out.println(id);
		jb.setId(id);
			
	}
	
	//Excluir usuário
	protected void removerUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		//Recebimento do ID do contato a ser excluido ( Confirmador.js )
		String id = request.getParameter("id");
		//setar a variável id JavaBeans
		jb.setId(id);
		//executar o metodo deletarUsuario ( DAO ) passando o objeto Usuario
		dao.deletarUsuario(jb);
		//redirecionar para o documento primeiraPagina.jsp ( Atualizando as alterações )
		response.sendRedirect("main");
	}


}