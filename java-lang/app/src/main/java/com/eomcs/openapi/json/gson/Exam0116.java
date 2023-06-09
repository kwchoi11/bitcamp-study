// 객체 --> JSON 문자열 : 객체의 필드 값을 json 형식의 문자열로 만들기
package com.eomcs.openapi.json.gson;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class Exam0116 {
  public static void main(String[] args) {

      class Member {
        int no;
        String name;
        String email;
        String password;
        boolean working;

        public int getNo() {
          return no;
        }
        public void setNo(int no) {
          this.no = no;
        }
        public String getName() {
          return name;
        }
        public void setName(String name) {
          this.name = name;
        }
        public String getEmail() {
          return email;
        }
        public void setEmail(String email) {
          this.email = email;
        }
        public String getPassword() {
          return password;
        }
        public void setPassword(String password) {
          this.password = password;
        }
        public boolean isWorking() {
          return working;
        }
        public void setWorking(boolean working) {
          this.working = working;
        }

        Member m = new Member();
        m.setNo(100);
        m.setName(" 홍길동");
        m.setEmail("hongWtest.com");
        m.setPassword("1111");
        m.setWorking(true);

      }
    }
}

