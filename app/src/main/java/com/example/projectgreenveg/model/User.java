package com.example.projectgreenveg.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "user",
        indices = {
                @Index("id")
        }
)

public class User {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id_user")
    private Integer id_user;

    @NonNull
    @ColumnInfo(name = "nama")
    private String nama;

    @NonNull
    @ColumnInfo(name = "email")
    private String email;

    @NonNull
    @ColumnInfo(name = "password")
    private String password;

    @NonNull
    @ColumnInfo(name = "telp")
    private String telp;
}
