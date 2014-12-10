package zc.study.struts1.domain;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Cadeau implements Serializable {
	private static final long serialVersionUID = 1L;

	public String marche;
	public String lang;
	public String type;
	public Boolean actif;
	public String libelle;
	
	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this);
		builder.append("marche", marche);
		builder.append("lang", lang);
		builder.append("type", type);
		builder.append("actif", actif);
		builder.append("libelle", libelle);
		return builder.toString();
	}
}

/* EOF */
