/**
 * Confirmar exclusão de um contato
 * @author Artur Neves Almeida
 */
function confirmar(idcon){
	let resposta = confirm("confirma a exclusão deste contato?")
	if (resposta===true){
	window.location.href="delete?idcon="+idcon
	
	}
	
	
	
}