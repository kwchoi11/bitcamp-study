package college.pj.handler;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import college.pj.vo.Member;

@WebServlet("/index.html")
public class HomeServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>ㅇㅇ대학교</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>커뮤니티 게시판</h1>");
    out.println("<ul>");
    out.println("  <li><a href='/member/form.html'>회원가입</a></li>");
    out.println("  <li><a href='/member/list'>회원</a></li>");
    out.println("  <li><a href='/board/list?category=1'>공지사항</a></li>");
    out.println("  <li><a href='/board/list?category=2'>모집게시판</a></li>");
    out.println("  <li><a href='/board/list?category=3'>자유게시판</a></li>");
    out.println("  <li><a href='/board/list?category=4'>자료실</a></li>");

    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    if (loginUser == null) {
      out.println("  <li><a href='/auth/form.html'>로그인</a></li");
    } else {
      out.printf("  <li>%s <a href='/auth/logout'>로그아웃</a></li>", loginUser.getName());
    }

    out.println("</ul>");
    out.println("</body>");
    out.println("</html>");

  }

}
