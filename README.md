# Exemplo de um sistema multi-agente programado em JADE

## Descrição do projeto

A aplicação e desenvolvida usando o Framework JADE.
 * Um produtor (Produz um produto definido pelo usuário)
 * N consumidores
  
### Ambiente de desenvolvimento
 * Sistema Operacional Ubuntu
 * IDE Intellij
 * Java JDK 8.121
 * jade.jar disponível no site <https://jade.tilab.com/download> no arquivo bin
 
 ### Características gerais do projeto
 * O **Produtor** define um preço e o comunica aos consumidores.
 * Os **consumidores** têm cada um o seu próprio pedido relativamente à quantidade do produto que pretendem comprar
por esse preço.
 
## Detalhes de implementação

* Arquitetura

![alt text][architecture]


 * Pacotes
 
![alt text][packages]

 * Classes
 
![alt text][classes]
 
 * Sequência
 
 ![alt text][behaviours]
 
 * Comunicação
 
 ![alt text][communication]

[description]: imgs/DESCRIPTION.png
[beans]: imgs/DIAG_DONNEES.png
[actors]: imgs/DIAG_USECASE.png
[behaviours]: imgs/DIAG_SEQUENCE.png
[communication]: imgs/DIAG_COMM.png
[architecture]: imgs/DIAG_DEPLOY.png
[packages]: imgs/DIAG_PACKAGE.png
[classes]: imgs/DIAG_CLASS.png
[execution]: imgs/EXECUTION.png
[agents]: imgs/JADE_RMA.png
[sniffer]: imgs/JADE_SNIFFER.png
