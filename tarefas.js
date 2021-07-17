//classe tarefa
//classe não é hosited.
class Tarefa {
    constructor(nome, categoria, realizada) {
        this.nome = nome;
        this.categoria = categoria;
        this.realizada = realizada
    }
}

//vetor de tarefas
tarefas = [];
//criando objetos tarefas
t1 = new Tarefa('Comprar leite', 'compras', false);
t2 = new Tarefa('Escutar chimbinha', 'lazer', true);
//inserindo tarefas no vetor de tarefas
tarefas.push(t1);
tarefas.push(t2);