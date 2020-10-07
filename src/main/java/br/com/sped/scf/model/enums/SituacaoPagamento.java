package br.com.sped.scf.model.enums;

import java.util.List;


public enum SituacaoPagamento implements CustomEnum<SituacaoPagamento, Integer>
{
    EM_ATRASO(1,"Parcelamento em Atraso"),
    EM_DIAS(2,"Parcelamento em Dia"),
    ENCERRADO(3,"Parcelamento Encerrado");
	

  private final int codigo;
  private final String descricao;

  SituacaoPagamento(int codigo, String descricao)
  {
    this.codigo = codigo;
    this.descricao = descricao;
  }

  public static List<String> getListaDescricao()
  {
    return CustomEnum.getListaDescricao(SituacaoPagamento.class);
  }

  public static List<Integer> getListaValor()
  {
    return CustomEnum.getListaValor(SituacaoPagamento.class);
  }

  public static SituacaoPagamento[] getEnums()
  {
    return CustomEnum.getEnums(SituacaoPagamento.class);
  }

  public static SituacaoPagamento of(Integer codigo)
  {
    return CustomEnum.of(codigo, SituacaoPagamento.class);
  }

  public static SituacaoPagamento getByDescricao(String descricao)
  {
	  SituacaoPagamento[] sit = getEnums();
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
