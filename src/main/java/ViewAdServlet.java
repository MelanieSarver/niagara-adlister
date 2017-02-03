import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Created by mel on 2/2/17.
 */

@WebServlet(name = "ViewAdServlet", urlPatterns = "/ads/show")
public class ViewAdServlet extends HttpServlet {
    protected void doGet(
            HttpServletResponse res,
            HttpServletRequest req
    ) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        Ads ads = DaoFactory.getAdsDao();

        Ad ad = ads.find(id);
        req.setAttribute("ad", ad);

        req.getRequestDispatcher("/WEB-INF/ads/show/jsp").forward(req, res);
    }
}
