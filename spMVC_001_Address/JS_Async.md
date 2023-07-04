# JS 비동기, 동기식
- JS 코드는 기본적으로 비동기 방식으로 작동한다
- 비동기 방식은 어떤 코드가 실행될때, 많은 동작이 필요한 경우, 그 동장이 작동되는 동안에 다른 동작이 마지 동시에 되는 것처럼 보이게 하는 것

## fetch를 사용한 AJAX 통신
- 보이는 화면에서 JS 코드를 사용하여 fetch 로 서버에 요청을 보내는 경우, fetch 시작부터 서버에 요청이 전달되고, 서버로부터 응답이 다다를때까지 실제 사용자의 화면은 다른 일을 수행하도록 진행된다.
- fetch의 결과가 완료될때까지 기다리지 않는다.
- 이 프로젝트에서 ID 중복을 조회하는 경우, 만약 다른 곳을 마우스로 클릭하여 입력을 하는 경우 입력이 진행되는 과정에서 ID 중복 조회 결과가 나중에 도달하게 된다. 그러면 입력하던 화면에서 focus 가 벗어나고, 입력을 중단하게 된다.
- 실제로는 ID 입력항목에 ID를 입력하고, 서버로부터 응답이 완료된 다음에, 다음 항목을 입력하도록 해야 하는데, 비동기 방식에서는 그 타이밍이 애매하게 진행된다.
- 이러한 현상을 방지하기 위하여 fetch를 동기식으로 변경한다.
- fetch를 동기식으로 변경하면, ID를 입력하고 ID조회가 완료된 후에 다른 항목을 입력하도록 잠시 기다리게 된다.

## fetch를 동기식으로 변경하기 
1. 함수를 선언할 때 함수에 async 키워드를 부착한다.
2. `fetch().then().then()` 형식으로 사용하던 코드를 동기식으로 변경한다.
``` js
const server = async()=>{
// fetch 동작이 완료되기를 기다리고
	// 서버로부터 응답된 response 결과를 변수에 저장
const res = await fetch(URL);
// 서버의 응답(response)에서 text결과만 추출하여 변수 result에 저장하라
const result = await res.text()
if(result==="ok")...
else ...
}

```