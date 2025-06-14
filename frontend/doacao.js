
const copyButtons = document.querySelectorAll('.copy-btn');

copyButtons.forEach(button => {
  button.addEventListener('click', function () {
    const target = document.querySelector(this.getAttribute('data-clipboard-target'));

    const range = document.createRange();
    range.selectNode(target);

    const selection = window.getSelection();
    selection.removeAllRanges();
    selection.addRange(range);

    try {
      document.execCommand('copy');
    } catch (err) {
      console.error('Erro ao copiar', err);
    }
    selection.removeAllRanges();
  });
});

document.addEventListener("DOMContentLoaded", function () {
  const tipoButtons = document.querySelectorAll(".tipo-doacao-btn");
  const cidadeSections = document.querySelectorAll(".cidade-section");

  tipoButtons.forEach(btn => {
    btn.addEventListener("click", function () {
      const tipo = btn.getAttribute("data-tipo");
      cidadeSections.forEach(section => {
        if (section.getAttribute("data-tipo") === tipo) {
          section.style.display = "block";
        } else {
          section.style.display = "none";
        }
      });
    });
  });
});
