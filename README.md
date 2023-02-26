# AOP-DEMO
- AOP 개념을 예제를 통해 적용해보는 경험을 합니다.
- 예제를 구현하면서 Layered Architecture 를 적용해봅니다.
<img width="770" alt="스크린샷 2023-02-24 오후 4 07 32" src="https://user-images.githubusercontent.com/80501465/221115256-6ba16c4a-0830-4487-9d1b-d5dbe0efe2e0.png">


## AOP 
- 핵심 비즈니스 로직이 아닌 공통 관심사 들을 효과적으로 처리 할 수 있다.

## Example 요구사항
- 게시판 CRUD 에서 API 호출 시 쿼리가 몇번 나가는지 Log 를 찍어준다.

### 핵심 기능
- 게시판 CRUD 

### 추가 요구사항
- 쿼리가 몇번 나가는지 각 API 마다 로그를 통해 확인 할 수 있어야 함
- Layer Architecture 적용해보기
- 시나리오 테스트 작성해보기
