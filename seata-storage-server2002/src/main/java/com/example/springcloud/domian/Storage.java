package com.example.springcloud.domian;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Wang Yuran
 * @create 2021-09-08 15:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage {
    private Long id;

    private  Long productId;

    private Integer total;

    private Integer used;
    private Integer residue;
}
