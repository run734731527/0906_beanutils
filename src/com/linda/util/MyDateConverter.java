package com.linda.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.beanutils.Converter;

public class MyDateConverter implements Converter {

	@Override
	public <T> T convert(Class<T> clz, Object value) {
		T ret=null;
		if(Date.class==clz){
			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
			try {
				ret=(T)format.parse(value.toString());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ret;
		}else{
			return (T)value;
		}
	}

}
