package br.com.sped.scf.model.enums;

import java.util.List;

public enum SituacaoAdimplemento implements CustomEnum<SituacaoAdimplemento, Integer>
{
    ADIMPLENTE(1,"Adimplente"),
    INADIMPLENTE(2,"Inadimplente");

  

  private final int codigo;
  private final String descricao;

  SituacaoAdimplemento(int codigo, String descricao)
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
    return CustomEnum.getListaValor(SituacaoAdimplemento.class);
  }

  public static SituacaoAdimplemento[] getEnums()
  {
    return CustomEnum.getEnums(SituacaoAdimplemento.class);
  }

  public static SituacaoAdimplemento of(Integer codigo)
  {
    return CustomEnum.of(codigo, SituacaoAdimplemento.class);
  }

  public static SituacaoAdimplemento getByDescricao(String descricao)
  {
	  SituacaoAdimplemento[] sit = getEnums();
	  for (int i = 0; i < sit.length; i++){

		  if(sit[i].getDescricao().equalsIgnoreCase(descricao))
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


