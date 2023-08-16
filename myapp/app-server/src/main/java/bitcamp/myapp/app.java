package bitcamp.myapp;

import java.io.File;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.StandardRoot;

public class app {

  public static void main(String[] args) throws Exception {
    System.out.println("서버시작!");

    // 톰캣 서버를 구동시키는 객체 준비
    Tomcat tomcat = new Tomcat();

    // 서버의 포트번호 설정
    tomcat.setPort(8888);

    // 톰캣 서버를 실행하는 동안 사용할 임시 폴더 지정
    tomcat.setBaseDir("temp");

    // 톰캣 서버의 연결 정보를 설정
    Connector connector = tomcat.getConnector();
    connector.setURIEncoding("UTF-8");

    // 톰캣 서버에 배포할 웹어플리케이션의 환경 정보 준비
    StandardContext ctx = (StandardContext) tomcat.addWebapp("/",
        new File("src/main/webapp").getAbsolutePath());

    // 웹 어플리케이션 설정
    WebResourceRoot resources = new StandardRoot(ctx);

    // 웹 어플리케이션의 기타 자원 등록
    //    File additionWebInfClass = new File("target/classes");
    //    resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes",
    //        additionWebInfClass.getAbsolutePath(), "/"));

    // 웹 어플리케이션을 환경 정보에 등록
    ctx.setResources(resources);

    // 톰캣 서버 구동
    tomcat.start();

    // 톰캣 서버를 구동한 후 종료될 때까지 JVM을 끝내지 말고 기다린다.
    tomcat.getServer().await();

    System.out.println("서버 종료!");
  }
}
