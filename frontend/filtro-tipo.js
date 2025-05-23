document.addEventListener('DOMContentLoaded', function () {

  const params         = new URLSearchParams(window.location.search);
  const tipoDoacaoId   = params.get('tipoDoacaoId'); // ex: ?tipoDoacaoId=1

  // Elementos do DOM para buscar pontos
  const selectCidade = document.getElementById('cidade');
  const btnBuscar    = document.getElementById('buscar-pontos-btn');
  const ulPontos     = document.getElementById('pontos-list');

  btnBuscar.addEventListener('click', () => {
    const cidadeId = selectCidade.value;
    if (!tipoDoacaoId || !cidadeId) {
      alert('Selecione uma cidade válida.');
      return;
    }

    // limpa resultados antigos
    ulPontos.innerHTML = '';


    fetch(
      `http://localhost:8080/pontos-coleta/filtrar`
      + `?tipoDoacaoId=${tipoDoacaoId}&cidadeId=${cidadeId}`
    )
    .then(res => {
      if (!res.ok) throw new Error('Falha na requisição');
      return res.json();
    })
    .then(pontos => {
      if (pontos.length === 0) {
        ulPontos.innerHTML = '<li>Nenhum ponto de coleta encontrado.</li>';
        return;
      }

      pontos.forEach((p, idx) => {
        const idInfo = `info${idx}`;
        const li = document.createElement('li');
        li.className = 'd-flex align-items-start gap-2';
        li.innerHTML = `
          <img src="https://i.postimg.cc/3RVF8f1M/localizacao.png"
               alt="Localização" class="icone-modal">
          <div>
            <h5 class="mb-0">${p.nome}</h5>
            <p id="${idInfo}">
              ${p.endereco} – ${p.diasFuncionamento} – ${p.horarioFuncionamento}
            </p>
          </div>
          <button class="btn btn-sm btn-outline-success copy-btn"
                  data-clipboard-target="#${idInfo}">
            <i class="fa fa-copy"></i>
          </button>
        `;
        ulPontos.appendChild(li);
      });

      document.querySelectorAll('.copy-btn').forEach(button => {
        button.addEventListener('click', function () {
          const target = document.querySelector(
            this.getAttribute('data-clipboard-target')
          );
          const range = document.createRange();
          range.selectNode(target);
          const sel = window.getSelection();
          sel.removeAllRanges();
          sel.addRange(range);
          try {
            document.execCommand('copy');
          } catch (err) {
            console.error('Erro ao copiar', err);
          }
          sel.removeAllRanges();
        });
      });
    })
    .catch(err => {
      console.error(err);
      ulPontos.innerHTML = '<li>Erro ao buscar pontos de coleta.</li>';
    });
  });
});
