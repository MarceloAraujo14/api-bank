const nome = document.getElementById('name')
const sobrenome = document.getElementById('lastname')
const cpf = document.getElementById('cpf')
const rg = document.getElementById('rg')
const dataNascimento =  document.getElementById('data')
const renda = document.getElementById('renda')
const email =  document.getElementById('email')
const senha = document.getElementById('senha')
const confirmarSenha = document.getElementById('confirmar-senha')
const cep = document.getElementById('cep')
const rua = document.getElementById('logradouro')
const numero = document.getElementById('numero')
const complemente = document.getElementById('complemento')
const bairro = document.getElementById('bairro')
const cidade = document.getElementById('localidade')
const estado = document.getElementById('uf')

/*function validate (item) {
    item.setCustomValidity('')
    item.checkValidity()

    if (item = confirmarSenha) {
        if (item.value === senha.value){
            item.setCustomValidity('')
        } else {
            item.setCustomValidity('As senhas digitadas não são iguais, verifique e corrija.')
        }
    }
}*/


function validarSenha() {
    const campo1 = document.getElementById('senha').value
    const campo2 = document.getElementById('confirmar-senha').value
    
    if (campo1 === campo2) {
        document.getElementById('resultado').style.color = '#008b45'
        document.getElementById('resultado').innerHTML = 'As senhas são iguais'
    } else {
        document.getElementById('resultado').style.color = '#FF6347'
        document.getElementById('resultado').innerHTML = 'As senhas não correspondem'
    }
}

function fimEvento(){
    document.getElementById('resultado').innerHTML = ''
}

