package br.com.sped.scf.model.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public interface CustomEnum<E extends Enum<E>, T>
{
  @JsonProperty(value = "id")
  T getValor();

  @JsonProperty(value = "valor")
  String getDescricao();

  static <E> E[] getEnums(Class<E> clazz)
  {
    return clazz.getEnumConstants();
  }

  static <E extends CustomEnum> List<String> getListaDescricao(Class<E> clazz)
  {
    return Arrays.stream(clazz.getEnumConstants()).map(e -> e.getDescricao()).collect(Collectors.toList());
  }

  static <E extends CustomEnum, T> List<T> getListaValor(Class<E> clazz)
  {
    return Arrays.stream(clazz.getEnumConstants()).map(e -> (T)e.getValor()).collect(Collectors.toList());
  }

  static <E extends CustomEnum, T> E of(T codigo, Class<E> clazz)
  {
    if(codigo == null) return null;
    return Arrays.stream(clazz.getEnumConstants()).filter(e -> codigo.equals(((CustomEnum)e).getValor())).findFirst().orElse(null);
  }
}