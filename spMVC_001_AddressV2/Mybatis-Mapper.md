# Mybatis Mapper
- Mybatis 는 Dao interface 를 만들고 @Select , @Insert, @Update, @Delete 등의 Annotation을 사용해 간단하게 SQL을 만들수 있다.
- Annotation 에 설정된 SQL 명령문을 사용하여 실제 DBMS와 통신하는 class 코드를 작성한다.
- 개발자는 interface를 만들고 Annotation 을 사용한 SQL만 잘 작성하면 나머지는 Mybatis가 알아서 수행한다.
- Annotation을 이용한 SQL작성은 mybatis 3.5 이상에서만 사용할 수 있다.
- 또한 Annotation 방식은 다소 복잡한 SQL을 작성하는 데 많은 어려움이 있을 수 있다.
- Mybatis는 전통적으로 `mapper.xml` 을 사용해 SQL을 작성하도록 하였다.

## mapper.xml을 이용한 Mybatis 코딩
- Dao interface에는 메서드 정의만 하고, `/mapper/` 폴더에 mapper.xml 파일을 생성하여 여기에 SQL 코드를 작성한다.
- 매우 복잡하고, 복합적인 SQL문도 비교적 쉽게 작성할 수 있다.
- `SQL Developer`  등과 같은 도구를 사용하여 복잡한 SQL을 테스트 하고 , 완성된 코드를 복사 붙이기 방법으로 mapper.xml에 사용할 수 있다.
- Annotation 방식에서 문자열 이어붙이기 등으로 작성했던 SQL을 좀 더 쉽게 작성 할 수 있다.

- `DOCType Mapper` 형식의 xml 파일의 구조를 가지며, `namespace` 항목에 Dao interface의 path와 파일을 지정해 두고, `<select></select>` 등 과 같은 tag를 사용해 SQL 명령을 작성한다. 
- 이때 tag 에는 id속성을 부여하는데, 이 id에 Dao 의 method 이름을 지정해 준다.