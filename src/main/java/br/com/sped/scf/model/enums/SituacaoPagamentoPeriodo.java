package br.com.sped.scf.model.enums;

import java.util.List;

public enum SituacaoPagamentoPeriodo  implements CustomEnum<SituacaoPagamentoPeriodo, Integer>
{
    PERIODO_PAGO(1,"Período Pago"),
    PERIODO_PARCIALMENTE_PAGO(2,"Período Parcialmente Pago"),
    PERIODO_NAO_PAGO(3,"Período Não Foi Pago");
	

  private final int codigo;
  private final String descricao;

  SituacaoPagamentoPeriodo(int codigo, String descricao)
  {
    this.codigo = codigo;
    this.descricao = descricao;
  }

  public static List<String> getListaDescricao()
  {
    return CustomEnum.getListaDescricao(SituacaoPagamentoPeriodo.class);
  }

  public static List<Integer> getListaValor()
  {
    return CustomEnum.getListaValor(SituacaoPagamentoPeriodo.class);
  }

  public static SituacaoPagamentoPeriodo[] getEnums()
  {
    return CustomEnum.getEnums(SituacaoPagamentoPeriodo.class);
  }

  public static SituacaoPagamentoPeriodo of(Integer codigo)
  {
    return CustomEnum.of(codigo, SituacaoPagamentoPeriodo.class);
  }

  public static SituacaoPagamentoPeriodo getByDescricao(String descricao)
  {
	  SituacaoPagamentoPeriodo[] sit = getEnums();
	  for (int i = 0; i < sit.length; i++){

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

