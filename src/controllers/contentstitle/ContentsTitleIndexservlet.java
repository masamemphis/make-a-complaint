package controllers.contentstitle;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.ContentTitle;
import utils.DBUtil;
/**
 * Servlet implementation class ContentsTitleIndexservlet
 */
@WebServlet("/contentstitle/index")
public class ContentsTitleIndexservlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContentsTitleIndexservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @param search
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        int page = 1;
        try{
            page = Integer.parseInt(request.getParameter("page"));
        } catch(NumberFormatException e) { }

        String code = request.getParameter("search");



        List<ContentTitle> users = null;
        if (code != null && !code.equals("")) {
            users =  (List<ContentTitle>) em.createNamedQuery("searchRegisterCode",ContentTitle.class).setParameter("code", code).getResultList();
        } else {
             users = em.createNamedQuery("getAllUsers", ContentTitle.class)
                                             .setFirstResult(15 * (page - 1))
                                             .setMaxResults(15)
                                             .getResultList();
        }

        long users_count = (long)em.createNamedQuery("getUsersCount", Long.class)
                                       .getSingleResult();

        em.close();
        request.setAttribute("code",code);

        request.setAttribute("users", users);
        request.setAttribute("users_count", users_count);
        request.setAttribute("page", page);
        if(request.getSession().getAttribute("flush") != null) {
            request.setAttribute("flush", request.getSession().getAttribute("flush"));
            request.getSession().removeAttribute("flush");
        }

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/contentstitle/index.jsp");
        rd.forward(request, response);
    }


}
