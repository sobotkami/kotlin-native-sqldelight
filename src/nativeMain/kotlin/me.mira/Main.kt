package me.mira

import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver
import me.mira.database.DbHockey

fun main() {
    val driver: SqlDriver = NativeSqliteDriver(DbHockey.Schema, "test.db")
    val database = DbHockey(driver)

    database.dbHockeyQueries.selectAll().executeAsList().forEach {
        println(it)
    }
}