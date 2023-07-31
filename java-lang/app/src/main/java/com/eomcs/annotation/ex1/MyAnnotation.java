// 애노테이션 정의
package com.eomcs.annotation.ex1;

public @interface MyAnnotation {

}

//한 줄 주석
//- 소스 코드의 설명을 붙일 때 사용
//- 컴파일 할 때 .class 파일에 포함되지 않음

/*
여러 줄 주석
- 소스 코드에 여러 줄의 설명을 붙일 때 사용
- 컴파일 할 때 .class 파일에 포함되지 않음
 */

/**
javadoc 주석
- javadoc.exe 를 통해 HTML API 문서를 생성할 때 사용됨.
- 컴파일 할 때 .class 파일에 포함되지 않음
 */


//애노테이션
//- 클래스 파일(.class)에 남길 수 있는 주석
//- 형식을 갖춘 주석이다.
//- 형식?
//    @애노테이션이름(프로퍼티=값, 프로퍼티=값)
//- 활용
//  1) 소스 코드에서 주석을 읽어 다른 소스 파일을 생성할 때 사용
//  2) 컴파일할 때 주석을 추출하여 사용(컴파일러가 사용하는 내장 애노테이션)
//  2) 실행 중에 주석을 추출하여 사용


