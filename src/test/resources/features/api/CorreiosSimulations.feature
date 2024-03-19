#language: pt

@GlobalExecution @Api @SmokeTest
Funcionalidade: Consultar dados de endereco do cliente

  Contexto:
    Dado ter a ciencia do cep do cliente


  Cenario: Pesquisar cep de cliente para entrega
    Quando requisitar os dados de endereco do cliente
    Entao verificar o retorno das informacoes com sucesso
    E validar o numero do cep enviado
