//classe tarefa
//classe não é hoisted.
class Tarefa {
    nome;
    categoria;
    realizada;
    constructor(nome, categoria, realizada) {
        this.nome = nome;
        this.categoria = categoria;
        this.realizada = realizada
    }
    criaItemsDeListaParaPagina(containerEl) {
        const template = `
            <li>
                ${this.nome}
            </li>
           `;
        const itemEl = document.createRange().createContextualFragment(template);
        containerEl.appendChild(itemEl);
    }
    static insereItemsNaPagina(containerEl, tarefas) {
        tarefas.forEach(tarefa => tarefa.criaItemsDeListaParaPagina(containerEl))
    }

}

//li
// classe item-tarefa
//se true->  classe marcado
//categoria: adicione ao classe categoria-NOME
// chamar a funcao para cada objeto que esta o vetor tarefas.
//mas remova os filhos que estiverem lá



//vetor de tarefas
const tarefas = [
    new Tarefa('Comprar leite', 'compras', false),
    new Tarefa('Escutar chimbinha', 'lazer', true)
];

let containerEl = document.querySelector("#lista-tarefas");
Tarefa.insereItemsNaPagina(containerEl, tarefas);


/*
let containerEl = document.querySelector("#lista-tarefas");
//1. cria um elemento
let t1El = document.createElement('li');
//2. configuracao
t1El.classList.add('item-tarefa');
t1El.classList.add('marcado');
t1El.innerHTML = "TESTE";
//3. insere na arvore
containerEl.appendChild(t1El);

const template = `
    <li class="item-tarefa marcado">
        Teste 2
    </li>
`

containerEl.innerHTML += template;

*/