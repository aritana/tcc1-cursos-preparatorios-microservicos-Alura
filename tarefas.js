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