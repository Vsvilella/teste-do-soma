/**
 * Validação do Formulário Novo contato
 */

function validar(){
	
	var nomeTeste = document.getElementById('nome').value;
	var telefoneTeste = document.getElementById('telefone').value;
	
	if(nomeTeste == ""){
		alert("Preencha o nome")
		formContato.nome.focus()
		
	} else if (telefoneTeste == ""){
		alert("Preencha o campo Telefone")
		formContato.fone.focus()
	
	} else if(telefoneTeste.length < 10 | telefoneTeste.length > 11) {
		
		alert("Preencha o campo corretamente! Exemplo: DDD sem o zero + número (1141186267)");
		
	} else {
			document.forms["formContato"].submit()
	}
}