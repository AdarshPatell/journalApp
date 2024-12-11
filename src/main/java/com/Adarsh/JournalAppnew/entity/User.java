package com.Adarsh.JournalAppnew.entity;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "users")
@Data
@Getter
@Setter
@Builder
public class User {
    @Id
    private ObjectId id;
    @Indexed(unique = true)

    @NonNull
    private String userName;

    @NonNull
    private String password;
    @DBRef
    @Builder.Default
    private List<JournalEntry> journalEntries=new ArrayList<>();

    private  List<String> roles;
//    private List<String> roles;

}

