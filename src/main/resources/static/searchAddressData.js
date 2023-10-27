document.getElementById("searchCepBtn").addEventListener("click", function () {
    var cep = document.getElementById("cepInput").value;

    if (!cep) {
        alert("Campo CEP é obrigatório. Por favor, preencha o campo CEP.");
    } else {
        fetch("/api/searchCep", {
            method: "POST",
            body: JSON.stringify({ cep: cep }),
            headers: {
                "Content-Type": "application/json"
            }
        })
        .then(response => {
            if (response.status === 400) {
                alert("Requisição inválida. Verifique o CEP e tente novamente.");
            } else {
                return response.json();
            }
        })
        .then(data => {
            var addressData = document.getElementById("addressData");
            addressData.innerHTML = `
                <p>CEP: ${data.cep}</p>
                <p>Logradouro: ${data.logradouro}</p>
                <p>Complemento: ${data.complemento}</p>
                <p>Bairro: ${data.bairro}</p>
                <p>Localidade: ${data.localidade}</p>
                <p>UF: ${data.uf}</p>
                <p>IBGE: ${data.ibge}</p>
                <p>GIA: ${data.gia}</p>
                <p>DDD: ${data.ddd}</p>
                <p>SIAFI: ${data.siafi}</p>
            `;
        })
        .catch(error => {
            console.error("Erro ao consultar o CEP:", error);
        });
    }
});
