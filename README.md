# JSP 프로젝트

## TDD를 통한 설계
- 의존성 추가(pom.xml)
    - junit5
    - mockito
    - maven-sure-fire plugin
    - servlet-api 
    - servlet.jsp-api 
    - jstl api
    - jstl implementation
    - lombok
- 톰캣10 서버 설정
- 회원 가입 기능 설계(JoinService)
    - models/member/JoinService.java
    - 필수 항목 검증(아이디, 비밀번호, 비밀번호 확인, 회원명, 이메일)
    - 아이디 중복 여부 체크 - 중복된 경우 가입 불가
    - 아이디 자리수(6자리 이상), 비밀번호 자리수(8자리 이상) 체크
    - 비밀번호, 비밀번호 확인 입력 데이터 일치여부 체크 
    - 회원 정보를 저장