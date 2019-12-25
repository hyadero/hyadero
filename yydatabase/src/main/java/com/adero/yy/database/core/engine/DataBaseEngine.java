package com.adero.yy.database.core.engine;

import com.alibaba.druid.sql.ast.SQLStatement;

public interface DataBaseEngine {
    void execute(SQLStatement sqlStatement);
}
