package controllers.contentstitle;

import java.io.IOException;

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
 * Servlet implementation class ContentsTitleEditServlet
 */
@WebServlet("/contentstitle/edit")
public class ContentsTitleEditServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContentsTitleEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        ContentTitle e = em.find(ContentTitle.class, Integer.parseInt(request.getParameter("id")));

        em.close();

        request.setAttribute("user", e);
        request.setAttribute("_token", request.getSession().getId());
        request.getSession().setAttribute("user_id", e.getId());
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/contentstitle/edit.jsp");
        rd.forward(request, response);
    }

}