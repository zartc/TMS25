package zc.study.struts1.domain;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;


/**
 * @author Pascal Jacob
 */
public class Cadeau implements Serializable {
	private static final long serialVersionUID = 1L;

	public String ref;
	public String description;
	public String libelle;
	public String type;
	public Boolean actif;


	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this);
		builder.append("ref", ref);
		builder.append("libelle", libelle);
		builder.append("description", description);
		builder.append("type", type);
		builder.append("actif", actif);
		return builder.toString();
	}
}

/* EOF */
