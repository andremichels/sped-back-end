package br.com.sped.scf.model.enums;

import java.util.List;

public enum DestaqueIcms implements CustomEnum<DestaqueIcms, Integer>
{
    TODOS(0,"Todos"),
	SIM(1,"Sim"),
    NAO(2,"Nao");

  

  private final int codigo;
  private final String descricao;

  DestaqueIcms(int codigo, String descricao)
  {
    this.codigo = codigo;
    this.descricao = descricao;
  }

  public static List<String> getListaDescricao()
  {
    return CustomEnum.getListaDescricao(DestaqueIcms.class);
  }

  public static List<Integer> getListaValor()
  {
    return CustomEnum.getListaValor(DestaqueIcms.class);
  }

  public static DestaqueIcms[] getEnums()
  {
    return CustomEnum.getEnums(DestaqueIcms.class);
  }

  public static DestaqueIcms of(Integer codigo)
  {
    return CustomEnum.of(codigo, DestaqueIcms.class);
  }

  public static DestaqueIcms getByDescricao(String descricao)
  {
	  DestaqueIcms[] sit = getEnums();
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




