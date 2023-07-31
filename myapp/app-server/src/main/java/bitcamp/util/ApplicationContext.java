package bitcamp.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import bitcamp.myapp.config.AppConfig;

public class ApplicationContext {
  // 객체 보관소
  Map<String,Object> beanContainer = new HashMap<>();

  public ApplicationContext(Class<?> configClass) throws Exception {
    processBeanAnnotation(configClass);

    ComponentScan componentScan = configClass.getAnnotation(ComponentScan.class);
    if (componentScan != null) {
      processComponentScanAnnotation(componentScan);
    }
  }

  private void processBeanAnnotation(Class<?> configClass) throws Exception {
    // 클래스의 기본 생성자를 알아낸다.
    Constructor<?> constructor = configClass.getConstructor();

    // 기본 생성자를 이용하여 객체를 생성한다.
    Object obj = constructor.newInstance();

    // 해당 클래스에 정의된 메서드 목록만 가져온다.
    Method[] methods = configClass.getDeclaredMethods();
    for (Method m : methods) {

      // 메서드의 리턴 타입이 없다면 무시한다.
      if (m.getReturnType() == void.class) {
        continue;
      }

      // @Bean 애노테이션이 붙지 않은 메서드라면 무시한다.
      Bean beanAnnotation = m.getAnnotation(Bean.class);
      if (beanAnnotation == null) {
        continue;
      }

      // 메서드 중에서 리턴 값이 있는 메서드를 호출한다.
      // 즉, 오직 값을 리턴하는 메서드만 호출한다.
      Object returnValue = m.invoke(obj);

      // 메서드가 리턴한 값을 컨테이너에 저장한다.
      if (beanAnnotation.value().length() > 0) {
        // 애노테이션에 객체 이름이 지정되어 있다면 그 이름으로 객체를 저장한다.
        beanContainer.put(beanAnnotation.value(), returnValue);
      } else {
        // 애노테이션에 설정된 이름이 없다면 메서드 이름을 사용하여 객체를 저장한다.
        beanContainer.put(m.getName(), returnValue);
      }
    }
  }

  private void processComponentScanAnnotation(ComponentScan componentScan) throws Exception {
    for (String basePackage : componentScan.basePackages()) {
      System.out.println(basePackage + "-------------------------------------");
      createBeans(basePackage);
    }
  }

  private void createBeans(String basePackage) throws Exception {
    // 패키지 이름에 해당하는 디렉토리 정보를 알아낸다.
    // 1) 패키지 이름을 파일 경로로 변환한다. (. --> /)
    String packagePath = basePackage.replaceAll("[.]", "/");

    // 2) 클래스 경로(CLASSPATH)를 관리하는 객체를 준비한다.
    ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();

    // 3) 클래스로더에게 패키지 경로에 해당하는 디렉토리 정보를 읽을 수 있는 도구를 달라고 요구한다.
    InputStream dirInputStream = systemClassLoader.getResourceAsStream(packagePath);

    // 4) 패키지 디렉토리 안에 들어있는 파일 이름이나 하위 디렉토리 이름을 읽을 도구를 준비한다.
    BufferedReader dirReader = new BufferedReader(new InputStreamReader(dirInputStream));

    // 5) 디렉토리 리더를 통해 해당 디렉토리에 들어있는 하위 디렉토리 또는 파일 이름을 알아낸다.
    //    - 한 줄씩 읽으면 된다.
    String line = null;
    while ((line == dirReader.readLine()) != null) {
      if (line.endsWith(".class")) {
        System.out.println(line);
      }
    }

    //    reader
    //    .lines()
    //    .filter(line -> {
    //      System.out.println(line);
    //      return false;
    //    });
  }

  public Object getBean(String name) {
    return beanContainer.get(name);
  }

  public String[] getBeanNames() {
    return beanContainer.keySet().toArray(new String[0]);
  }

  public static void main(String[] args) throws Exception {
    ApplicationContext applicationContext = new ApplicationContext(AppConfig.class);
    for (String name : applicationContext.getBeanNames()) {
      System.out.println(name);
    }
  }
}










