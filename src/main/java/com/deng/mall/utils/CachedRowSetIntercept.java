package com.deng.mall.utils;


import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.plugin.*;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Intercepts({@Signature(type = ResultSetHandler.class, method = "handleResultSets", args = {Statement.class})})
public class CachedRowSetIntercept implements Interceptor {
   @Override
   public Object intercept(Invocation invocation) throws Throwable {
       Object obj=invocation.proceed();
       if(obj instanceof ArrayList) {
    	   List<Object> resultList=(List<Object>) obj;
    	   for(Object o:resultList) {
    	   }
       }
       
       // 走原有逻辑
       return invocation.proceed();
   }

   @Override
   public Object plugin(Object target) {
       return Plugin.wrap(target, this);
   }

   @Override
   public void setProperties(Properties properties) {
   }
}
