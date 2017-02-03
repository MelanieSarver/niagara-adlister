import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Created by mel on 2/2/17.
 */

@WebServlet(name = "InsertAdServlet", urlPatterns = "/ads/create")
public class InsertAdServlet extends HttpServlet{
    protected void doPost(
            HttpServletRequest req,
            HttpServletResponse res
    ) throws ServletException, IOException {
        Ads ads = DaoFactory.getAdsDao();
//        User user = (User)request.getSession().getAttribute('user');
        Ad ad = new Ad(
             1, //user.getID();
        req.getParameter("title"),
        req.getParameter("description")
        );
        ads.insert(ad);
        res.sendRedirect("/ads/show?id=" + ad.getId());
    }

    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse res
    ) throws ServletException, IOException {
        req
                .getRequestDispatcher("/WEB-INF/ads/insert.jsp")
                .forward(req,res)
                ;
    }

}
