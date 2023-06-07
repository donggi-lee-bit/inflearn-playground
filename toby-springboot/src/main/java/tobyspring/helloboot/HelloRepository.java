package tobyspring.helloboot;

public interface HelloRepository {

    Hello findHello(String name);

    void increaseCount(String name);

    default int countOf(String name) { // default 메서드 예시를 보고 싶을 땐 Comparator 클래스 검색
        Hello hello = findHello(name);
        return hello == null ? 0 : hello.getCount();
    };
}
