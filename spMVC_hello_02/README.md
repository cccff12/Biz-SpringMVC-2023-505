# Spring Project 
- Spring Legacy Project > Spring MVC Project 생성
- view/home.jsp 삭제후 다시 생성

## pom.xml 수정
- java version 을 11로 변경
- spring framework 5.2.24로 변경
- slf4j 1.7.36으로 변경

- maven- compiler-plugin java 버전 property 로 변경
<!-- Logging --> 여기 하나만 남기고 밑에 inject까지 삭제
- lombok 설정- 최신추가- <!-- test --> 위에 붙여넣기

- logback 설정- 1.2.12 추가 -logbackclasic, *scope 삭제해야함*, Logging 밑에 붙여넣기

- 프로젝트 우클릭 메이븐 -update project해줘야함

-	<!-- Test --> 가서  		
<source>${java-version}</source>
<target>${java-version}</target>
이 부분 이걸로 교체

# lombok 1.18.28

<!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.28</version>
    <scope>provided</scope>
</dependency>


# logback classic module 1.2.12

<!-- https://mvnrepository.com/artifact/ch.qos.logback/logback-classic -->
<dependency>
    <groupId>ch.qos.logback</groupId>
    <artifactId>logback-classic</artifactId>
    <version>1.2.12</version>
    <scope>test</scope>--이거 삭제
</dependency>





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
그리고 <c:forEach items="${USERS }" var="USER"></c:forEach>




입력한 Dto 값을 저장 버튼을 누른 후 보여주고 싶을때
controller 에

@RequestMapping(value = "/user/input", method = RequestMethod.GET)
	public String userinput() {
		return "user/input";
	}

	@RequestMapping(value = "/user/input", method = RequestMethod.POST)
	public String userInput( UserDto userDto, Model model) {		
		model.addAttribute("USER", userDto);
		return "user/view";
	}
이렇게 get과 post를 추가해주고  
dto값을 그대로 model에 넣는다
return 은 폴더의 파일 이고 value가 실제 사이트의 도메인이다.



