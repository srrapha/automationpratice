#language: pt

@GlobalExecution @Mobile
Funcionalidade: Login home

  Contexto:
    Dado que estou na pagina de inicio

  @CenarioComum @SmokeTest
  Cenario: Fazer login com usuario valido
    Quando clico no input de usuario
    E verifico se o texto da pagina inicial esta correto
    Entao realizo login no soucedemo

  @CenarioComEsquema
  Esquema do Cenario:Faler login com usuario valido passando por parametro
    Quando clico no input de usuario
    E verifico se o texto da pagina inicial esta correto
    Entao realizo login no soucedemo com usuario <Usuario> e senha <Senha>
    Exemplos:
      | Usuario       | Senha        |  |
      | standard_user | secret_sauce |  |