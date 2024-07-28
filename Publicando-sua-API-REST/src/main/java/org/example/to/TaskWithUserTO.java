package org.example.to;

import lombok.Data;

import java.util.UUID;

@Data
public class TaskWithUserTO {
    UUID userId;
    String title;
    String description;
}
