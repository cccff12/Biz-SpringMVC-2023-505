document.addEventListener("DOMContentLoaded", () => {
  const btn_list = document.querySelector("button.detail.list");
  const btn_update = document.querySelector("button.detail.update");
  const btn_delete = document.querySelector("button.detail.delete");
  // null safe방지
  btn_list?.addEventListener("click", () => {
    document.location.href = `${rootPath}/`;
  });

  btn_update?.addEventListener("click", (e) => {
    const id = e.target.dataset.id;
    document.location.href = `${rootPath}/update?id=${id}`;
  });

  btn_delete?.addEventListener("click", (e) => {
    // button tag가 가장 중앙에 있기 떄문에
    // click event에 e.target은 delete button 이 된다.
    const btn = e.target;
    const id = btn.dataset.id;
    if (confirm("삭제한 데이터는 복구 할 수 없습니다.\n 정말 삭제할까요?")) {
      //   JS에서 서버 요청한 후 화면에 대한 것
      // document.location.href = "URL" 으로 요청을 하면
      // 현재 화면이 뒤로 밀쳐지도, 새로운 화면이 열리면서
      // 서버의 reponse내용을 보여준다
      // 이때는 Browser 의 뒤로가기를 클릭하면 이전 내용을 볼 수 있다.
      // document.location.replace(URL) 으로 요청을 하면
      // 현재 화면에 서버로부터 전달받은 화면이
      // 겹쳐서 표현된다.
      // 뒤로가기 화면을 없애는 효과를 낸다
      document.location.replace(`${rootPath}/delete?id=${id}`);
    }
  });
});
