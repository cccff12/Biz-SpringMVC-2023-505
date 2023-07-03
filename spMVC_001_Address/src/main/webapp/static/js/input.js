// HTML DOM 기반의 JS코드 시작점
document.addEventListener("DOMContentLoaded", () => {
  // div.message 의 index 변수
  const INDEX = {
    ID: 0,
    NAME: 1,
    TEL: 2,
    ADDR: 3,
  };

  //  DOM 객체(tag객체)
  // JS의 false판별
  // 어떤 변수의 값이 null undefined, "",0,NaN(Not a number) 등의
  // 값을 가질 때 변수 || 연산을 수행하면
  // 이 연산은 if(!변수) 와 같은 코드처럼 작동한다.
  // 변수 || 연산을 수행하면 이 결과는 false처럼 작동한다.
  // 1. 변수 1의 값이 false가 아니면 변수 1의 값을 왼쪽 변수에 대입
  // 2. 변수 2의 값이 false이면 변수 2의 값을 비교
  // 3. 변수 2의 값이 false가 아니면 변수 2의 값을 왼쪽 변수에 대입
  // 4. 변수 4까지 모든 변수가 flase인 값을 가지고 있으면
  // 5. 왼쪽 변수 에는 없음이라는 문자열이 대입된다.

  // let  변수 =null
  // if(변수1)변수=변수1
  // else if(변수2) 변수=변수2
  // else if(변수3) 변수= 변수3
  // else if(변수4) 변수= 변수4
  // else 변수="없음"

  // 쉽게 말하면 밑처럼 두 개 가 있을 경우 먼저오는 것의 true를 적용한다. 전부 false면 null값 대입됨
  const form_addr =
    document.querySelector("form.main.input") ||
    document.querySelector("form.main.update");

  const input_id = form_addr?.querySelector("input[name='a_id']");
  const input_name = document.querySelector("input[name='a_name']");
  const input_tel = document.querySelector("input[name='a_tel']");
  const input_addr = document.querySelector("input[name='a_addr']");

  const btn_input = document.querySelector("button.input");

  const btn_list = document.querySelector("button.list");

  const msg_boxs = document.querySelectorAll("div.message");

  // 2개의 매개변수를 받는 함수 선언
  const message_view = (index, className, message) => {
    const msg_box = msg_boxs[index];
    msg_box?.classList.remove("ok");
    msg_box?.classList.remove("error");
    msg_box?.classList.add(className);
    msg_box.querySelector("span").innerHTML = message;
  };

  //   inline 익명(무명) 함수로 click event 설정
  btn_list?.addEventListener("click", (e) => {
    // alert("리스트 버튼 클릭");
    // 현재 화면에 보여줄 페이지 요청하기
    document.location.href = `${rootPath}`;
  });

  // event call 함수를 선언하고
  const inputButtonClickHandler = (e) => {
    // alert("추가 버튼 클릭");
    // js코드에서 form에 포함된 버튼을 클릭했을때 server로 데이터를 전송하라

    for (let i = 0; i < msg_boxs.length; i++) {
      msg_boxs[i].classList.remove("ok");
      msg_boxs[i].classList.remove("error");
    }

    if (input_id && !input_id.value) {
      message_view(INDEX.ID, "error", "*ID 는 반드시 입력해야 합니다.");

      input_id.focus();
      return false;
    }
    if (!input_name.value) {
      message_view(INDEX.NAME, "error", "* 이름은 반드시 입력해야 합니다.");
      input_name.focus();
      return false;
    }
    if (!input_tel.value) {
      message_view(INDEX.TEL, "error", "* 전화번호는 반드시 입력해야 합니다.");
      input_tel.focus();
      return false;
    }

    const tel_rexp = /^\d{3}-\d{3,4}-\d{4}$/;
    if (!tel_rexp.test(input_tel.value)) {
      message_view(
        INDEX.TEL,
        "error",
        "전화번호 형식이 틀립니다(010-0000-0000)"
      );
      input_tel.focus();
      input_tel.select();
      return false;

      // addr_input?.submit();
    }
    if (!input_addr.value) {
      message_view(INDEX.ADDR, "error", "* 주소는 반드시 입력해야 합니다.");
      input_addr.focus();
      input_addr.select();

      return false;
    }
    if (confirm("저장할까요")) {
      form_addr?.submit();
    }

    // input_id = document.querySelector("form.main input [name='a_id']")
  };

  //   선언된 event call 함수를 사용하여 click event 선언
  btn_input?.addEventListener("click", inputButtonClickHandler);

  input_id?.addEventListener("blur", async (e) => {
    const value = e.target.value;

    const idCheck_url = `${rootPath}/id_check?id=${value}`;

    if (!value) {
      message_view(INDEX.ID, "error", "*ID를 입력해주세요");
      input_id.focus();
      return false;
    }

    const response = await fetch(idCheck_url);
    const result = await response.text();

    if (result === "OK") {
      message_view(INDEX.ID, "ok", "*사용가능한 ID입니다.");
    } else if (result === "FAIL") {
      message_view(INDEX.ID, "ok", "*이미 추가된 ID입니다.");

      input_id.focus();
    } else {
      message_view(INDEX.ID, "error", "*서버오류.");
      input_id.focus();
    }
  });
});
