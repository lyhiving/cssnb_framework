/**
 * 
 */
package com.cssnb.commons.dialect;

/**
 * @author xuning email:xuningnb@163.com
 * @version creation time:2012-5-31下午4:08:48 类说明：
 * 
 */
public class DialectFactory {

	public static final String DEFAULT_DIALECT = "null";

	public static Dialect getDialect(String dialect) {
		if (dialect == null || "".equals(dialect)) {
			dialect = DEFAULT_DIALECT;
		}
		if ("mysql".equalsIgnoreCase(dialect)) {
			return new MySQLDialect();
		}
		
		if ("DB2".equalsIgnoreCase(dialect)) {
			return new DB2Dialect();
		}

		if ("Oracle".equalsIgnoreCase(dialect)) {
			return new OracleDialect();
		}
		
		if ("sqlserver".equalsIgnoreCase(dialect)) {
			return new SQLServerDialect();
		}
		
		if ("sqlserver2005".equalsIgnoreCase(dialect)) {
			return new SQLServer2005Dialect();
		}
		
		if ("sybase".equalsIgnoreCase(dialect)) {
			return new SybaseDialect();
		}
		
		if ("h2".equals(dialect)) {
			return new H2Dialect();
		}
		
		if ("hsql".equals(dialect)) {
			return new HSQLDialect();
		}

		return new NonSupportDialect();
	}

	private static class NonSupportDialect extends Dialect {

		public boolean supportsLimit() {
			return false;
		}
	}
}
