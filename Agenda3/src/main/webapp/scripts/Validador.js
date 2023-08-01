/**
* Validador dos campos 
 * @author Artur Neves Almeida
 */
function validar(){
	// ele recebe tudo passa tudo 
	// tem 3 tipos de variaveis
	// const constante, ele pega a larnajada tipo uma variavel e sempre vai ler oq ele receber, não pode mudar para as parada do html 
	// let esclopo fechado 
	// var escolpo global
	
	let nome = NomeDoForm.nome.value;
	let fone = NomeDoForm.fone.value;
	if(nome.trim()===""){
		
		alert('preencha o campo nome ');
		NomeDoForm.nome.focus();
		return false
		}
		else if (fone.trim()===""){
			
			alert('preencha o campo Telefone ');
		NomeDoForm.fone.focus();
		return false
		}
		else {
			document.forms["NomeDoForm"].submit();
		}
	}
