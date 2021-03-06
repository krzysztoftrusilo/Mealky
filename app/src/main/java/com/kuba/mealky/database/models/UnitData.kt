package com.kuba.mealky.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey


@Entity(tableName = "unit", indices = [(Index("name"))])
data class UnitData(
        @PrimaryKey(autoGenerate = true) var unit_id: Long?,
        @ColumnInfo(name = "name") var name: String
) {
    constructor() : this(null, "")
}