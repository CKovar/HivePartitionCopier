package com.amazonaws.services.emr.copyhivepartitions;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class HiveSerdeParam {
  
  public int SERDE_ID = 0; 
  public String PARAM_KEY;
  public String PARAM_VALUE; 
  
  
  public HiveSerdeParam(ResultSet resultSet, HashMap<Integer, Integer> serdemap) throws SQLException{
    SERDE_ID = serdemap.get(resultSet.getInt("SERDE_ID"));
    PARAM_KEY = resultSet.getString("PARAM_KEY");
    PARAM_VALUE = resultSet.getString("PARAM_VALUE");
    
  }
  public static String ToSQLInsertPrefix(){
    String sqlout = "INSERT INTO SERDE_PARAMS " +
     "(SERDE_ID, PARAM_KEY, PARAM_VALUE) "
        + "VALUES "; 
       return sqlout; 
  }
  
  public String ToSQLInsert(boolean isFirst){
    String sqlout = "";
    if(!isFirst){
      sqlout+= ",";
    }
    sqlout += "(" +SERDE_ID+ ", '" +PARAM_KEY+ "', '"+PARAM_VALUE+"')"; 
    return sqlout; 
  }

}
