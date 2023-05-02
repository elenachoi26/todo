package com.youbeen.todo.data.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

public class TodoDto {
    private int id;
    private String title;
    private String description;

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }
    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title){
        this.title = title;
    }
    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description){
        this.description = description;
    }
}
