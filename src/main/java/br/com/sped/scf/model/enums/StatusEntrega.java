package br.com.sped.scf.model.enums;

import java.util.List;

public enum StatusEntrega implements CustomEnum<StatusEntrega, Integer>
{
	  ENTREGOU(1, "Entregou Pgdas"),
	  NAO_ENTREGOU(2, "Não Entregou");

	  private final int codigo;
	  private final String descricao;

	  StatusEntrega(int codigo, String descricao)
	  {
	    this.codigo = codigo;
	    this.descricao = descricao;
	  }

	  public static List<String> getListaDescricao()
	  {
	    return CustomEnum.getListaDescricao(StatusEntrega.class);
	  }

	  public static List<Integer> getListaValor()
	  {
	    return CustomEnum.getListaValor(StatusEntrega.class);
	  }

	  public static StatusEntrega[] getEnums()
	  {
	    return CustomEnum.getEnums(StatusEntrega.class);
	  }

	  public static StatusEntrega of(Integer codigo)
	  {
	    return CustomEnum.of(codigo, StatusEntrega.class);
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
