// Função para adicionar novas tarefas;
function adicionarTarefa() {
    // Pegando o valor do input que o usuário insere a tarefa; 
    let descricao = document.getElementById('descricaoTarefa').value;

    // Se a variável estiver vazia retorna um alert;
    if (descricao === '') {
        alert('Digite uma descrição para a tarefa.');
        return;
    }
    // Objeto para pegar a tarefa e o status;
    let tarefa = {
        descricao,
        status: 'A concluir'
    };
    /* Recupera os dados na localStorage e guarda dentro do array, 
    caso não encontre nada retorna null */
    let tarefas = JSON.parse(localStorage.getItem('tarefas')) || [];

    // Empurrar os dados inseridos para dentro do vetor; 
    tarefas.push(tarefa);

    // Inserir os novos dados dentro do localStorage;
    localStorage.setItem('tarefas', JSON.stringify(tarefas));

    // Mensagem se a tarefa for adicionada;
    alert('Tarefa adicionada com sucesso!');

    // Limpar o campo tarefa;
    document.getElementById('descricaoTarefa').value = ''; 
}

// Função para atualizar a lista de tarefas
function listarTarefas() {
    // Pegar o campo da tabela
    let listaTarefas = document.getElementById('listaTarefas');
    listaTarefas.innerHTML = ''; // Deixar zerado o campo;

    /* Recupera os dados na localStorage e guarda dentro do array, 
    caso não encontre nada retorna null*/
    let tarefas = JSON.parse(localStorage.getItem('tarefas')) || [];
    
    // Se o tamanho do array for igual o zero retorna uma mensagem;
    if (tarefas.length === 0) {
        listaTarefas.innerHTML = '<tr><td colspan="3">Não há tarefas para serem tratadas.</td></tr>';
        return;
    }
    // Adicionar as tarefas na tela através do for-each;
    tarefas.forEach(function (tarefa, index) {
        // Criando um elemento 'linha' do tipo HTML 'tr' para colocar na tela;
        let linha = document.createElement('tr');
        
        /* Coloca no HTML o código abaixo, resumindo ele colocará a descrição e o status da tarefa. 
        Depois ele coloca dois botões que possibilitaram a tarefa ser alterada ou excluida. Por
        último iremos adicionar no HTML as informações, com o appendChild adicionamos vários
        elementos em sequência dentro do HTML */  
        linha.innerHTML = `<td>${tarefa.descricao}</td>
                         <td>${tarefa.status}</td>
                        <td>
                         <button class="alterarStatus" onclick="alterarStatus(${index})">Alterar</button>
                         <button class="excluirStatus" onclick="excluirTarefa(${index})">Excluir</button>
                        </td>`;
        listaTarefas.appendChild(linha);
    });
}

// Função para alterar o status da tarefa
function alterarStatus(index) {
    /* Recupera os dados na localStorage e guarda dentro do array, 
    caso não encontre nada retorna null */
    let tarefas = JSON.parse(localStorage.getItem('tarefas')) || [];

    // Operador ternário para trocas o status da tarefa;
    tarefas[index].status = tarefas[index].status === 'A concluir' ? 'Concluída' : 'A concluir';
    
    // adicionando o item modificado;
    localStorage.setItem('tarefas', JSON.stringify(tarefas));
    
    // Mensagem para informar que a tarefa foi alterada
    alert('Tarefa alterada com sucesso!'); 
    
    // Abrindo a função que lista a função para atualizar as alterações;
    listarTarefas(); 
}

// Função para excluir uma tarefa
function excluirTarefa(index) {
    /* Recupera os dados na localStorage e guarda dentro do array, 
    caso não encontre nada retorna null */
    let tarefas = JSON.parse(localStorage.getItem('tarefas')) || [];
    
    // Excluindo o elemento pelo índice;
    tarefas.splice(index, 1); 
    
    // Adicionando o item excluído do vetor para remover do localStorage; 
    localStorage.setItem('tarefas', JSON.stringify(tarefas));
    
    // Mensagem para informar que a tarefa foi excluída;
    alert('Tarefa excluída com sucesso!');
    
    // Abrindo a função que lista a função para atualizar as alterações;
    listarTarefas();
}

function limparlocalStorage(){
    /* Recupera os dados na localStorage e guarda dentro do array, 
    caso não encontre nada retorna null */
    let tarefas = JSON.parse(localStorage.getItem('tarefas')) || [];

    if(tarefas.length === 0){
        alert('Sem dados para excluir!')
        return
    }
    // Limpando todos os dados dentro do localStorage;
    localStorage.clear();
    
    // Mensagem para informar que a localStorage está limpa;
    alert('Todos os dados foram excluídos!');
    
    // Abrindo a função que lista a função para atualizar as alterações;
    listarTarefas();
}

// Inicializa a lista de tarefas ao carregar a página;
listarTarefas();
