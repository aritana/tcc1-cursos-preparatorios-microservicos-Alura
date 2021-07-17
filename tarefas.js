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
        itemEl.querySelector('li').classList.add('item-tarefa');
        itemEl.querySelector('li').classList.add(`categoria-${this.categoria}`);

        if (this.realizada) {
            itemEl.querySelector('li').classList.add('marcado');
        }

        containerEl.appendChild(itemEl);
    }

    static insereItemsNaPagina(containerEl, tarefas) {
        tarefas.forEach(tarefa => tarefa.criaItemsDeListaParaPagina(containerEl))
    }

}

//vetor de tarefas
const tarefas = [
    new Tarefa('Comprar leite', 'compras', false),
    new Tarefa('Escutar chimbinha', 'lazer', true)
];

let containerEl = document.querySelector("#lista-tarefas");
//remover tudo
containerEl.innerHTML = '';
//insere items
Tarefa.insereItemsNaPagina(containerEl, tarefas);

//exercício 02
let buttonIncluirNovaTarefaEl = document.querySelector('#incluir-nova-tarefa');

buttonIncluirNovaTarefaEl.addEventListener('click', (e) => {
    let el = e.currentTarget;
    console.log(el);
})