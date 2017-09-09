package com.linda.util;

import java.sql.ResultSet;

public interface ResultSetHandler<T> {
T handler(ResultSet rs);
}
