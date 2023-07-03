document.addEventListener("DOMContentLoaded", () => {
  const main_nav = document.querySelector("nav.main");
  const navClickHandler = (e) => {
    const nav_item = e.target;
    if (nav_item.tagName === "LI") {
      const nav_class = nav_item.className;
      let location = `${rootPath}`;
      /*
     
      if (nav_class === "home") {
        location += `/`;
      } else if (nav_class === "login") {
        location += `/user/login`;
      } else if (nav_class === "join") {
        location += `/user/join`;
      } else if (nav_class === "logout") {
        location += `/user/logout`;
      } else if (nav_class === "mypage") {
        location += `/user/mypage`;
      } else if (nav_class === "admin") {
        location += `/admin`;
      } else {
        location += "/";
      }
      */

      document.location.href = location;
    }
  };
  main_nav?.addEventListener("click", navClickHandler);
});
