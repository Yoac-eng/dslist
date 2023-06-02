package com.yoacspring.dslist.projections;

// Essa classe contém os gets dos dados que serão retornados na consulta SQL
public interface GameMinProjection {

	Long getId(); 
	String getTitle();
	Integer getYear();
	String getImgUrl();
	String getShortDescription();
	Integer getPosition();
}
