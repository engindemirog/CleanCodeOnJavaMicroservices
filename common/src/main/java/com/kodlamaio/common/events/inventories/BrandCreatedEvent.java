package com.kodlamaio.common.events.inventories;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class BrandCreatedEvent {
    private String id;
    private String name;
}
