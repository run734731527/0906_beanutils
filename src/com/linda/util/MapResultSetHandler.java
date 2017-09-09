package com.linda.util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;



public class MapResultSetHandler implements ResultSetHandler<Map<String,Object>> {
	@Override
	public Map<String, Object> handler(ResultSet rs) {
		Map<String,Object> map=null;
		try {
			if(rs.next()){
				ResultSetMetaData metaData=rs.getMetaData();
				map=new HashMap<>();
				for(int i=1;i<metaData.getColumnCount();i++){
					map.put(metaData.getColumnName(i), rs.getObject(i));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}

}
