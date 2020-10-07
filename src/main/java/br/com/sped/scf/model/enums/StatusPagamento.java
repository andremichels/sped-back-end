package br.com.sped.scf.model.enums;

import java.util.List;

public enum StatusPagamento implements CustomEnum<StatusPagamento, Integer>
{
	  PAGOU_PGDAS(1, "Pagou Pgdas"),
	  NAO_PAGOU_PGDAS(2, "Não Pagou Pgdas");

	  private final int codigo;
	  private final String descricao;

	  StatusPagamento(int codigo, String descricao)
	  {
	    this.codigo = codigo;
	    this.descricao = descricao;
	  }

	  public static List<String> getListaDescricao()
	  {
	    return CustomEnum.getListaDescricao(StatusPagamento.class);
	  }

	  public static List<Integer> getListaValor()
	  {
	    return CustomEnum.getListaValor(StatusPagamento.class);
	  }

	  public static StatusPagamento[] getEnums()
	  {
	    return CustomEnum.getEnums(StatusPagamento.class);
	  }

	  public static StatusPagamento of(Integer codigo)
	  {
	    return CustomEnum.of(codigo, StatusPagamento.class);
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
