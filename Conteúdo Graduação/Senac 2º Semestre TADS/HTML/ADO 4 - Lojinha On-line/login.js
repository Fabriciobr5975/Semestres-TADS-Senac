// Array que conterá os objetos para armazenar na localStorage os dados dos clientes;
let clientes = []
let cliente = {
    id: "1",
    username: "João Santana",
    email: "joaoSantana23@.com",
    password: "123",
    image: "imagens/fotoJoao.png" 
}
// Empurrando os objetos para o array;
clientes.push(cliente);
// Criando a localStorage para guarda os dados dos clientes;
localStorage.setItem('LoginCliente', JSON.stringify(clientes));

// Função para efetuar o login dos usuarios;
function efetuarLogin() {
    // Pegando os dados do HTML;
    let email = document.getElementById('inputEmail').value;
    let senha = document.getElementById('inputSenha').value;

    // Verificando se os campos estão vazios após quando o usuário clicar no botão;
    if (email === '' || senha === '') {
        alert('Preencha os campos para efetar o login!');
        return;
    }

    // Pegando os dados da localStorage que armazena os dados dos clientes;
    let loginSalvo = JSON.parse(localStorage.getItem('LoginCliente')) || [];
    let loginCadastrado = false; // Verificar se o login foi realizado;

    loginSalvo.forEach(cliente => {
        if (cliente.email === email && cliente.password === senha) {
            loginCadastrado = true;
            // Abrir a tela se o login for efetuado;
            window.location.href ="vitrine.html";
            // Mensagem se o login for efutuado;  
            alert(`Login efetuado com sucesso!`);
            
        } else {
            // Mensagem se o usuário não for encontrado;
            alert(`Usuário não encontrado!`); 
        }
    });
}

