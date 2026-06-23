# Projeto Hamburgueria - Padroes de Projeto

Sistema exemplo para uma hamburgueria usando os padroes do projeto do professor.

## Padroes permitidos e aplicados

| Categoria | Padrao | Operacao da hamburgueria |
|---|---|---|
| Criacao | Abstract Factory | Criar familias de combos, como tradicional e vegano |
| Criacao | Builder | Montar pedido com cliente, lanche, bebida e entrega |
| Criacao | Factory Method | Criar hamburgueres do cardapio |
| Criacao | Prototype | Clonar pedidos ou combos modelo |
| Criacao | Singleton | Controlar estoque unico da loja |
| Estrutural | Decorator | Adicionar bacon e queijo ao lanche |
| Estrutural | Adapter | Adaptar pagamento externo ao sistema da hamburgueria |
| Estrutural | Bridge | Separar tipo de lanche da forma de preparo |
| Estrutural | Composite | Montar combos com lanche, bebida e acompanhamentos |
| Estrutural | Facade | Realizar o fluxo completo de venda em uma chamada simples |
| Estrutural | Flyweight | Reaproveitar ingredientes repetidos |
| Estrutural | Proxy | Controlar acesso ao relatorio de vendas |
| Comportamental | Strategy | Calcular valor de entrega por retirada, bairro ou motoboy |
| Comportamental | State | Controlar estados do pedido: recebido, preparo, entrega e finalizado |
| Comportamental | Observer | Notificar cozinha e entrega quando o pedido mudar de estado |
| Comportamental | Command | Registrar acoes de pedido e permitir desfazer a ultima acao |
| Comportamental | Chain of Responsibility | Passar o pedido pelo fluxo atendimento, cozinha e entrega |
| Comportamental | Interpreter | Interpretar regras simples de desconto e taxa |
| Comportamental | Iterator | Percorrer fila de pedidos |
| Comportamental | Mediator | Centralizar comunicacao entre setores |
| Comportamental | Memento | Salvar e restaurar status anterior do pedido |
| Comportamental | Template Method | Definir passo a passo padrao de preparo |
| Comportamental | Visitor | Calcular imposto por tipo de item |

## Relacao com seus arquivos

| Sua pasta | Ideia usada antes | Relacao neste projeto |
|---|---|---|
| `PadraoBuilder` | Montagem de hamburguer com pao, carne e adicionais | Montagem de pedido completo com cliente, hamburguer, bebida, entrega e valor |
| `PadraoState` | Pedido avanca de Recebido para Em preparo, Pronto e Entregue | Pedido controla transicoes permitidas: recebido, em preparo, saiu para entrega, finalizado e cancelado |
| `PadraoCommand` | Atendente executa comandos da hamburgueria | Atendente executa preparar/cancelar pedido e pode desfazer a ultima acao |
| `PadraoObserver` | Cardapio notifica cliente, painel e delivery | Pedido monitorado notifica cozinha e entrega quando o status muda |
| `Chain of Responsibility` | Pedido passa por atendimento, cozinha e entrega | Pedido pago passa pela cadeia atendimento -> cozinha -> entrega |
| `PadraoDecorator` | Acrescenta comportamento sem alterar a base | Hamburguer simples recebe adicionais como bacon e queijo |
| `PadraoFacade` | Simplifica chamadas de varias classes | Atendimento realiza pedido, baixa estoque e chama pagamento em uma operacao |
| `PadraoAdapter` | Adapta uma classe externa para uma interface esperada | Pagamento em cartao adapta maquina externa ao gateway da hamburgueria |
| `AbstractFactoryVeiculos` | Cria familias de objetos relacionados | Cria familias de combos tradicional e vegano |
| `PadraoPrototype` | Clona um objeto modelo | Clona pedidos ou combos padrao |
| `BridgeVeiculos` | Separa abstracao de implementacao | Separa lanche e forma de preparo |
| `PadraoComposite` | Agrupa itens simples e compostos | Monta combos com varios produtos |
| `PadraoFlyweight` | Reaproveita objetos repetidos | Reaproveita ingredientes iguais |
| `PadraoProxy` | Controla acesso a um objeto real | Bloqueia relatorio para quem nao e gerente |
| `PadraoInterpreter` | Interpreta uma regra simples | Interpreta desconto e taxa de entrega |
| `PadraoIterator` | Percorre colecoes | Percorre fila de pedidos |
| `PadraoMediator` | Centraliza comunicacao | Central de pedidos conversa com setores |
| `PadraoMemento` | Salva e restaura estado | Restaura status anterior do pedido |
| `PadraoTemplateMethod` | Define algoritmo base | Define preparo padrao do lanche |
| `PadraoVisitor` | Aplica operacoes sobre objetos | Calcula imposto conforme tipo de item |

## Como montar o projeto

1. Abrir a pasta `ProjetoHamburgueria` em uma IDE Java.
2. Importar como projeto Maven.
3. Executar os testes em `src/test/java`.

## Operacoes cobertas

- Cadastro e montagem do pedido.
- Criacao de itens do cardapio.
- Inclusao de adicionais no hamburguer.
- Calculo da entrega.
- Controle de estoque.
- Pagamento por integracao externa.
- Mudanca de status do pedido.
- Notificacao dos setores da hamburgueria.
- Execucao e cancelamento de comandos operacionais.
- Encaminhamento do pedido entre atendimento, cozinha e entrega.
- Criacao de familias de combos.
- Clonagem de pedidos modelo.
- Montagem de combos compostos.
- Controle de acesso a relatorios.
- Restauracao de status anterior.
- Calculo de imposto por item.

