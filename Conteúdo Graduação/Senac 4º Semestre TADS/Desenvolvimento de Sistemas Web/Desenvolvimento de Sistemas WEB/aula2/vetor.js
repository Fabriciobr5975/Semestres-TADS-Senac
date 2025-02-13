// delete vetpr[2]

// Vetor
let vetor = []; // cria vetor
vetor[0] = 10; // adiciona valor na posição 0 
vetor[10] = 20; // adicionar valor na posição 10

vetor.push(10); // adiciona valores no final
vetor.push(15);
vetor.push(20);

vetor.shift(); // Remove do inicio
vetor.pop(); // Removo do fim
vetor.splice(1, 1); // remove do meio

for (let item of vetor) { // iteração for-each
  console.log(item);
}
