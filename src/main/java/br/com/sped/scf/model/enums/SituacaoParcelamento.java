package br.com.sped.scf.model.enums;

import java.util.List;


public enum SituacaoParcelamento implements CustomEnum<SituacaoParcelamento, Integer>
{

    EM_PARCELAMENTO(3, "Em Parcelamento"),
    ENCERRADO_A_PEDIDO_CONTRIBUINTE(4, "Encerrado a Pedido do Contribuinte"),
    ENCERRADO_POR_LIQUIDACAO(5, "Encerrado Por Liquidação"),
    ENCERRADO_POR_RESCISAO(6,"Encerrado por Rescisão");


  private final int codigo;
  private final String descricao;

  SituacaoParcelamento(int codigo, String descricao)
  {
    this.codigo = codigo;
    this.descricao = descricao;
  }

  public static List<String> getListaDescricao()
  {
    return CustomEnum.getListaDescricao(SituacaoParcelamento.class);
  }

  public static List<Integer> getListaValor()
  {
    return CustomEnum.getListaValor(SituacaoParcelamento.class);
  }

  public static SituacaoParcelamento[] getEnums()
  {
    return CustomEnum.getEnums(SituacaoParcelamento.class);
  }

  public static SituacaoParcelamento of(Integer codigo)
  {
    return CustomEnum.of(codigo, SituacaoParcelamento.class);
  }
  public static SituacaoParcelamento getByDescricao(String descricao)
  {
	  SituacaoParcelamento[] sit = getEnums();
	  for (int i = 0; i < sit.length; i++) {
		
		  if(sit[i].getDescricao().equals(descricao))
			  return sit[i]; 
	  }
	  return null;
  }

  
  
  @Override
  public Integer getValor()
  {
    return codigo;
  }

  @Override
  public String getDescricao()
  {
    return descricao;
  }
}

