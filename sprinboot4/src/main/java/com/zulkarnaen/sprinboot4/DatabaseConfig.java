package com.zulkarnaen.sprinboot4;

import javax.sql.DataSource;

public interface DatabaseConfig {

	DataSource createDataSourceDev();

	DataSource createDataSourceProd();
}
