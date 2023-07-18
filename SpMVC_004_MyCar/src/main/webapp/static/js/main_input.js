const INPUT_INDEX = {
  C_CARNUM: 0,
  C_QTY: 1,
  C_USERNAME: 2,
  C_SDATE: 3,
  C_STIME: 4,
};

document.addEventListener("DOMContentLoaded", () => {
  const main_form = document.querySelector("form.main");

  const formEnterHandler = (e) => {
    const target = e.target;

    // 화면에서 엔터(13)가 눌리고
    // focus() 대싱이 INPUT tag면
    if (e.keyCode === 13 && target.tagName === "INPUT") {
      // focus()가 있는 input tag의 name속성을 getter
      //   대문자로 변경하라
      const input_name = target["name"].toUpperCase();
      //   현재 focus()가 있는 input tag가 몇 번째 tag이냐
      const input_index_num = INPUT_INDEX[input_name];
      //      현재 focus()가 있는 input tag가 마지막 input이 아니면
      if (input_index_num < Object.keys(INPUT_INDEX).length - 1) {
        // 다음번 input box로 이동하라
        document.querySelectorAll("input")[input_index_num + 1].focus();
      }
    }
  };
  document.addEventListener("keydown", formEnterHandler);
  document.querySelector("input[name='c_carnum']").focus();
});
