import os
import shutil
import glob
import re

base_dir = r"c:\Users\Admin\Desktop\Programação\Faculdade\Padroes_de_Projeto\PadrãoHamburgueria\SistemaHamburgueria\SistemaPadraoHamburgueria\src\main\java\br\com\hamburgueria"
test_dir = r"c:\Users\Admin\Desktop\Programação\Faculdade\Padroes_de_Projeto\PadrãoHamburgueria\SistemaHamburgueria\SistemaPadraoHamburgueria\src\test\java\br\com\hamburgueria"

# Mapping ClassName (without .java) to its new subpackage
class_mapping = {
    # Singleton
    "GerenciadorEstoque": "singleton",
    "ConfiguracaoLoja": "singleton",
    # Factory Method
    "FabricaLanche": "factorymethod",
    "FabricaLancheTradicional": "factorymethod",
    "FabricaLancheVegano": "factorymethod",
    # Abstract Factory
    "ComboFactory": "abstractfactory",
    "FabricaComboTradicional": "abstractfactory",
    "FabricaComboVegano": "abstractfactory",
    # Builder
    "PedidoBuilder": "builder",
    # Adapter
    "GatewayPagamentoAdapter": "adapter",
    "GatewayCartaoExterno": "adapter",
    # Bridge
    "CanalEntrega": "bridge",
    "AppDelivery": "bridge",
    "RetiradaBalcao": "bridge",
    # Composite
    "Combo": "composite",
    # Decorator
    "IngredienteAdicionalDecorator": "decorator",
    "AdicionalBacon": "decorator",
    # Facade
    "TotemAtendimentoFacade": "facade",
    # Flyweight
    "IngredienteFlyweight": "flyweight",
    "FabricaIngredienteFlyweight": "flyweight",
    # Proxy
    "AcessoEstoque": "proxy",
    "EstoqueProxy": "proxy",
    # Chain of Responsibility
    "ValidacaoPedidoChain": "chainofresponsibility",
    "ValidarLojaAberta": "chainofresponsibility",
    "ValidarPedidoNaoVazio": "chainofresponsibility",
    # Command
    "AcaoCaixaCommand": "command",
    "ComandoAbrirCaixa": "command",
    "ComandoProcessarVenda": "command",
    # Interpreter
    "Expressao": "interpreter",
    "ExpressaoCupom": "interpreter",
    "ExpressaoAnd": "interpreter",
    # Iterator
    "CardapioIterator": "iterator",
    "Cardapio": "iterator",
    # Mediator
    "CentralOperacoesMediator": "mediator",
    # Memento
    "PedidoMemento": "memento",
    # Observer
    "Observer": "observer",
    "Observable": "observer",
    "PainelCozinha": "observer",
    "AppCliente": "observer",
    # State
    "PedidoState": "state",
    "EstadoNovo": "state",
    "EstadoEmPreparo": "state",
    "EstadoPronto": "state",
    "EstadoEntregue": "state",
    # Strategy
    "EstrategiaPagamento": "strategy",
    "PagamentoPix": "strategy",
    # Template Method
    "PreparoLancheTemplate": "templatemethod",
    "PreparoBovino": "templatemethod",
    "PreparoVegano": "templatemethod",
    # Visitor
    "ItemPedidoVisitor": "visitor",
    "RelatorioFinanceiroVisitor": "visitor",
    
    # Dominio
    "Cliente": "dominio",
    "Dinheiro": "dominio",
    "ItemPedido": "dominio",
    "Lanche": "dominio",
    "Bebida": "dominio",
    "Acompanhamento": "dominio",
    "LancheTradicional": "dominio",
    "LancheVegano": "dominio",
    "Refrigerante": "dominio",
    "BatataFrita": "dominio",
    "Pedido": "dominio"
}

all_java_files = []
for root, dirs, files in os.walk(base_dir):
    for f in files:
        if f.endswith(".java"):
            all_java_files.append(os.path.join(root, f))

# Also include test file for import updates
test_file = os.path.join(test_dir, "SistemaCompletoTest.java")

print(f"Found {len(all_java_files)} java files.")

for file_path in all_java_files:
    filename = os.path.basename(file_path)
    class_name = filename[:-5]
    
    if class_name not in class_mapping:
        print(f"Warning: {class_name} not found in mapping!")
        continue
        
    subpackage = class_mapping[class_name]
    new_package = f"br.com.hamburgueria.{subpackage}"
    new_dir = os.path.join(base_dir, subpackage)
    os.makedirs(new_dir, exist_ok=True)
    
    new_file_path = os.path.join(new_dir, filename)
    
    with open(file_path, "r", encoding="utf-8") as f:
        content = f.read()
        
    # Update package
    content = re.sub(r"^package br\.com\.hamburgueria\.[a-z]+;", f"package {new_package};", content, flags=re.MULTILINE)
    
    # Find all br.com.hamburgueria imports and remove them temporarily
    content = re.sub(r"^import br\.com\.hamburgueria\.[a-z]+\.[A-Za-z]+;\n?", "", content, flags=re.MULTILINE)
    
    # Discover which classes are used in this file
    imports_to_add = set()
    for other_class, other_subpkg in class_mapping.items():
        if other_class != class_name and other_subpkg != subpackage:
            # Check if other_class is mentioned in the code as a full word
            if re.search(r'\b' + other_class + r'\b', content):
                imports_to_add.add(f"import br.com.hamburgueria.{other_subpkg}.{other_class};")
    
    # Add the necessary imports right after the package declaration
    if imports_to_add:
        imports_str = "\n".join(sorted(imports_to_add))
        content = re.sub(r"^(package .+;)(?:\r?\n)+", r"\1\n\n" + imports_str + "\n\n", content)

    with open(new_file_path, "w", encoding="utf-8") as f:
        f.write(content)
        
    if new_file_path != file_path:
        os.remove(file_path)

# Update the test file
with open(test_file, "r", encoding="utf-8") as f:
    test_content = f.read()

# Remove old internal imports
test_content = re.sub(r"^import br\.com\.hamburgueria\.[a-z]+\.[A-Za-z*]+;\n?", "", test_content, flags=re.MULTILINE)

test_imports_to_add = set()
for other_class, other_subpkg in class_mapping.items():
    if re.search(r'\b' + other_class + r'\b', test_content):
        test_imports_to_add.add(f"import br.com.hamburgueria.{other_subpkg}.{other_class};")

if test_imports_to_add:
    imports_str = "\n".join(sorted(test_imports_to_add))
    test_content = re.sub(r"^(package .+;)(?:\r?\n)+", r"\1\n\n" + imports_str + "\n\n", test_content)

with open(test_file, "w", encoding="utf-8") as f:
    f.write(test_content)

# Clean up empty directories
for root, dirs, files in os.walk(base_dir, topdown=False):
    for d in dirs:
        dir_path = os.path.join(root, d)
        if not os.listdir(dir_path):
            os.rmdir(dir_path)

print("Refactoring complete.")
