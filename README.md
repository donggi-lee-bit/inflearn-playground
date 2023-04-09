# spring-jpa-querydsl
인프런 김영한님 실전 QueryDsl 강의 연습 레포

## QueryDsl 환경 설정

spring boot 버전 2.6 이상, querydsl 5.0 환경 설정 방법이 다르다. querydsl 설정 시 `annotationProcessor` 사용을 권장하고 있다. 그 이유는
- spring boot가 버전업을 하면서 gradle 도 버전업 하게 되고 그 과정에서 인텔리제이에서 build 시 querydsl Q클래스 생성 문제
  - gradle 로 빌드하면 문제 없지만 intellij idea 로 빌드하면 정상 작동이 되지 않는다고 한다

자세한 내용은 아래 블로그에 자세하게 나와있다

[그레이들 Annotation processor 와 Querydsl](http://honeymon.io/tech/2020/07/09/gradle-annotation-processor-with-querydsl.html)

### 설정 검증 및 확인

검증
- Gradle > build
  - 에러가 난다면 환경 설정에 문제가 있는 것

확인
- build > generated > querydsl
  - Q class 생성되어 있어야함 

## JPAQueryFactory

### JPAQueryFactory 필드 사용

테스트 시 `JPAQueryFactory` 를 필드에 두고, `@BeforeEach` 에서 초기화 해주도록 한다. 이 때 동시성 문제는?
- `JPAQueryFactory` 를 생성할 때 제공하는 `EntityManager` 에 달려있다
- 스프링 프레임워크는 여러 스레드에서 동시에 같은 `EntityManager` 에 접근해도 트랜잭션마다 별도의 영속성 컨텍스트를 제공하기 때문에 동시성 문제는 걱정하지 않아도 됨

## Q-Type 활용

### Q 클래스 인스턴스를 사용하는 두 가지 방법

1. 별칭 직접 적용
   - `QMember qMember = new QMember("m");`
2. 기본 인스턴스 사용
   - `QMember qMember = QMember.member;`

**같은 테이블을 조인하는 경우가 아닌 이상 기본 인스턴스 사용을 권유함**

### 기본 인스턴스를 `static import` 와 함께 사용

`import static com.example.inflearnquerydslyounghankim.entity.QMember.member;`
