# [PoC] Redis Counter

Redis 기반의 Atomic Counter 구현 API를 검증하기 위한 프로젝트

## 구성 

- redis-server: Redis 서버. 로컬에 설치되어 있어야 함
- redis-counter: API 서버. Atomic Counter를 구현한 REST API 서비스
- eureka-server: Eureka 서버. API 서버의 Endpoint 정보를 가지고 있음
- zuul: Gateway 서버. 사용자 트래픽을 받아서 여러 대의 API 서버로 라우팅
- gatling: 부하 테스트 도구. 사용자 트래픽을 발생해서 응답 결과를 리포팅

## Atomic Counter REST API 규격

### Request 

> GET /counter HTTP/1.1

### Response

상태코드 | 응답 데이터 | 비고
--- | --- | ---
200 | 순번 | 선착순 500번째까지의 요청인 경우 성공
400 | 순번 | 선착순 500번째 이후의 요청인 경우 실패

## 검증 시나리오

1. eureka, zuul, redis-counter1, redis-counter2, redis-counter3 구동
1. gatling으로 동시접속자 600명으로 HTTP 요청 발생. 요청은 zuul로 전송
1. 응답 결과가 성공이 500개, 실패가 100개인지 확인
1. 응답 데이터가 1부터 600까지 중복되지 않고 출력되어 있는지 확인

## 실행

### 서버 구동

> ./start-server.sh

### 테스트 실행

> ./run-test.sh

### 서버 중지

> ./stop-server.sh

