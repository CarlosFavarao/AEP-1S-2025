// Selecionar todos os botões de copiar
const copyButtons = document.querySelectorAll('.copy-btn');

copyButtons.forEach(button => {
  button.addEventListener('click', function () {
    // Encontrar o conteúdo que será copiado
    const target = document.querySelector(this.getAttribute('data-clipboard-target'));

    // Criar um range para selecionar o conteúdo do elemento
    const range = document.createRange();
    range.selectNode(target);

    // Adicionar o conteúdo selecionado à área de transferência
    const selection = window.getSelection();
    selection.removeAllRanges();
    selection.addRange(range);

    // Copiar para a área de transferência
    try {
      document.execCommand('copy');
    } catch (err) {
      console.error('Erro ao copiar', err);
    }

    // Remover a seleção após a cópia
    selection.removeAllRanges();
  });
});

// Script para exibir cidades com base no tipo de doação selecionado
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
