# Blockchain in Java

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)




#### Este projeto implementa uma blockchain simples em Java, com foco em demonstrar os conceitos básicos de como funciona uma blockchain: encadeamento de blocos, hash, e geração de um novo bloco a cada intervalo de tempo.

## Funcionalidade

- ### O projeto cria uma blockchain simples onde:

    - Um bloco gênese (o primeiro bloco da cadeia) é criado.

    - Após a criação do bloco gênese, um novo bloco é gerado automaticamente a cada 3 segundos, com base no bloco anterior.

    - Cada bloco contém:

        - Um índice (posição do bloco na cadeia).
        - Um timestamp (data e hora de criação).
        - Dados fictícios (aqui representados como Block Data com um número sequencial).
        - Nomes dos blocos escolhidos aleatóriamente.
        - O hash do bloco anterior, garantindo a integridade da cadeia.
        - O próprio hash do bloco, que é recalculado toda vez que um novo bloco é criado.

## Como Funciona?

- Bloco Gênese: O primeiro bloco é criado manualmente. Ele não tem um bloco anterior e não possui hash (é um caso especial na blockchain).
- Blocos Subsequentemente Criados: A cada 3 segundos, um novo bloco é criado, com base no bloco anterior.
- Hashing: O hash de cada bloco é calculado usando a função de hash SHA256. Esse hash é a "impressão digital" do bloco, garantindo sua integridade.
- Encadeamento de Blocos: Cada bloco aponta para o bloco anterior por meio de seu hash, garantindo que, se qualquer bloco for alterado, todos os blocos subsequentes serão invalidos.

## Como Usar
- ### Requisitos:
  - #### Ter Java instalado.

- ### Clone o repositório:

        git clone https://github.com/Rodrigo-Kelven/Blockchain-Example
        cd Blockchain-Example

- ### Execute o código:

        javac Block.java GeradorNomes.java SimpleBlockchain.java
        java SimpleBlockchain

##### Saída esperada: O programa começará exibindo o bloco gênese, seguido de novos blocos gerados automaticamente a cada 3 segundos, imprimindo detalhes como índice, timestamp, dados, hash do bloco anterior e o hash do bloco atual.

### Exemplo de Saída

        Bloco minerado: 0000008c24d25caf23d627ccd91ced7dcf677f57c7368f67dedb01cb1a001ce3
        Blockchain iniciada com o bloco gênesis.
        Novos blocos serão criados a cada 3 segundos...
        Criando bloco com nome: Kelven
        Bloco minerado: 000015e93f66cc6b34a8b49c2b9d7c29881062e4b0ea42d1977a73838dd6328c
        Blockchain válida? true
        Número total de blocos: 2
        -----------------------------------------
        Criando bloco com nome: RaelDeles
        Bloco minerado: 0000d2a280fc692a246dbdbb95c8d7113f594d3b0136918aa8bd7ab21f51a150
        Blockchain válida? true
        Número total de blocos: 3
        -----------------------------------------
        Criando bloco com nome: TiagoDorgas
        Bloco minerado: 0000b5a02512c94a818a9b8a4499faafa2065c536bb5d1715d174618d8999bbf
        Blockchain válida? true
        Número total de blocos: 4
        -----------------------------------------
        Criando bloco com nome: WesleyMustafa
        Bloco minerado: 00001e464755237b115aca1bdf4950504138461083e39213f132717690106fb5
        Blockchain válida? true
        Número total de blocos: 5
        -----------------------------------------


### Tecnologias Utilizadas

- Java: Linguagem utilizada para a implementação da blockchain.
- SHA-256: Função de hash criptográfico usada para gerar os hashes dos blocos.

### Contribuições

Se você deseja contribuir para este projeto, fique à vontade para criar pull requests ou relatar issues. Melhorias como persistência de dados, maior segurança, e otimizações de desempenho são sempre bem-vindas.

## Autores
- [@Rodrigo_Kelven](https://github.com/Rodrigo-Kelven)
