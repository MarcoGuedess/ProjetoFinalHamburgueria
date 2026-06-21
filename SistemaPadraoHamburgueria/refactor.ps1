$baseDir = Join-Path $PSScriptRoot "src\main\java\br\com\hamburgueria"

$mapping = @{
    # estoque module
    "estoque\GerenciadorEstoque.java" = "estoque\singleton"
    "estoque\EstoqueProxy.java" = "estoque\proxy"
    "estoque\AcessoEstoque.java" = "estoque\proxy"
    "estoque\IngredienteFlyweight.java" = "estoque\flyweight"
    "estoque\FabricaIngredienteFlyweight.java" = "estoque\flyweight"
    
    # config module
    "config\ConfiguracaoLoja.java" = "config\singleton"
    
    # montagem module
    "montagem\FabricaLanche.java" = "montagem\factorymethod"
    "montagem\FabricaLancheTradicional.java" = "montagem\factorymethod"
    "montagem\FabricaLancheVegano.java" = "montagem\factorymethod"
    "montagem\ComboFactory.java" = "montagem\abstractfactory"
    "montagem\FabricaComboTradicional.java" = "montagem\abstractfactory"
    "montagem\FabricaComboVegano.java" = "montagem\abstractfactory"
    "montagem\PedidoBuilder.java" = "montagem\builder"
    "montagem\IngredienteAdicionalDecorator.java" = "montagem\decorator"
    "montagem\AdicionalBacon.java" = "montagem\decorator"
    
    # atendimento module
    "atendimento\TotemAtendimentoFacade.java" = "atendimento\facade"
    "atendimento\CanalEntrega.java" = "atendimento\bridge"
    "atendimento\AppDelivery.java" = "atendimento\bridge"
    "atendimento\RetiradaBalcao.java" = "atendimento\bridge"
    "atendimento\PedidoMemento.java" = "atendimento\memento"
    
    # promocao module
    "promocao\ValidacaoPedidoChain.java" = "promocao\chainofresponsibility"
    "promocao\ValidarLojaAberta.java" = "promocao\chainofresponsibility"
    "promocao\ValidarPedidoNaoVazio.java" = "promocao\chainofresponsibility"
    "promocao\Expressao.java" = "promocao\interpreter"
    "promocao\ExpressaoCupom.java" = "promocao\interpreter"
    "promocao\ExpressaoAnd.java" = "promocao\interpreter"
    
    # operacional module
    "operacional\AcaoCaixaCommand.java" = "operacional\command"
    "operacional\ComandoAbrirCaixa.java" = "operacional\command"
    "operacional\ComandoProcessarVenda.java" = "operacional\command"
    "operacional\CentralOperacoesMediator.java" = "operacional\mediator"
    "operacional\Observer.java" = "operacional\observer"
    "operacional\Observable.java" = "operacional\observer"
    "operacional\PainelCozinha.java" = "operacional\observer"
    "operacional\AppCliente.java" = "operacional\observer"
    "operacional\PreparoLancheTemplate.java" = "operacional\templatemethod"
    "operacional\PreparoBovino.java" = "operacional\templatemethod"
    "operacional\PreparoVegano.java" = "operacional\templatemethod"
    
    # estado module
    "estado\PedidoState.java" = "estado\state"
    "estado\EstadoNovo.java" = "estado\state"
    "estado\EstadoEmPreparo.java" = "estado\state"
    "estado\EstadoPronto.java" = "estado\state"
    "estado\EstadoEntregue.java" = "estado\state"
    
    # pagamento module
    "pagamento\EstrategiaPagamento.java" = "pagamento\strategy"
    "pagamento\PagamentoPix.java" = "pagamento\strategy"
    "pagamento\GatewayPagamentoAdapter.java" = "pagamento\adapter"
    "pagamento\GatewayCartaoExterno.java" = "pagamento\adapter"
    
    # relatorio module
    "relatorio\ItemPedidoVisitor.java" = "relatorio\visitor"
    "relatorio\RelatorioFinanceiroVisitor.java" = "relatorio\visitor"
    
    # cardapio module
    "cardapio\CardapioIterator.java" = "cardapio\iterator"
    "cardapio\Combo.java" = "cardapio\composite"
}

$classToNewPkg = @{}
foreach ($key in $mapping.Keys) {
    $className = (Split-Path $key -Leaf) -replace "\.java",""
    $subPkg = $mapping[$key] -replace "\\","."
    $classToNewPkg[$className] = "br.com.hamburgueria.$subPkg"
}

$classToNewPkg["Pedido"] = "br.com.hamburgueria.dominio"
$classToNewPkg["Cliente"] = "br.com.hamburgueria.dominio"
$classToNewPkg["Dinheiro"] = "br.com.hamburgueria.dominio"
$classToNewPkg["ItemPedido"] = "br.com.hamburgueria.dominio"
$classToNewPkg["Lanche"] = "br.com.hamburgueria.cardapio"
$classToNewPkg["Bebida"] = "br.com.hamburgueria.cardapio"
$classToNewPkg["Acompanhamento"] = "br.com.hamburgueria.cardapio"
$classToNewPkg["LancheTradicional"] = "br.com.hamburgueria.cardapio"
$classToNewPkg["LancheVegano"] = "br.com.hamburgueria.cardapio"
$classToNewPkg["Refrigerante"] = "br.com.hamburgueria.cardapio"
$classToNewPkg["BatataFrita"] = "br.com.hamburgueria.cardapio"
$classToNewPkg["Cardapio"] = "br.com.hamburgueria.cardapio"

foreach ($key in $mapping.Keys) {
    $srcFile = Join-Path $baseDir $key
    $destSubPath = $mapping[$key]
    $destDir = Join-Path $baseDir $destSubPath
    
    if (Test-Path $srcFile) {
        if (-not (Test-Path $destDir)) {
            New-Item -ItemType Directory -Force -Path $destDir | Out-Null
        }
        
        $destFile = Join-Path $destDir (Split-Path $srcFile -Leaf)
        Move-Item -Path $srcFile -Destination $destFile -Force
        
        $content = Get-Content $destFile -Raw
        $oldPkg = "package br.com.hamburgueria." + (($key -split "\\")[0]) + ";"
        $newPkg = "package br.com.hamburgueria." + ($destSubPath -replace "\\",".") + ";"
        
        $content = $content -replace [regex]::Escape($oldPkg), $newPkg
        Set-Content $destFile $content
    }
}

$allFiles = Get-ChildItem -Path (Join-Path $PSScriptRoot "src") -Recurse -Filter "*.java"

foreach ($file in $allFiles) {
    $content = Get-Content $file.FullName -Raw
    $originalContent = $content
    
    $importsToAdd = @()
    foreach ($className in $classToNewPkg.Keys) {
        if ($file.Name -eq "$className.java") { continue }
        
        if ($content -match "\b$className\b") {
            $pkg = $classToNewPkg[$className]
            $importStmt = "import $pkg.$className;"
            $importsToAdd += $importStmt
        }
    }
    
    $content = $content -replace "(?m)^import br\.com\.hamburgueria\..*;\r?\n?", ""
    
    if ($importsToAdd.Count -gt 0) {
        $importsToAdd = $importsToAdd | Sort-Object -Unique
        $importsStr = ($importsToAdd -join "`n") + "`n"
        
        $content = $content -replace "(?m)^(package .*;)\r?\n", "`$1`n`n$importsStr"
    }
    
    if ($content -ne $originalContent) {
        Set-Content $file.FullName $content
    }
}
