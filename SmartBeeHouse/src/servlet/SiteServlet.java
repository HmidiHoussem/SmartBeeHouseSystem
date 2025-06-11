@WebServlet("/sites")
public class SiteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<Site> sites = SiteDAO.getAllSites();
        req.setAttribute("sites", sites);
        req.getRequestDispatcher("sites.jsp").forward(req, res);
    }
}
