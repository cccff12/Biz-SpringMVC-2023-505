# Conponent
- Spring MVC 프로젝트에서는 여러 class에 다양한 Annotation을 부착할 수 있다.
- @Controller, @Service, @Component 등의 Annotation을 클래스에 부착하고 이러한 Annotation이 부착된 클래스를 컴포넌트라고 부른다.
- 분리된 구조적 모듈로 표현할 수 있다.
- Spring MVC 프로젝트는 여러가지 다양한 Component 들이 모여서 서로 협력하며 프로젝트를 실행한다.

## component-scan
- Spring MVC 프로젝트가 `Run on Server서버에 의해 실행되면 ` Component Annotation 이 부착된 class 들은 자동으로 객체로 생성되고 Spring , Tomcat `Container` 에 보관된다.
- `Container` 에 보관된 `Component` 들은 필요한 경우 자동으로 서로 Wirering 된다.
- Spring MVC 프로젝트의 `servlet-contectext.xml` 파일을 확인해 보면 `conponent-scan` 이라는 항목이 있다.
- 프로젝트가 시작되면 `servlet-component.xml`의 `component-scan` 항목에 설정된 대로 프로젝트의 class들을 모두 scan하고 Annotation 이 부착된 class를 만나면 Component 로 만들어서 Container 에 보관한다.


### css, js 파일의 수정 후 반영 안되는 문제 
- Tomcat Server 를 start 할 때 JSP, Class 파일은 자동으로 변경되는 것을 감지하고 변경된 파일을 서버에 업로드 (publisher) 하여 새로고침을 하면 내용을 반영한다.
- 하지만 link 된 css나 script src="" 로 설정된 js 파일은 간혹 변경된 것을 감지하지 못하고, 아무리 파일을 변경해도 반영이 안되는 경우가 자주 있다.
- 이럴때는 link 파일 이름에 의미없는 값을 부착하고 ex>`?20230628` 서버를 재 시작 한다. 
- 만약 파일을 변경하고 내용이 반영되지 않으면 값을 다른 값으로 변경해주고 서버를 재 시작한다