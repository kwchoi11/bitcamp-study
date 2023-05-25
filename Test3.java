class D {}          //default 접근 범위 (같은 패키지에 소속되 경우에만 접근 가능)
public class E {}   //public 접근 범위 (누구든, 어느 패키지에 소속되어 있든 상관 없이 접근 가능)

//컴파일 시 오류 발생 이유:
//public class가 있는 소스파일은 클래스 이름과 같아야 한다. 