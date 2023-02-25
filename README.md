# AOP-DEMO
- AOP 개념을 예제를 통해 적용해보는 경험을 합니다.
- 예제를 구현하면서 Layered Architecture 를 적용해봅니다.
<img width="770" alt="스크린샷 2023-02-24 오후 4 07 32" src="https://user-images.githubusercontent.com/80501465/221115256-6ba16c4a-0830-4487-9d1b-d5dbe0efe2e0.png">


## AOP 
- 핵심 비즈니스 로직이 아닌 공통 관심사 들을 효과적으로 처리 할 수 있다.

## Spring AOP
- AOP 를 적용하기 위해서는 먼저 스프링 빈에 등록되어있어야 한다.
- AOP 로 등록된 빈은 처음 스프링 뜰때 가짜 객체 프록시 객체를 넣어두고, joinPoint.proceed 실행될때 구현체 호출해서 실행.

## Example 요구사항
- 게시판 CRUD 에서 API 호출 시 쿼리가 몇번 나가는지 Log 를 찍어준다.

### 핵심 기능
- 게시판 CRUD
- Layer Architecture 적용해보기

### 추가 요구사항
- 쿼리가 몇번 나가는지 각 API 마다 로그를 통해 확인 할 수 있어야 함