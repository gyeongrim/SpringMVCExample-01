package com.example.servingwebcontent.repository;

import jakarta.annotation.Generated;
import java.sql.JDBCType;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class CustomerDynamicSqlSupport {

	@Generated(value = "org.mybatis.generator.api.MyBatisGenerator", date = "2023-11-14T00:52:28.555884+09:00", comments = "Source Table: public.customer")
	public static final Customer customer = new Customer();
	@Generated(value = "org.mybatis.generator.api.MyBatisGenerator", date = "2023-11-14T00:52:28.556123+09:00", comments = "Source field: public.customer.id")
	public static final SqlColumn<String> id = customer.id;
	@Generated(value = "org.mybatis.generator.api.MyBatisGenerator", date = "2023-11-14T00:52:28.556374+09:00", comments = "Source field: public.customer.username")
	public static final SqlColumn<String> username = customer.username;
	@Generated(value = "org.mybatis.generator.api.MyBatisGenerator", date = "2023-11-14T00:52:28.556444+09:00", comments = "Source field: public.customer.email")
	public static final SqlColumn<String> email = customer.email;
	@Generated(value = "org.mybatis.generator.api.MyBatisGenerator", date = "2023-11-14T00:52:28.556486+09:00", comments = "Source field: public.customer.phone_number")
	public static final SqlColumn<String> phoneNumber = customer.phoneNumber;
	@Generated(value = "org.mybatis.generator.api.MyBatisGenerator", date = "2023-11-14T00:52:28.556527+09:00", comments = "Source field: public.customer.post_code")
	public static final SqlColumn<String> postCode = customer.postCode;

	@Generated(value = "org.mybatis.generator.api.MyBatisGenerator", date = "2023-11-14T00:52:28.556047+09:00", comments = "Source Table: public.customer")
	public static final class Customer extends AliasableSqlTable<Customer> {
		public final SqlColumn<String> id = column("id", JDBCType.VARCHAR);
		public final SqlColumn<String> username = column("username", JDBCType.VARCHAR);
		public final SqlColumn<String> email = column("email", JDBCType.VARCHAR);
		public final SqlColumn<String> phoneNumber = column("phone_number", JDBCType.VARCHAR);
		public final SqlColumn<String> postCode = column("post_code", JDBCType.VARCHAR);

		public Customer() {
			super("public.customer", Customer::new);
		}
	}
}