# Spring Project 
- Spring Legacy Project > Spring MVC Project 생성
- view/home.jsp 삭제후 다시 생성

## pom.xml 수정
- java version 을 11로 변경
- spring framework 5.2.24로 변경
- slf4j 1.7.36으로 변경

- maven- compiler-plugin java 버전 property 로 변경
<!-- Logging --> 여기 하나만 남기고 밑에 inject까지 삭제
- lombok 설정- 추가

- logback 설정- 추가

- 프로젝트 우클릭 메이븐 -update project해줘야함

-	<!-- Test --> 가서  		
<source>${java-version}</source>
<target>${java-version}</target>
이 부분 이걸로 교체

Dto 데이터 클래스 생성하기
- spring framework에서 사용하는 데이터 클래스는 모든 변수를 private로 선언한다.
- 변수에 접근하기 위하여 getter setter method를 필수로 생성한다.
- 두 개의 생성자, toString () 재정의
- lombok을 사용해 자동 생성한다.

## service 클래스 생성하기
- Service 클래는 기본적으로 Service interface를 만들고
interface를 Impl하여 작성한다.
- Service 클래스에 @Service Annotation을 부착한다
- @Service Annotation(@Service 이게 Annotation이다.) 이 부착된 클래스는 Spring Framwork
에서 자동으로 객체를 준비해 가지고 있따.
-@Autowired가 부착된 곳을 발견하면 자동으로 객체를 "주입하여 " 사용할 준비를 해 준다.


view 파일 세팅 
<!DOCTYPE html> 위에
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 세팅