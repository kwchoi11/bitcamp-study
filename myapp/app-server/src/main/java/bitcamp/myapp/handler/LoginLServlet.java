package bitcamp.myapp.handler;

import java.io.PrintWriter;
import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.vo.Member;
import bitcamp.util.Component;
import bitcamp.util.HttpServletRequest;
import bitcamp.util.HttpServletResponse;
import bitcamp.util.Servlet;

@Component("/auth/login")
public class LoginLServlet implements Servlet {

  MemberDao memberDao;

  public LoginLServlet(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @Override
  public void service(HttpServletRequest request, HttpServletResponse response) throws Exception {
    Member m = new Member();
    m.setEmail(request.getParameter("email"));
    m.setPassword(request.getParameter("password"));

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>로그인</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>로그인</h1>");

    Member loginUser = memberDao.findByEmailAndPassword(m);
    if (loginUser == null) {
      out.println("<p>회원 정보가 일치하지 않습니다.</p>");
    } else {
      out.println("<p>로그인 성공입니다!</p>");

      // 로그인 정보를 다른 요청에서도 사용할 수 있도록 세션 보관소에 담아 둔다.
      request.getSession().setAttribute(("loginUser", loginUser);
    }

    out.println("</body>");
    out.println("</html>");
  }
}
