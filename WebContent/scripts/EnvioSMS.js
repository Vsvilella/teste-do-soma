/**
 * Consumindo API e enviando o SMS
 */
function envioSMS(fone){
var request = new XMLHttpRequest();
var mensagem = document.getElementById('mensagem').value;
if(mensagem.length > 160){
	alert("Limite de caracteres excedido. o sms e limitado a 160")
}else{
//console.log(mensagem);

request.open('POST', 'https://api.nvoip.com.br/v1/sms');

request.setRequestHeader('Content-Type', 'application/json');
request.setRequestHeader('token_auth', 'df97ccd1b8ea4ed015547788d7394d4fc606f');

request.onreadystatechange = function () {
  if (this.readyState === 4) {
    console.log('Status:', this.status);
    console.log('Headers:', this.getAllResponseHeaders());
    console.log('Body:', this.responseText);
  }
};

var body = {
  'celular': fone,
  'msg': mensagem
};
console.log(fone);

request.send(JSON.stringify(body));

if(this.status == 500) {
	document.getElementById('result').value = "Ocorreu um erro. Tente novamente!";
} else {

		document.getElementById('result').value = "Mensagem enviada com sucesso!";
	}
}
}