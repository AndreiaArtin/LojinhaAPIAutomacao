package dataFactory;

import pojo.ComponentePojo;
import pojo.ProdutoPojo;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDataFactory {
    public static ProdutoPojo criarProdutoComunComValorIgualA(double valor) {
        ProdutoPojo produto = new ProdutoPojo();
        produto.setProdutoNome("robo");
        produto.setProdutoValor(valor);

        List<String> cores = new ArrayList<>();
        cores.add("preto");
        cores.add("vermelho");

        produto.setProdutoCores(cores);
        produto.setProdutoUrlMock("");

        List<ComponentePojo> componentes = new ArrayList<>();

        ComponentePojo componente = new ComponentePojo();
        componente.setComponenteNome("vassouras");
        componente.setComponenteQuantidade(2);
        componentes.add(componente);

        ComponentePojo segundocomponente = new ComponentePojo();
        segundocomponente.setComponenteNome("filtro");
        segundocomponente.setComponenteQuantidade(1);
        componentes.add(segundocomponente);

        produto.setComponentes(componentes);

        return produto;
    }

}
