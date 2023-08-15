const navBar = document.querySelector("nav"),
       menuBtns = document.querySelectorAll(".menu-icon"),
       overlay = document.querySelector(".overlay");
     menuBtns.forEach((menuBtn) => {
       menuBtn.addEventListener("click", () => {
         navBar.classList.toggle("open");
       });
     });

     overlay.addEventListener("click", () => {
       navBar.classList.remove("open");
     });
function openModal(modalId) {
    var modal = document.getElementById(modalId);
    modal.style.display = "block";
  }
  
function closeModal(modalId) {
    var modal = document.getElementById(modalId);
    modal.style.display = "none";
}
  