#language:pt
#enconding:utf-8

  @Regressivo @Compra
  Funcionalidade: Realizar compra

    Esquema do Cenário: Compra de item aleatório com sucesso <portal>
      Dado que eu esteja na tela de Login "<portal>" "<url>"
      Quando preencher o campo Usuario "<usuario>"
      E preencher o campo Senha "<senha>"
      E clicar no botão Login
      Quando adicionar um produto ao carrinho
      E ir para o carrinho
      E clicar em Checkout
      Quando preencher dados solicitados "<nome>" "<sobrenome>" "<cep>"
      E clicar em Continue
      Quando validar pagina do pedido
      E clicar em finish
      Então devo validar mensagem de sucesso "<mensagem>"

      Exemplos:
        | portal    | url                       | usuario       | senha        | mensagem                 | nome | sobrenome | cep      |
        | Swag Labs | https://www.saucedemo.com | standard_user | secret_sauce | THANK YOU FOR YOUR ORDER | Joao | Junior    | 71000000 |