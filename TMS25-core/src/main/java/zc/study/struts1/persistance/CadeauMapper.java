/*
 *    Copyright 2010-2013 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package zc.study.struts1.persistance;

import java.util.List;

import zc.study.struts1.domain.Cadeau;


/**
 * @author Pascal Jacob
 */
public interface CadeauMapper {

	enum Status {
		actif, inactif, all
	};


	List<Cadeau> getAll();
	
	Cadeau getByRef(String ref);

	List<Cadeau>  getByType(String type);
	
	List<Cadeau>  getByStatus(Status status);

	void insertCadeau(Cadeau cadeau);

	void updateCadeau(Cadeau cadeau);

	void activateCadeau(Cadeau cadeau);

	void inactivateCadeau(Cadeau cadeau);

	void deleteCadeau(Cadeau cadeau);
}

/* EOF */
