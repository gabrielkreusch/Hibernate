package controlador;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import model.Funcionario;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Pessoa;
import utils.JpaUtil;

/**
 *
 * @author friend
 */
@WebServlet(urlPatterns = {"/funcionarios"})
public class FuncionarioControl extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String especificador = request.getParameter("p");
        if (especificador != null) {
            // exibe alguém específico?
            try ( PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("deve exibir alguém específico");
            }
        } else { // exibe todos
            EntityManager em = JpaUtil.getEntityManager();
            // obtém dados
            Query qr = em.createQuery("from Funcionario");
            
            ArrayList<Funcionario> registros = (ArrayList<Funcionario>) qr.getResultList();
            //Pessoa registros = new Pessoa("maria", "ma@gmail.com", "99122991");
            // insere no request
            request.setAttribute("registros", registros);
            // encaminha a resposta 
            getServletContext().getRequestDispatcher("/listar-funcionarios.jsp").forward(request, response);
            //response.sendRedirect(request.getContextPath() + "/listar.jsp");
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");

//        Pessoa nova = new Pessoa(nome, email, telefone);
//        pdao.incluirPessoa(nova);
        request.setAttribute("msg", "Pessoa incluída com sucesso");
        getServletContext().getRequestDispatcher("/mensagem.jsp").forward(request, response);
        //response.sendRedirect("mensagem.jsp");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
