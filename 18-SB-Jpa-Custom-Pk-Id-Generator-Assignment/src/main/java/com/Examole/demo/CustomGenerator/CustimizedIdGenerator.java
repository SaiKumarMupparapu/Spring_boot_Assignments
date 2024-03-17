package com.Examole.demo.CustomGenerator;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

@SuppressWarnings("serial")
public class CustimizedIdGenerator implements IdentifierGenerator {

	private static final String prefix="C";
	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {

		@SuppressWarnings("deprecation")
		Long maxId = (Long)session
		.createQuery("select max(cast(subString(c.id,2)as long)) from Customer c")
		.uniqueResult();
		
		maxId=(maxId == null)?0L:maxId;
		
		String newId=prefix+(maxId+1);
		
		return newId;
	}

}
