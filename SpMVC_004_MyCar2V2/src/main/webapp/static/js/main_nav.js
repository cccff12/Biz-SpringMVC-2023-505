document.addEventListener("DOMContentLoaded", () => {
  const nav = document.querySelector("nav.main");
  const nav_login = document.querySelector("li.login");
  const nav_join = document.querySelector("li.join");

  /*
  event 핸들러의 매개변수 (e)
  e.currentTarget 과 e.target 속성이 기본으로 포함되어 있다.
  이때 e.currentTarget은 event 핸들러가 부착된 tag (여기서는 nav.main)이고
  e.target 은 event 버블링에 의해 가장 안쪽에서 실제 event가 적용되는 tag(li)

 sj : 원래 어떤 tag를 누르면 바깥쪽 div부터 선택되면서 가장 안쪽 tag가 마지막으로 선택되는 것인데
 e.currentTarget 는 가장 바깥쪽의(포함하는) tag를 말한다. 



  */
  const navClickHandler = (e) => {
    const current = e.currentTarget; //nav.main
    const target = e.target; // li
    if (target.tagName === "LI") {
      const targetClassName = target.className;
      let URL = `${rootPath}` + targetClassName;
      const USER_URL = "login join mypage logout";
      if (targetClassName === "home") {
        URL = `${rootPath}`;
      }
      /*문자열.indexOf("찾는문자열")
      문자열 내에 찾는 문자열이 있으면 0이상의 위치값을 return 
      없으면 -1을 return한다
      
      문자열.search("찾는문자열")
      정규표현식으로 문자열 찾기 가능
      */
      //   login join mypage logout 이라는 이름이 들어가 있다면
      else if (USER_URL.indexOf(targetClassName) > -1) {
        URL = `${rootPath}user/` + targetClassName;
      }
      //   } else if (targetClassName === "mycar") {
      //     URL += targetClassName;
      //   } else if (targetClassName === "tarcho") {
      //     alert("tarcho");
      //   } else if (targetClassName === "login") {
      //     alert("Nav 클릭한 login");
      //   }
      document.location.href = URL;
    }
  };
  // event bubblering 을 역으로 활용하여
  // 한 개의 event 를 설정하여 할 일 들 처이하기
  nav?.addEventListener("click", navClickHandler);
  //   // 개별적인 LI tag에 click evect 를 설정하여
  //   // nav를 선택했을 떄 할일들 지정
  //   nav_login?.addEventListener("click", () => {
  //     alert("login 나 클릭");
  //   });

  //   nav_login?.addEventListener("click", () => {
  //     alert("login 나 2 클릭");
  //   });

  //   nav_join?.addEventListener("click", () => {
  //     alert("join");
  //   });
});
/*

0,"",undefined, NaN, null 값이 if()명령을 만나면 
이 값들은 false로 취급한다.
0이 0이 아니라 false로 취급된다. if문은 불린함수이기 때문에


const 변수이름 = 0;
if(변수이름){
    console.log(`이 값은 0이 아님${변수}`)
}else{
    console.log(`이 값은 false로 취급 ${qustn}`)
}


const 변수1 = "" ; -> if문을 만나면 false
const 변수2 ; -> if문을 만나면 false
const 변수3 = 0 ; ->if문을 만나면 false

const 변수이름 = 변수1 && 변수2 && 변수3 && "몰라"
결국에는 "몰라값이 전달됨"
*/
