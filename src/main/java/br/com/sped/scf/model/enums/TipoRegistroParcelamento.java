package br.com.sped.scf.model.enums;

import java.util.List;


public enum TipoRegistroParcelamento implements CustomEnum<TipoRegistroParcelamento, Integer>
{
	  PEDIDO_PARCELAMENTO(1, "Informações do Pedido de Parcelamento"),
	  INFORMACOES_CONSOLIDACAO(2, "Informações da Consolidação"),
	  RELACOES_DEBITOS(3, "Relações de Débitos"),
	  RELACOES_PAGAMENTOS(4, "Relações de Pagamentos ");


	  private final int codigo;
	  private final String descricao;

	  TipoRegistroParcelamento(int codigo, String descricao)
	  {
	    this.codigo = codigo;
	    this.descricao = descricao;
	  }

	  public static List<String> getListaDescricao()
	  {
	    return CustomEnum.getListaDescricao(TipoRegistroParcelamento.class);
	  }

	  public static List<Integer> getListaValor()
	  {
	    return CustomEnum.getListaValor(TipoRegistroParcelamento.class);
	  }

	  public static TipoRegistroParcelamento[] getEnums()
	  {
	    return CustomEnum.getEnums(TipoRegistroParcelamento.class);
	  }

	  public static TipoRegistroParcelamento of(Integer codigo)
	  {
	    return CustomEnum.of(codigo, TipoRegistroParcelamento.class);
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
