package hello.core.singleton;

public class SingletonService {
    // 자기자신을 private static 으로 선언, 클래스레벨에 올라가기때문에 하나만 존재/ 자바기본 static
    // 1. static 영역에 객체를 딱 1개만 생성해둔다
    private static final SingletonService instance = new SingletonService();

    // 2. public으로 열어서 객체 인스턴스가 필요하면 이 static 메소드를 통해서만 조회하도록 허용한다
    public static SingletonService getInstance() {
        return instance; // 항상 같은 instance 만을 반환한다 딱 1개
    }

    // 3. 생성자를 private로 선언해서 외부에서 new 키워드를 사용한 객체생성을 막는다
    // 다른데서 만들지 못하게 막아버리는 private 생성자, 생성을 막아버림
    private SingletonService() {}

    private void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
