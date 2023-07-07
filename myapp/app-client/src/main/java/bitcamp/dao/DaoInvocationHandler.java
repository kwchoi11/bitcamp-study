package bitcamp.dao;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;
import bitcamp.myapp.vo.Board;
import bitcamp.net.RequestEntity;
import bitcamp.net.ResponseEntity;

public class DaoInvocationHandler implements InvocationHandler {

  String dataName;
  DataInputStream in;
  DataOutputStream out;

  public static List<Board> list() {
    return null;
  }

  public static Map<String, Board> list2() {
    return null;
  }

  // 테스트를 위해 만든 메인 메서드. 테스트 후에 지우면 된다.
  // public static void main(String[] args) throws Exception {
  // Method method = DaoInvocationHandler.class.getDeclaredMethod("list");
  //
  // Class<?> returnType = method.getReturnType();
  // System.out.println(returnType == List.class);
  //
  // ParameterizedType paramType = (ParameterizedType) method.getGenericReturnType();
  // Class<?> itemType = (Class<?>) paramType.getActualTypeArguments()[0];
  // System.out.println(itemType.getSimpleName());
  // }

  public DaoInvocationHandler(String dataName, DataInputStream in, DataOutputStream out) {
    this.dataName = dataName;
    this.in = in;
    this.out = out;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

    // 요청 정보 준비
    RequestEntity requestEntity = new RequestEntity();
    requestEntity.command(dataName + "/" + method.getName());
    if (args.length > 0) {
      requestEntity.data(args[0]);
    }

    // 요청 정보 전송
    out.writeUTF(requestEntity.toJson());

    // 응답 정보 수신
    ResponseEntity response = ResponseEntity.fromJson(in.readUTF());
    if (response.getStatus().equals(ResponseEntity.ERROR)) {
      throw new RuntimeException(response.getResult());
    }

    // 리턴 타입 조사
    Class<?> returnType = method.getReturnType();

    if (returnType == int.class) {
      return response.getObject(int.class);
    } else if (returnType == void.class) {
      return null;
    } else if (returnType == List.class) {
      ParameterizedType paramType = (ParameterizedType) method.getGenericReturnType();
      Class<?> itemType = (Class<?>) paramType.getActualTypeArguments()[0];
      return response.getList(itemType);
    } else {
      return response.getObject(returnType);
    }
  }
}
