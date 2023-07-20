// document.addEventListener("DOMContentLoaded", () => {}가 없음

const err_message = (e, err_box, message) => {
  const value = e.value;
  // if(value===""){} 이 코드와 밑의 코드는 같다. 0을 입력하면 "0"이 입력된 것과 같다
  if (!value) {
    err_box.classList.add("on");
    err_box.innerHTML = message;
    e.select();
    return false;
  }
  return true;
};
